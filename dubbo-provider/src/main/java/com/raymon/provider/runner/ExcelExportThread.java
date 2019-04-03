package com.raymon.provider.runner;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.raymon.api.bean.excelExport.ColumnInfo;
import com.raymon.api.pojo.excelExport.ExcelExportPojo;
import com.raymon.api.service.excelExport.ExcelExportInfoCommonService;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.streaming.SXSSFCell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ExcelExportThread extends Thread{
    private static final Logger log =  LoggerFactory.getLogger(ExcelExportThread.class);

    public static final ThreadLocal<ExcelExportThread> current = new ThreadLocal<>();
    private static final long DEFAULT_SLEEP_TIME = 5000L;

    private static final String STATUS_NEW = "NEW";
    private static final String STATUS_RUNNING = "RUNNING";
    private static final String STATUS_ERROR = "ERROR";
    private static final String STATUS_FINISH = "FINISH";
    public static boolean exit = false;

    private ExcelExportInfoCommonService excelExportInfoCommonService;
    private JdbcTemplate jdbcTemplate;
    private File savePath;



    public ExcelExportThread(ExcelExportInfoCommonService excelExportInfoCommonService, JdbcTemplate jdbcTemplate, String filePath) {
        super();
        this.excelExportInfoCommonService = excelExportInfoCommonService;
        this.jdbcTemplate = jdbcTemplate;
        this.savePath = new File(filePath);
        current.set(this);
    }

    @Override
    public void run() {
        int maxRowNumber = 1000000;
        ExcelExportPojo info = new ExcelExportPojo();
        info.setStatus(STATUS_NEW);
//        1. 找到最新的一条未导出的数据记录
//        2. 获取sql和列配置
//        3. 通过sql查询出结果，并根据列配置生成excel文件
//        4. 更新文件路径以及生成状态
        while (true) {
            if (exit) {
                break;
            }
            Optional<ExcelExportPojo> firstOne = excelExportInfoCommonService.findFirstByStatusOrderByCreationDate(STATUS_NEW);
            if (!firstOne.isPresent()) {
//                没数据时休眠一段时间
                try {
                    Thread.sleep(DEFAULT_SLEEP_TIME);
                    continue;
                } catch (InterruptedException e) {
                    // pass
                }
            }
            Date now = new Date(System.currentTimeMillis());
            ExcelExportPojo excelExportInfo = firstOne.get();
            String sqlContent = excelExportInfo.getSqlContent();
            String columnInfo = excelExportInfo.getColumnInfo();

            if (StringUtils.isEmpty(sqlContent) || StringUtils.isEmpty(columnInfo)) {
                excelExportInfo.setStatus(STATUS_ERROR);
                excelExportInfo.setLastUpdateDate(now);
                excelExportInfoCommonService.save(excelExportInfo);
                continue;
            }

//            开始生成文件
            try {
                JSONArray originColumns = JSON.parseArray(columnInfo);

                JSONArray realColumns = parseColumns(originColumns);
//            修改状态为运行中
                excelExportInfo.setStatus(STATUS_RUNNING);
                excelExportInfoCommonService.save(excelExportInfo);

//                初始化excel
                SXSSFWorkbook wb = new SXSSFWorkbook(50);
                CellStyle dateFormat = wb.createCellStyle();
                dateFormat.setDataFormat(wb.createDataFormat().getFormat("yyyy-MM-DD HH:mm"));
                dateFormat.setAlignment(HorizontalAlignment.CENTER);

                DataFormat dataFormat = wb.createDataFormat();
                CellStyle textStyle = wb.createCellStyle();
                textStyle.setDataFormat(dataFormat.getFormat("@"));

                final AtomicInteger rowCount = new AtomicInteger(0);
                final AtomicInteger sheetIndex = new AtomicInteger(1);
                final SXSSFSheet[] sheet = {wb.createSheet()};

                createHeaderRow(originColumns, wb, sheet[0], rowCount);

                jdbcTemplate.query(sqlContent, (resultSet, rowNum) -> sheet[0] = createSheet(wb, sheet[0], resultSet, rowCount, sheetIndex, maxRowNumber, originColumns, realColumns, dateFormat, textStyle));

//                导出完成，更新状态及文件路径
                String uuid = UUID.randomUUID().toString();
                String fileName = "excel" + uuid;
                File file = new File(savePath, fileName);
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                wb.write(fileOutputStream);
                excelExportInfo.setSavePath(file.getAbsolutePath());
                excelExportInfo.setStatus(STATUS_FINISH);
                excelExportInfo.setLastUpdateDate(now);
                excelExportInfoCommonService.save(excelExportInfo);

            } catch (Exception e) {
                log.error("Export excel file failed.", e);
                excelExportInfo.setStatus(STATUS_ERROR);
                excelExportInfoCommonService.save(excelExportInfo);
            }
        }
    }

    private JSONArray parseColumns(JSONArray originColumns) {
        JSONArray columns = new JSONArray();
        if (originColumns == null) {
            return columns;
        }
        for (int i = 0; i < originColumns.size(); i++) {
            JSONObject originColumn = originColumns.getJSONObject(i);
            boolean hasColumn = originColumn.containsKey("column");
            if (hasColumn) {
//            有嵌套
                JSONArray nestColumn = originColumn.getJSONArray("column");
                columns.addAll(parseColumns(nestColumn));
            } else {
//                直接加上名字
                columns.add(originColumn);
            }
        }

        return columns;
    }

    private SXSSFSheet createSheet(SXSSFWorkbook wb, SXSSFSheet sheet, Object object, AtomicInteger count,
                                   AtomicInteger rowIndex, int rowMaxNumber, JSONArray columnInfos, JSONArray realColumnInfos,
                                   CellStyle dateFormat, CellStyle textStyle) {

        if (count.get() % rowMaxNumber == 0) {
            sheet = wb.createSheet();
            count.set(0);
            createHeaderRow(columnInfos, wb, sheet, count);
        }
        SXSSFRow row = sheet.createRow(count.getAndIncrement());

        createRow(realColumnInfos, object, row, dateFormat, textStyle);
        return sheet;
    }

    private void createRow(JSONArray columnInfos, Object object, SXSSFRow row, CellStyle dateFormat, CellStyle textStyle) {

        for (int columnIndex = 0; columnIndex < columnInfos.size(); columnIndex++) {
            Object fieldObject = null;
            JSONObject columnInfo = columnInfos.getJSONObject(columnIndex);
            String columnName = columnInfo.getString("name");
            try {
                if (object instanceof ResultSet) {
                    fieldObject = ((ResultSet) object).getObject(columnName);
                } else if (object instanceof Map) {
                    fieldObject = ((Map) object).get(columnName);
                } else {
                    fieldObject = PropertyUtils.getProperty(object, columnName);
                }

            } catch (Exception e) {
                log.trace("Get value from object.", e);
            }
//            String type = columnInfos.get(columnIndex).getType();
//            FIXME: modelOutput中提供的列配置中没有类型，暂时全部当做字符串
            String type = detectType(fieldObject);

            SXSSFCell cell = row.createCell(columnIndex);

            if (null == fieldObject) {

                cell.setCellType(CellType.STRING);
                cell.setCellValue((String) null);
            } else {

                switch (type.toUpperCase(Locale.CHINA)) {
                    case "NUMBER":
                    case "FLOAT":
                        cell.setCellStyle(textStyle);
                        cell.setCellType(CellType.NUMERIC);
                        cell.setCellValue(((Number) fieldObject).doubleValue());
                        break;
                    case "DOUBLE":
                        cell.setCellStyle(textStyle);
                        cell.setCellType(CellType.NUMERIC);
                        cell.setCellValue(fieldObject.toString());
                        break;
                    case "INT":
                    case "INTEGER":
                    case "LONG":
                        cell.setCellStyle(textStyle);
                        cell.setCellType(CellType.NUMERIC);
                        cell.setCellValue(fieldObject.toString());
                        break;
                    case "DATE":
                        cell.setCellStyle(dateFormat);
                        cell.setCellValue((Date) fieldObject);
                        break;
                    case "BOOLEAN":
                        cell.setCellType(CellType.BOOLEAN);
                        if (fieldObject instanceof Boolean) {
                            cell.setCellValue((Boolean) fieldObject);
                        } else {
                            cell.setCellValue(fieldObject.toString());
                        }
                        break;
                    default:
                        cell.setCellType(CellType.STRING);
                        String value = fieldObject.toString();
                        if (value != null && value.contains("00:00:00.0")) {
                            value = value.replace("00:00:00.0", "");
                        }
                        cell.setCellValue(value);
                        break;
                }
            }
        }
    }

    private String detectType(Object fieldObject) {
        String type = "STRING";
        if (fieldObject == null) {
            return type;
        }
        if (fieldObject instanceof Number) {
            type = "NUMBER";
        } else if (fieldObject instanceof Date) {
            type = "DATE";
        }

        return type;
    }

    private void createHeaderRow(JSONArray columnInfos, SXSSFWorkbook wb, SXSSFSheet sheet, AtomicInteger rowCount) {
        List<ColumnInfo> columns = columnInfos.toJavaList(ColumnInfo.class);
        int maxDepth = getMaxDepth(columns);
//        只有单行表头的

        if (maxDepth == 1) {
            createSingleHeaderRow(wb, sheet, columns, rowCount);
            return;
        }
        int rowIndex = rowCount.get();
        for (int i = 0; i < maxDepth; i++) {
            rowCount.getAndIncrement();
        }

        createSubHeaderRow(wb, sheet, columns, maxDepth, 1, rowIndex, 0);
    }

    private void createSubHeaderRow(SXSSFWorkbook wb, SXSSFSheet sheet, List<ColumnInfo> columns, int maxDepth, int currentDepth, int rowIndex, int cellIndex) {
        if (CollectionUtils.isEmpty(columns)) {
            return;
        }

        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        SXSSFRow row = getOrCreateRow(sheet, rowIndex);

        int currentCellIndex = cellIndex;

        for (int i = 0; i < columns.size(); i++) {
            ColumnInfo columnInfo = columns.get(i);
            int cellCount = columnInfo.getCellCount();
            SXSSFCell cell = row.createCell(currentCellIndex);
            cell.setCellStyle(cellStyle);
            cell.setCellValue(columnInfo.getPrompt());

            if (cellCount == 1) {
//                单列,合并列单元格
                if (rowIndex != (rowIndex + maxDepth - currentDepth)) {
                    sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex + maxDepth - currentDepth, currentCellIndex, currentCellIndex));
                }
            } else {
//                多列的，必然有嵌套，合并行单元格
                if (currentCellIndex != currentCellIndex + cellCount - 1) {
                    sheet.addMergedRegion(new CellRangeAddress(rowIndex, rowIndex, currentCellIndex, currentCellIndex + cellCount - 1));
                }
                createSubHeaderRow(wb, sheet, columnInfo.getColumn(), maxDepth, currentDepth + 1, rowIndex + 1, currentCellIndex);
            }
            currentCellIndex += cellCount;
        }

    }

    private SXSSFRow getOrCreateRow(SXSSFSheet sheet, int index) {
        SXSSFRow row = sheet.getRow(index);
        if (row == null) {
            row = sheet.createRow(index);
        }
        return row;
    }

    private void createSingleHeaderRow(SXSSFWorkbook wb, SXSSFSheet sheet, List<ColumnInfo> columns, AtomicInteger rowCount) {
        int rowIndex = rowCount.getAndIncrement();
        SXSSFRow firstRow = sheet.createRow(rowIndex);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        for (int i = 0; i < columns.size(); i++) {
            ColumnInfo columnInfo = columns.get(i);
            SXSSFCell firstCell = firstRow.createCell(i);
            firstCell.setCellValue(columnInfo.getPrompt());
            // 设置列宽度
            Integer width = columnInfo.getWidth();
            if (width == null) {
                width = 150;
            }
            sheet.setColumnWidth(i, width * 16);
            firstCell.setCellStyle(cellStyle);
        }

    }

    private int getMaxDepth(List<ColumnInfo> columns) {
        if (CollectionUtils.isEmpty(columns)) {
            return 1;
        }
        return columns.stream().map(ColumnInfo::getDepth).sorted(Comparator.reverseOrder()).findFirst().get();
    }
}
