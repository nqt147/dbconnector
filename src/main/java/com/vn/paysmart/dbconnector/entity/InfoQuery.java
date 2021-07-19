package com.vn.paysmart.dbconnector.entity;

public class InfoQuery {
    private String clusterName;
    private String dbName;
    private String tableName;
    private String queryExecute;

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getQueryExecute() {
        return queryExecute;
    }

    public void setQueryExecute(String queryExecute) {
        this.queryExecute = queryExecute;
    }
}
