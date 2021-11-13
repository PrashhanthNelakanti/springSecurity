package com.prashhanth.secuirty.processExcel.service;

import com.prashhanth.secuirty.rnd.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Iterator;



@Service
public class ExcelProcessService {
    public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";

    @Autowired
    private ExcelProcessServiceHelper excelProcessServiceHelper;

    public static boolean hasExcelFormat(MultipartFile file) {

        if (!TYPE.equals(file.getContentType())) {
            return false;
        }

        return true;
    }

    public  List excelToTutorials(InputStream is) {
        try {
            Workbook workbook = new XSSFWorkbook(is);

            Sheet sheet = workbook.getSheetAt(1);
            Iterator<Row> rows = sheet.iterator();
            int rowNumber = 0;
            String createTable=null;
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Iterator<Cell> cellsInRow = currentRow.iterator();
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    if(rowNumber>0) {
                        if ("NUMERIC".equals(currentCell.getCellType().name())) {
                            System.out.println(currentCell.getNumericCellValue());
                        }
                        if ("STRING".equals(currentCell.getCellType().name())) {
                            System.out.println(currentCell.getStringCellValue());
                        }
                        if ("FORMULA".equals(currentCell.getCellType().name())) {
                            System.out.println(currentCell.getCellFormula());
                        }
                    }
                    else{
                         createTable=excelProcessServiceHelper.getColumnName(currentCell.getStringCellValue());
                    }
                }
                System.out.println(createTable);
                rowNumber++;
            }
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }
}
