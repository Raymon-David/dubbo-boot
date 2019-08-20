package com.raymon.provider.service.impl.excelExport;

import com.alibaba.dubbo.config.annotation.Service;
import com.raymon.api.pojo.excelExport.ExcelExportPojo;
import com.raymon.api.service.excelExport.ExcelExportService;
import com.raymon.api.service.excelExport.ExcelExportInfoCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

/**
 * Author: raymon
 * Date: 2019/4/1
 * Description:
 */
@Service(version = "${dubbo.service.version}",
        application = "${dubbo.application.id}",
        protocol = "${dubbo.protocol.id}",
        registry = "${dubbo.registry.id}"
)
public class ExcelExportServiceImpl implements ExcelExportService{

    @Autowired
    private ExcelExportInfoCommonService excelExportInfoCommonService;

    @Override
    public ResponseEntity<InputStreamResource> download(ExcelExportPojo info) {
        Optional<ExcelExportPojo> exportInfo = excelExportInfoCommonService.findById(info.getExportId());
        if (exportInfo.isPresent()) {
            ExcelExportPojo excelExportPojo = exportInfo.get();
            String savePath = excelExportPojo.getSavePath();
            if (StringUtils.isEmpty(savePath)) {
                return ResponseEntity.noContent().build();
//                throw new RuntimeException("File not exist");
            }
            File file = new File(savePath);
            if (!file.exists()) {
                return ResponseEntity.noContent().build();
            }
            FileSystemResource fileSystemResource = new FileSystemResource(file);
            HttpHeaders headers = new HttpHeaders();
            headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
            headers.add("Content-Disposition", String.format("attachment; filename=\"%s\"", fileSystemResource.getFilename()));
            headers.add("Pragma", "no-cache");
            headers.add("Expires", "0");

            try {
                return ResponseEntity
                        .ok()
                        .headers(headers)
                        .contentLength(fileSystemResource.contentLength())
                        .contentType(MediaType.parseMediaType("application/octet-stream"))
                        .body(new InputStreamResource(fileSystemResource.getInputStream()));
            } catch (IOException e) {
                return ResponseEntity.noContent().build();
            }
        }

        return ResponseEntity.noContent().build();
    }
}
