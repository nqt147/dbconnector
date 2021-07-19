package com.vn.paysmart.dbconnector.entity;

import java.util.List;

public class ExecuteMYSQLRequest {

    private InfoQuery infoQuery;
    private List<String> dbName;
    private List<String> tableName;
    private String clusterName;

    public InfoQuery getInfoQuery() {
        return infoQuery;
    }

    public void setInfoQuery(InfoQuery infoQuery) {
        this.infoQuery = infoQuery;
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public List<String> getDbName() {
        return dbName;
    }

    public void setDbName(List<String> dbName) {
        this.dbName = dbName;
    }

    public List<String> getTableName() {
        return tableName;
    }

    public void setTableName(List<String> tableName) {
        this.tableName = tableName;
    }
}
