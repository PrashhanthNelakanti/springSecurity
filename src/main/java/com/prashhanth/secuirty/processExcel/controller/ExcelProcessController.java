package com.prashhanth.secuirty.processExcel.controller;

import com.prashhanth.secuirty.processExcel.service.ExcelProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ExcelProcessController {

    @Autowired
    ExcelProcessService excelProcessService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {
        String message = "";

        return excelProcessService.process(file);


    }
}
