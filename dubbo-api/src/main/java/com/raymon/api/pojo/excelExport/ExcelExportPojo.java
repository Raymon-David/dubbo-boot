package com.raymon.api.pojo.excelExport;

import java.io.Serializable;
import java.util.Date;

/**
 * Author: raymon
 * Date: 2019/4/1
 * Description:
 */
public class ExcelExportPojo implements Serializable{
    private Long exportId;

    private String sqlContent;

    private String columnInfo;

    private String savePath;

    private String status;

    private Long createdBy;

    private Date creationDate;

    private Date lastUpdateDate;

    public Long getExportId() {
        return exportId;
    }

    public void setExportId(Long exportId) {
        this.exportId = exportId;
    }

    public String getSqlContent() {
        return sqlContent;
    }

    public void setSqlContent(String sqlContent) {
        this.sqlContent = sqlContent;
    }

    public String getColumnInfo() {
        return columnInfo;
    }

    public void setColumnInfo(String columnInfo) {
        this.columnInfo = columnInfo;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}
