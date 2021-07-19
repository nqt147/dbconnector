package com.vn.paysmart.dbconnector.service.impl;

import com.vn.paysmart.dbconnector.common.ExecuteMYSQLUtils;
import com.vn.paysmart.dbconnector.connector.MYSQLConnector;
import com.vn.paysmart.dbconnector.entity.ExecuteMYSQLRequest;
import com.vn.paysmart.dbconnector.entity.ExecuteMYSQLResponse;
import com.vn.paysmart.dbconnector.entity.InfoQuery;
import com.vn.paysmart.dbconnector.service.MYSQLService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class MYSQLServiceImpl implements MYSQLService {
    public static final Logger logger = LoggerFactory.getLogger(MYSQLServiceImpl.class);

    @Autowired
    ExecuteMYSQLUtils mysqlUtils;

    @Override
    public List<String> getAllSchemaDB() {

        return null;
    }

    @Override
    public List<String> getAllTablesDB() {
        return null;
    }

    @Override
    public ExecuteMYSQLResponse executeMYSQL(ExecuteMYSQLRequest infoDB) throws SQLException {
        ExecuteMYSQLResponse result = null;
        InfoQuery infoQuery = infoDB.getInfoQuery();
        boolean isExecute = mysqlUtils.isExecute(infoQuery);
        logger.info("isExecuteMYSQL: {}", isExecute);
        if (!isExecute) {
            return null;
        }
        MYSQLConnector.getInstance().executeQuery(infoQuery.getQueryExecute());
        return result;
    }
}
