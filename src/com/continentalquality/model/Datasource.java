package com.continentalquality.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Created by Randy McKissack 2019/04/23
 *
 */
public class Datasource {

    public static final String DB_NAME = "randyqua_sort_db";
    public static final String CONNECTION_PARAMETERS = "?serverTimezone=US/Eastern";
    public static final String USER_NAME = "randyqua_web";
    public static final String PASSWORD = "abc123!!!";

    public static final String CONNECTION_STRING = "jdbc:mysql://sort.continentalquality.com/" + DB_NAME + CONNECTION_PARAMETERS;

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
            return true;


        } catch(SQLException e) {
            System.out.println("Something isn't right:\n " + e.getMessage());
            return false;
        } finally {
            System.out.println("Test ended");
        }

    }

    public void close() {
        try {
            if(conn !=null) {
                conn.close();
            }
        } catch(SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }



}
