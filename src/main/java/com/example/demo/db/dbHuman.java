package com.example.demo.db;

import java.sql.Connection;

public class dbHuman extends connection{
    public void hey() {

        Connection con = getConnection();
        if (con != null) {
            System.out.print("Jeeeeeeey");
        } else {
            System.out.print("Neeeeeeeeeeeee");
        }

    }
}
