package com.example.demo.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
    private static final String url = "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC";
    private static final String user = "root";
    private static final String password = "manisaucsicis93";

    public Connection getConnection() {

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (SQLException ex) {
            System.out.print(ex);
        }
        return null;
    }

}
