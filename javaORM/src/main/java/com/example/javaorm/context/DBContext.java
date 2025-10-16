package com.example.javaorm.context;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBContext {
    private final String serverName = "ADMIN-PC"; // 👈 thêm \\MSSQLSERVER
    private final String dbName = "xiaoStore";
    private final String portNumber = "1433";
    private final String userID = "sa";
    private final String password = "123456789";

    public Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber
                + ";databaseName=" + dbName
                + ";encrypt=true;trustServerCertificate=true;";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn = DriverManager.getConnection(url, userID, password);
        System.out.println(" Đang kết nối đến DB: " + conn.getCatalog());
        return conn;
    }

    public static void main(String[] args) {
        try {
            Connection c = new DBContext().getConnection();
            System.out.println("✅ Kết nối SQL thành công!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}