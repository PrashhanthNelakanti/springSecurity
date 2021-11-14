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

    public String finalCreateQuery(String filename, String query) {
        filename=filename.substring(0,filename.indexOf("."));
        query = AppConstants.CREATE_TABLE_IF_NOT_EXISTS +filename+"("+query;
        query = query.substring(0,query.length()-2);
        query= query+")";
        return query;
    }
}
