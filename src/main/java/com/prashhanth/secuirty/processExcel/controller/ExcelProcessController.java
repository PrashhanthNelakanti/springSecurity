package com.prashhanth.secuirty.processExcel.controller;

import com.prashhanth.secuirty.processExcel.service.ExcelProcessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelProcessController {
    Logger logger = LoggerFactory.getLogger(ExcelProcessController.class);

    @Autowired
    ExcelProcessService service;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (service.hasExcelFormat(file)) {
            try {
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                logger.info(message);
                service.processExcelData(file.getInputStream(),file.getOriginalFilename());
                return message;
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return message;
            }
        }

        message = "Please upload an excel file!";
        return message;
    }
}
