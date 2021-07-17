package com.vn.paysmart.dbconnector.controller;

import com.google.gson.Gson;
import com.vn.paysmart.dbconnector.entity.RequestGetInfoDB;
import com.vn.paysmart.dbconnector.service.impl.MYSQLServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class MYSQLController {
    @Autowired
    MYSQLServiceImpl mysqlService;
    public static final Gson gson = new Gson();

    @RequestMapping(value = "/get_info_db/{clusterName}", method = RequestMethod.GET)
    ResponseEntity<String> getListDB(HttpServletRequest request, @PathVariable("clusterName") String clusterName) {
        System.out.println(gson.toJson(clusterName));
        List<String> dbNames = mysqlService.getAllSchemaDB();
        RequestGetInfoDB requestGetInfoDB = new RequestGetInfoDB();
        requestGetInfoDB.setClusterName("gello");
        requestGetInfoDB.setDbName("gello");
        requestGetInfoDB.setTableName("gello");
        return new ResponseEntity<>(gson.toJson(requestGetInfoDB), HttpStatus.OK);
    }
}
