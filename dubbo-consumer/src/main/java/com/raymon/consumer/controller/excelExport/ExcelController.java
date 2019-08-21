package com.raymon.consumer.controller.excelExport;

import com.alibaba.dubbo.config.annotation.Reference;
import com.raymon.api.pojo.excelExport.ExcelExportPojo;
import com.raymon.api.service.excelExport.ExcelExportService;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcelController {

    @Reference(version = "${dubbo.service.version}",
            application = "${dubbo.application.id}",
            url = "dubbo://localhost:20880")
    private ExcelExportService excelExportService;

    @RequestMapping("/excel/download")
    public ResponseEntity<InputStreamResource> download(ExcelExportPojo info) {
        return excelExportService.download(info);
    }
}
