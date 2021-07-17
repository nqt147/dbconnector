package com.vn.paysmart.dbconnector.service.impl;

import com.vn.paysmart.dbconnector.service.MYSQLService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MYSQLServiceImpl implements MYSQLService {
    @Override
    public List<String> getAllSchemaDB() {

        return null;
    }

    @Override
    public List<String> getAllTablesDB() {
        return null;
    }
}
