package com.prashhanth.secuirty.processExcel.service;

import com.prashhanth.secuirty.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ExcelDataPersistance {

    Logger logger = LoggerFactory.getLogger(ExcelDataPersistance.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String createTable(String filename,String query) {
        String msg = null;
        filename=filename.substring(0,filename.indexOf("."));
        query = AppConstants.CREATE_TABLE_IF_NOT_EXISTS +filename+"("+query;
        query = query.substring(0,query.length()-2);
        query=query+")";
        try {
            logger.info("Creating table..."+query);
            jdbcTemplate.execute(query);
            return msg = AppConstants.TABLE_CREATION_SUCCESS;

        } catch (Exception e) {
            logger.info("Failed to create table...with "+e.getMessage());
            return msg = AppConstants.TABLE_CREATION_FAILURE;
        }
    }
}
