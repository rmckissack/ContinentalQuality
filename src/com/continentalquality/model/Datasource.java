package com.continentalquality.model;
/*
 * Created by Randy McKissack 2019/04/23
 *
 */

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.LongToDoubleFunction;


public class Datasource {

    public static final String DB_NAME = "randyqua_sort_db";
    public static final String CONNECTION_PARAMETERS = "?serverTimezone=US/Eastern";
    public static final String USER_NAME = "randyqua_web";
    public static final String PASSWORD = "abc123!!!";

    public static final String CONNECTION_STRING = "jdbc:mysql://sort.continentalquality.com/" + DB_NAME + CONNECTION_PARAMETERS;

//    constants for queryAvailable
    public static final String VIEW_AVAILABLE = "AvailableToSort";
    public static final String COLUMN_AVAILABLE_LOT_ID = "lotId";
    public static final String COLUMN_AVAILABLE_LOT = "lotNumber";
    public static final String COLUMN_AVAILABLE_PART = "partNumber";
    public static final String COLUMN_HOT_LIST = "hotList";
    public static final String VIEW_AVAILABLE_ORDER_BY =    " ORDER BY hotList DESC, lotNumber";
    public static final int INDEX_AVAILABLE_LOT_ID = 1;
    public static final int INDEX_AVAILABLE_LOT = 3;
    public static final int INDEX_AVAILABLE_PART = 2;
    public static final int INDEX_AVAILABLE_HOT = 4;

    public static final String QUERY_AVAILABLE = "SELECT * FROM " +
            VIEW_AVAILABLE + VIEW_AVAILABLE_ORDER_BY;
    private PreparedStatement queryAvailable;


    private Connection conn;

    private static Datasource instance = new Datasource();

    private Datasource() {

    }

    public static Datasource getInstance() {
        return instance;
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
            queryAvailable = conn.prepareStatement(QUERY_AVAILABLE);
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
    public List<AvailableToSort> queryAvailableLot() {

        String sb = "SELECT * FROM " + VIEW_AVAILABLE + VIEW_AVAILABLE_ORDER_BY;


        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb)) {

            List<AvailableToSort> availableLots = new ArrayList<>();
            while (results.next()) {
                AvailableToSort lot = new AvailableToSort();
                lot.setAvailableLotId(results.getInt(INDEX_AVAILABLE_LOT_ID));
                lot.setAvailableLotNumber(results.getString(INDEX_AVAILABLE_LOT));
                lot.setAvailablePartNumber(results.getString(INDEX_AVAILABLE_PART));
                lot.setAvailableHot(results.getString(INDEX_AVAILABLE_HOT));
                availableLots.add(lot);
            }
//            System.out.println();
            return availableLots;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }



    }













