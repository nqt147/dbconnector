package com.vn.paysmart.dbconnector.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.text.SimpleDateFormat;

public class MYSQLConnector {

    private static final Logger logger = LoggerFactory.getLogger(MYSQLConnector.class);
    private static final SimpleDateFormat dateFormatFile = new SimpleDateFormat("yyy-MM-dd");
    private static final SimpleDateFormat dayFile = new SimpleDateFormat("yyyMM");
    private static Connection conn;
    private static MYSQLConnector instance;
    private static String COUNT_ROW = "SELECT count(*) as counter FROM %s WHERE trans_time >= '%s' and  trans_time <= '%s'";

    private MYSQLConnector() {

    }

    private static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try{
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sn_utility_reconciliation?useSSL=false&&allowMultiQueries=true",
                        "root", "12345678");
            }catch (Exception ex){
                conn = DriverManager.getConnection("jdbc:mysql://10.5.18.110:3306/sn_utility_reconciliation?useSSL=false",
                        "operation_tool", "qEBuSdNSYfohYJwQPgSUTet2ofD97pRy");
            }
        }

        return conn;
    }

    public static MYSQLConnector getInstance() throws SQLException {
        getConnection();
        if (instance == null) {
            instance = new MYSQLConnector();
        }

        return instance;
    }

    public synchronized Integer executeQuery(String query) throws SQLException {
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            logger.info("Query: {}", query);
            pst = conn.prepareStatement(query);
            pst.setQueryTimeout(1000);
            int result = pst.executeUpdate(query);
            logger.info("result: {}",result);
            return 1;

        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.info(ex.getMessage());
            return -1;

        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (pst != null) {
                    pst.close();
                }
                if(conn != null){
                    conn.close();
                }
            } catch (SQLException ex) {
                logger.info(ex.getMessage());
            }
        }

    }

}
