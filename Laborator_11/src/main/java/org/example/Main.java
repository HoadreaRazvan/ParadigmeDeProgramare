package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String dbUrl = "jdbc:mysql://localhost:3306/lab11DB";
        Properties props = new Properties();
        props.put("user", "lab11");
        props.put("password", "pass11");
        Connection conn = DriverManager.getConnection(dbUrl, props);


        Statement stmt = conn.createStatement();
        stmt.executeUpdate("INSERT INTO DEPARTMENT (name) VALUES('dept java1')");
        stmt.close();


        conn.close();
    }
}