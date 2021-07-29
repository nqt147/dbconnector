package com.vn.paysmart.dbconnector.controller;

import com.google.gson.Gson;
import com.vn.paysmart.dbconnector.entity.ExecuteMYSQLRequest;
import com.vn.paysmart.dbconnector.service.impl.MYSQLServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MYSQLController {
    @Autowired
    MYSQLServiceImpl mysqlService;
    public static final Gson gson = new Gson();
    public static final Logger logger = LoggerFactory.getLogger(MYSQLController.class);

    @RequestMapping(value = "/get_info_db/{clusterName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ExecuteMYSQLRequest> getListDB(HttpServletRequest request, @PathVariable("clusterName") String clusterName) {
        System.out.println(gson.toJson(clusterName));
        List<String> dbNames = new ArrayList<>();
        dbNames.add("sn_utility_reconciliation");

        List<String> tableName = new ArrayList<>();
        tableName.add("data_object");
        ExecuteMYSQLRequest requestGetInfoDB = new ExecuteMYSQLRequest();
        requestGetInfoDB.setClusterName("util");
        requestGetInfoDB.setDbName(dbNames);
        requestGetInfoDB.setTableName(tableName);
        return new ResponseEntity<>(requestGetInfoDB, HttpStatus.OK);
    }

    @RequestMapping(value = "/mysql/update", method = RequestMethod.POST)
    public ResponseEntity<ExecuteMYSQLRequest> updateDB(HttpServletRequest request, @RequestBody ExecuteMYSQLRequest infoQuery) throws SQLException {
        logger.info("Request MYSQL execute: {}", gson.toJson(infoQuery));
        List<String> dbNames = new ArrayList<>();
        dbNames.add("sn_operation_tool");
        dbNames.add("sn_reconciliation_tool");
        dbNames.add("sn_utility_reconciliation");

        List<String> tableName = new ArrayList<>();
        tableName.add("table1");
        tableName.add("table2");
        tableName.add("table3");
        tableName.add("table4");
        tableName.add("table5");

        ExecuteMYSQLRequest requestGetInfoDB = new ExecuteMYSQLRequest();
        requestGetInfoDB.setClusterName("util");
        requestGetInfoDB.setDbName(dbNames);
        requestGetInfoDB.setTableName(tableName);

        mysqlService.executeMYSQL(infoQuery);

        return new ResponseEntity<>(requestGetInfoDB, HttpStatus.OK);
    }

    @RequestMapping(value = "/heath_check", method = RequestMethod.GET)
    public ResponseEntity<String> heathCheck() {
        InetAddress addr = null;
        String ipAddress = "";
        try {
            addr = InetAddress.getLocalHost();
            //Host IP Address
            ipAddress = addr.getHostAddress();
            //Hostname
            String hostname = addr.getHostName();
            System.out.println("IP address of localhost from Java Program: " + ipAddress);
            System.out.println("Name of hostname : " + hostname);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(ipAddress, HttpStatus.OK);
    }
}
