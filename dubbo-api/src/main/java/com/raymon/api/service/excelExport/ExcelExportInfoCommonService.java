package com.raymon.api.service.excelExport;

import com.raymon.api.pojo.excelExport.ExcelExportPojo;

import java.util.Optional;

public interface ExcelExportInfoCommonService {
    Optional<ExcelExportPojo> findFirstByStatusOrderByCreationDate(String status);

    Optional<ExcelExportPojo> findById(Long id);

    int save(ExcelExportPojo excelExportPojo);
}
