package com.prashhanth.secuirty.processExcel.service;

import org.springframework.stereotype.Component;

@Component
public class ExcelProcessServiceHelper {

    String columnNameType="create table sample(";
    String type=" varchar(200), ";

    public String getColumnName(String name){
        columnNameType= columnNameType+name+" "+type;
        return columnNameType;
    }

    public String getType(String type){
        System.out.println(type);
        if("NUMERIC".equals(type)){

        }
        return null;
    }
}
