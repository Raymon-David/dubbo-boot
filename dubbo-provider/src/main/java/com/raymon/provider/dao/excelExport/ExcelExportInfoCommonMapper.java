package com.raymon.provider.dao.excelExport;

import com.raymon.api.pojo.excelExport.ExcelExportPojo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Author: raymon
 * Date: 2019/4/2
 * Description:
 */
@Component
@Mapper
public interface ExcelExportInfoCommonMapper {

    Optional<ExcelExportPojo> findFirstByStatusOrderByCreationDate(String status);

    Optional<ExcelExportPojo> findById(Long id);

    int save(ExcelExportPojo excelExportPojo);
}
