package com.prashhanth.secuirty.processExcel.service;

import com.prashhanth.secuirty.util.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public String insertValue(String query) {
        String msg = null;

        try {
            logger.info("Inserting into table..." + query);
            jdbcTemplate.update(query);
            return msg = AppConstants.INSERT_SUCCESS;

        } catch (Exception e) {
            logger.info("Failed to insert into table...with " + e.getMessage());
            return msg = AppConstants.INSERT_FAILURE;
        }
    }

    public List<String> getColNamesFromExistingTbl(String tblname) {
        String sql = "select * from " + tblname + " limit 1";
        List<String> query = new ArrayList<>();
        jdbcTemplate.query(sql, new ResultSetExtractor<Integer>() {

            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    query.add(rsmd.getColumnName(i));
                }
                return columnCount;
            }
        });
        return query;
    }

    public String transfer(String query) {

        return null;
    }

}
