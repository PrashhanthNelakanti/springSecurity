package com.prashhanth.secuirty.processExcel.service;

import com.prashhanth.secuirty.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ExcelDataPersistance {

    Logger logger = LoggerFactory.getLogger(ExcelDataPersistance.class);

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String createTable(String query) {
        String msg = null;

        try {
            logger.info("Creating table..." + query);
            jdbcTemplate.execute(query);
            return msg = AppConstants.TABLE_CREATION_SUCCESS;

        } catch (Exception e) {
            logger.info("Failed to create table...with " + e.getMessage());
            return msg = AppConstants.TABLE_CREATION_FAILURE;
        }
    }

    public String insertValues(List<String> queries) {
        String msg = null;

        try {
            logger.info("Creating table..." + queries);
            for (String insertQuery : queries) {
                jdbcTemplate.update(insertQuery);
            }
            return msg = AppConstants.TABLE_CREATION_SUCCESS;

        } catch (Exception e) {
            logger.info("Failed to create table...with " + e.getMessage());
            return msg = AppConstants.TABLE_CREATION_FAILURE;
        }
    }

    public String insertValue(String query) {
        String msg = null;

        try {
            logger.info("Inserting into table..." + query);
                jdbcTemplate.update(query);
            return msg = AppConstants.TABLE_CREATION_SUCCESS;

        } catch (Exception e) {
            logger.info("Failed to insert into table...with " + e.getMessage());
            return msg = AppConstants.TABLE_CREATION_FAILURE;
        }
    }
}
