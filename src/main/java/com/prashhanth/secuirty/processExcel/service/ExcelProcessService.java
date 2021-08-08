package com.prashhanth.secuirty.processExcel.service;

import com.prashhanth.secuirty.processExcel.util.ExcelProcessUtil;
import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

@Service
    public class ExcelProcessService {

    public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";

    public ResponseEntity<?> process(MultipartFile file) throws Exception {
        String fileName=file.getOriginalFilename();
        Workbook workbook=null;
        if(fileName.endsWith(ExcelProcessUtil.EXCEL_FILE) || fileName.endsWith(ExcelProcessUtil.EXCEL_FILE1)){
            String excelPath=uploadDirectory+"/"+file.getOriginalFilename();
           getConvFile(file);
            System.out.println("file saved");
            try {
                workbook = WorkbookFactory.create(new File(excelPath));
            } catch (EncryptedDocumentException | IOException e) {
                e.printStackTrace();
            }

            // Retrieving the number of sheets in the Workbook
            System.out.println("-------Workbook has '" + workbook.getNumberOfSheets() + "' Sheets-----");

            // Getting the Sheet at index zero
            Sheet sheet = workbook.getSheetAt(0);


        }else{
           return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ExcelProcessUtil.INVALID_FILE_TYPE);
        }
        return null;
    }

    private void getConvFile(MultipartFile file) throws IOException {
        StringBuilder fileNames = new StringBuilder();
        if(!new File(uploadDirectory).exists())
        new File(uploadDirectory).mkdir();

            Path fileNameAndPath = Paths.get(uploadDirectory, file.getOriginalFilename());
            fileNames.append(file.getOriginalFilename()+" ");
            try {
                Files.write(fileNameAndPath, file.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        //FileUtils.deleteDirectory(new File(uploadDirectory));
    }


}
