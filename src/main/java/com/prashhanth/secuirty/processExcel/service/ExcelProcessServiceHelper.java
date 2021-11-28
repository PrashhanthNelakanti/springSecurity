package com.prashhanth.secuirty.processExcel.service;

import com.prashhanth.secuirty.processExcel.controller.ExcelProcessController;
import com.prashhanth.secuirty.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExcelProcessServiceHelper {

    Logger logger = LoggerFactory.getLogger(ExcelProcessController.class);

    String colName = "";

    public String getColumnName(String colName,String val) {
        colName = colNmConvension(colName);
        this.colName = this.colName + colName + " " + val;
        return this.colName;
    }


    public String colNmConvension(String colNm) {
        if (colNm.contains(" ")) {
            colNm = colNm.replaceAll(" ", "_");
        }
        return colNm;
    }

    public String getFileName(String filename) {
        return filename.substring(0, filename.indexOf("."));
    }

    public String finalCreateQuery(String filename, String query) {
        if (filename.contains("."))
            filename = getFileName(filename);
        else
            filename = filename.replace(">>",".");
        query = AppConstants.CREATE_TABLE_IF_NOT_EXISTS + filename + "(" + query;
        query = query.substring(0, query.length() - 2);
        query = query + ")";
        this.colName = "";
        return query;
    }

    public String getColumnValue(String filename, String insertQuery) {
        filename = getFileName(filename);
        insertQuery = AppConstants.INSERT_INTO + filename + " VALUES(" + insertQuery;
        insertQuery = insertQuery.substring(0, insertQuery.length() - 2);
        insertQuery = insertQuery + ")";
        return insertQuery;
    }

    public String getColsWithTypes(String tblnm, List<String> names) {
        this.colName="";
        String queryWithType = "";
        for (String colname : names) {
            queryWithType = getColumnName(colname,AppConstants.COL_TYPE);
        }
        return finalCreateQuery(tblnm,queryWithType);
    }

    public String insertByColNms(String tblnm, List<String> names) {
        String query = "";
        String srcTbl= tblnm.substring(tblnm.indexOf(".")+1,tblnm.length());
        for (String colname : names) {
            query = getColumnName(colname,",");
        }
        String cols=query.substring(0,query.length()-1);
        query = AppConstants.INSERT_INTO+tblnm+"("+cols+")"+AppConstants.SELECT+cols+AppConstants.FROM+srcTbl;
        return query;
    }

}
