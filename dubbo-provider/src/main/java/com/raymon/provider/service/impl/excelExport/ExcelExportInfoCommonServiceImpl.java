package com.raymon.provider.service.impl.excelExport;

import com.alibaba.dubbo.config.annotation.Service;
import com.raymon.api.pojo.excelExport.ExcelExportPojo;
import com.raymon.api.service.excelExport.ExcelExportInfoCommonService;
import com.raymon.provider.dao.excelExport.ExcelExportInfoCommonMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

/**
 * Author: raymon
 * Date: 2019/4/2
 * Description:
 */
@Service(version = "${dubbo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class ExcelExportInfoCommonServiceImpl implements ExcelExportInfoCommonService {

    private static final Logger log =  LoggerFactory.getLogger(ExcelExportInfoCommonServiceImpl.class);

    @Autowired
    private ExcelExportInfoCommonMapper mapper;

    @Override
    public Optional<ExcelExportPojo> findFirstByStatusOrderByCreationDate(String status) {
        return mapper.findFirstByStatusOrderByCreationDate(status);
    }

    @Override
    public Optional<ExcelExportPojo> findById(Long id) {
        return mapper.findById(id);
    }

    @Override
    public int save(ExcelExportPojo excelExportPojo) {
        return mapper.save(excelExportPojo);
    }
}
