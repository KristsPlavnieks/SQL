package com.example.demo.web.controller.web;

import com.example.demo.db.connection;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.sql.Connection;
@Service
public class nana extends connection {
    public String hey() {

        Connection con = getConnection();
        if (con != null) {
            System.out.print("Jeeeeeeey");
            return "Jeeeeeeey";
        } else {
            System.out.print("Neeeeeeeeeeeee");
            return "Neeeeeeeeeeeee";
        }
    }
}
