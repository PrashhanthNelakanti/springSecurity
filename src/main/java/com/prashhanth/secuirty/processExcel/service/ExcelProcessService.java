package com.prashhanth.secuirty.processExcel.service;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Iterator;
import java.util.List;


@Service
public class ExcelProcessService {

    Logger logger = LoggerFactory.getLogger(ExcelProcessService.class);
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    @Autowired
    private ExcelProcessServiceHelper excelProcessServiceHelper;

    @Autowired
    private ExcelDataPersistance excelDataPersistance;

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }
        return true;
    }

    public List processExcelData(InputStream is, String fileName) {
        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheetAt(1);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;
            String query = null;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Iterator<Cell> cellsInRow = currentRow.iterator();
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    if (rowNumber > 0) {
                       /* if ("NUMERIC".equals(currentCell.getCellType().name())) {
                            System.out.println(currentCell.getNumericCellValue());
                        }
                        if ("STRING".equals(currentCell.getCellType().name())) {
                            System.out.println(currentCell.getStringCellValue());
                        }
                        if ("FORMULA".equals(currentCell.getCellType().name())) {
                            System.out.println(currentCell.getCellFormula());
                        }*/
                    } else {
                        query = excelProcessServiceHelper.getColumnName(currentCell.getStringCellValue());
                    }
                }
                rowNumber++;
            }
            String finalQuery = excelProcessServiceHelper.finalCreateQuery(fileName, query);
            excelDataPersistance.createTable(finalQuery);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
