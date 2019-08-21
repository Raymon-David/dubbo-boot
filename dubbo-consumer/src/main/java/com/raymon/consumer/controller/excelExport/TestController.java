package com.raymon.consumer.controller.excelExport;

import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

public class TestController {
//    private ExcelExportProperties properties;

    @Autowired
//    private JdbcTemplate jdbcTemplate;

    @Reference(version = "${dubbo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
//    private ExcelExportInfoRepository repository;

    @RequestMapping("test")
    public String publish() {
//        new ExcelExportThread(repository, jdbcTemplate, properties.getLocation()).start();
        return "结束";
    }
}
