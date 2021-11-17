package com.prashhanth.secuirty.processExcel.service;

import com.prashhanth.secuirty.processExcel.controller.ExcelProcessController;
import com.prashhanth.secuirty.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExcelProcessServiceHelper {

    Logger logger = LoggerFactory.getLogger(ExcelProcessController.class);

    String colName = "";

    public String getColumnName(String colName) {
        colName=colNmConvension(colName);
        this.colName = this.colName + colName + " " + AppConstants.COL_TYPE;
        return this.colName;
    }


    public String colNmConvension(String colNm) {
        if (colNm.contains(" ")) {
            colNm = colNm.replaceAll(" ","_");
        }
        return colNm;
    }

    public String getFileName(String filename){
        return filename.substring(0,filename.indexOf("."));
    }

    public String finalCreateQuery(String filename, String query) {
        filename=getFileName(filename);
        query = AppConstants.CREATE_TABLE_IF_NOT_EXISTS +filename+"("+query;
        query = query.substring(0,query.length()-2);
        query= query+")";
        this.colName="";
        return query;
    }

    public String getColumnValue(String filename,String insertQuery) {
        filename=getFileName(filename);
        insertQuery = AppConstants.INSERT_INTO +filename+" VALUES("+insertQuery;
        insertQuery = insertQuery.substring(0,insertQuery.length()-2);
        insertQuery= insertQuery+")";
        return insertQuery;
    }
}
