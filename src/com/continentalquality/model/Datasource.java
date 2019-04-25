package com.continentalquality.model;
/*
 * Created by Randy McKissack 2019/04/23
 *
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Datasource {

    public static final String DB_NAME = "randyqua_sort_db";
    public static final String CONNECTION_PARAMETERS = "?serverTimezone=US/Eastern";
    public static final String USER_NAME = "randyqua_web";
    public static final String PASSWORD = "abc123!!!";

    public static final String CONNECTION_STRING = "jdbc:mysql://sort.continentalquality.com/" + DB_NAME + CONNECTION_PARAMETERS;

    public Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
            return true;


        } catch (SQLException e) {
            System.out.println("Something isn't right:\n " + e.getMessage());
            return false;
        } finally {
            System.out.println("Test ended");
        }

    }

    public void close() {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }


//    Method to build list of lots available for sorting

    public static final String AVAILABLE_LOT_NUMBER = "Lot";
    public static final String AVAILABLE_PART_NUMBER = "Part";

    public List<ViewAvailableLot> queryAvaialableLot() {

        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery("SELECT * FROM AvailableLotsView")) {

            List<ViewAvailableLot> availableLots = new ArrayList<>();
            while (results.next()) {
                ViewAvailableLot lot = new ViewAvailableLot();
                lot.setViewAvailablePartNumber(results.getString(AVAILABLE_PART_NUMBER));
                lot.setViewAvailableLotNumber(results.getString(AVAILABLE_LOT_NUMBER));
                availableLots.add(lot);
            }
            System.out.println();
            return availableLots;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }
}







