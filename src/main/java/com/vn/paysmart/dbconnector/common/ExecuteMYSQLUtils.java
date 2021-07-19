package com.vn.paysmart.dbconnector.common;

import com.vn.paysmart.dbconnector.entity.InfoQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Locale;

@Component
public class ExecuteMYSQLUtils {
    public static final Logger logger = LoggerFactory.getLogger(ExecuteMYSQLUtils.class);

    public boolean isExecute(InfoQuery infoQuery) {
        String tableName = infoQuery.getTableName().toLowerCase(Locale.ROOT);
        String dbName = infoQuery.getDbName().toLowerCase(Locale.ROOT);
        String executeQuery = infoQuery.getQueryExecute().toLowerCase(Locale.ROOT);
        if (StringUtils.isEmpty(infoQuery.getClusterName()) || StringUtils.isEmpty(infoQuery.getDbName()) || StringUtils.isEmpty(infoQuery.getTableName()) || StringUtils.isEmpty(infoQuery.getQueryExecute())) {
            logger.info("isExecute invalid input!");
            return false;
        }

        if (!executeQuery.contains(dbName) || !executeQuery.contains(tableName)){
            logger.info("isExecute invalid query!");
            return false;
        }

        if(executeQuery.contains("drop")
                || executeQuery.contains("alter")
                || executeQuery.contains("delete")
                || executeQuery.contains("select")
                || executeQuery.contains("truncate")){
            logger.info("isExecute not support!");
            return false;
        }

        if(executeQuery.contains("update") && !executeQuery.contains("where")){
            logger.info("isExecute not found condition!");
            return false;
        }

        return true;
    }
}
