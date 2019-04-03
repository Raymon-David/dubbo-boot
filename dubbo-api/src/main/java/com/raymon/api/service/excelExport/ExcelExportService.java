package com.raymon.api.service.excelExport;


import com.raymon.api.pojo.excelExport.ExcelExportPojo;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;

/**
 * 处理excel导出
 * Created by raymon.
 */
public interface ExcelExportService {
    ResponseEntity<InputStreamResource> download(ExcelExportPojo info) ;
}
