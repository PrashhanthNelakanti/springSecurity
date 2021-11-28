package com.prashhanth.secuirty.processExcel.service;

import com.prashhanth.secuirty.util.AppConstants;
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
import java.util.ArrayList;
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
            List<String> insertQueries = new ArrayList<>();
            String createQuery = "";
            String insertQuery = "";
            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Iterator<Cell> cellsInRow = currentRow.iterator();
                while (cellsInRow.hasNext()) {
                    Cell currentCell = cellsInRow.next();
                    if (rowNumber != 0) {
                        insertQuery += "'" + currentCell.toString() + "', ";
                    } else {
                        createQuery = excelProcessServiceHelper.getColumnName(currentCell.getStringCellValue(), AppConstants.COL_TYPE);
                    }
                }
                String columnValue = excelProcessServiceHelper.getColumnValue(fileName, insertQuery);
                insertQueries.add(columnValue);
                insertQuery = "";
                rowNumber++;
            }
            String finalQuery = excelProcessServiceHelper.finalCreateQuery(fileName, createQuery);
            excelDataPersistance.createTable(finalQuery);
            for (String query: insertQueries){
                //logger.debug(query);
                excelDataPersistance.insertValue(query);
            }
        } catch (Exception e) {
            logger.error(e.toString());
        }
        return null;
    }

    public String getProcessQueryCreateTbl(String tableNm,String env){
        List<String> colNamesFromExistingTbl = excelDataPersistance.getColNamesFromExistingTbl(tableNm);
        tableNm= env+">>"+tableNm;
        String query=excelProcessServiceHelper.getColsWithTypes(tableNm,colNamesFromExistingTbl);
        return excelDataPersistance.createTable(query);
    }

    public String insertQueryForExistingTbl(String srcTbl,String env){
        getProcessQueryCreateTbl(srcTbl,env);
        List<String> colNamesFromExistingTbl = excelDataPersistance.getColNamesFromExistingTbl(srcTbl);
        srcTbl= env+"."+srcTbl;
        return excelDataPersistance.insertValue(excelProcessServiceHelper.insertByColNms(srcTbl,colNamesFromExistingTbl));
    }
}
