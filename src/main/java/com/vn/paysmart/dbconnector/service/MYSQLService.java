package com.vn.paysmart.dbconnector.service;

import java.util.List;

public interface MYSQLService {
    List<String> getAllSchemaDB();
    List<String> getAllTablesDB();

}
