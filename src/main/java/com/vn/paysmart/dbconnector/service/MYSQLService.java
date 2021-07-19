package com.vn.paysmart.dbconnector.service;

import com.vn.paysmart.dbconnector.entity.ExecuteMYSQLRequest;
import com.vn.paysmart.dbconnector.entity.ExecuteMYSQLResponse;
import org.springframework.http.ResponseEntity;

import java.sql.SQLException;
import java.util.List;

public interface MYSQLService {
    List<String> getAllSchemaDB();
    List<String> getAllTablesDB();

    ExecuteMYSQLResponse executeMYSQL(ExecuteMYSQLRequest infoDB) throws SQLException;

}
