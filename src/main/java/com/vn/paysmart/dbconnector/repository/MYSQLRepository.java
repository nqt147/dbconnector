package com.vn.paysmart.dbconnector.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MYSQLRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void findAll() {
        jdbcTemplate.execute("SELECT * FROM test.Persons");
    }

}
