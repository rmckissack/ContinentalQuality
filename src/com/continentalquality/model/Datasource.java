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

//constants for database connection
    public static final String DB_NAME = "randyqua_sort";
    public static final String CONNECTION_PARAMETERS = "?serverTimezone=US/Eastern";
    public static final String USER_NAME = "randyqua_web";
    public static final String PASSWORD = "abc123!!!";

    public static final String CONNECTION_STRING = "jdbc:mysql://sort.continentalquality.com/" + DB_NAME + CONNECTION_PARAMETERS;

//    constants for queryAvailable To Sort
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

//    constants for Lot
    public static final String LOT_TABLE = "Lot";
    public static final String LOT_COLUMN_LOT_ID = "lotId";
    public static final String LOT_COLUMN_LOT_NUMBER = "lotNumber";
    public static final String LOT_COLUMN_PART_NUMBER ="partNumber";
    public static final String LOT_COLUMN_COMPLETED = "completed";
    public static final int INDEX_LOT_LOT_ID = 1;
    public static final int INDEX_LOT_LOT_NUMBER = 2;
    public static final int INDEX_LOT_PART = 3;
    public static final int INDEX_LOT_COMPLETED = 4;

//    constants for initems
    public static final String INITEMS_TABLE= "InItems";
    public static final String INTIEMS_IN_ITEMS_ID = "inItemsId";
    public static final String INITEMS_LOT_ID = "lotId";
    public static final String INITEMS_INBOUND_BOL = "inboundBOL";
    public static final String INITEMS_PO_NUMBER = "poNumber";
    public static final String INITEMS_QUANTITY_OF_TUBS = "quantityOfTubs";
    public static final String INITEMS_QUANTITY_OF_SKIDS = "quantityOfSkids";
    public static final String INITEMS_QUANTITY_OF_BOXES = "quantityOfBoxes";

//    constants for tally sheet
    public static final String TALLY_SHEET_TABLE = "Tally";
    public static final String TALLY_SHEET_TALLY_ID = "tallyId";
    public static final String TALLY_SHEET_LOT_ID = "lotId";
    public static final String TALLY_SHEET_TALLY_DATE = "tallyDate";
    public static final String TALLY_SHEET_MUTILATION = "mutilation";
    public static final String TALLY_SHEET_PLATING = "plating";
    public static final String TALLY_SHEET_MIXED = "mixed";
    public static final String TALLY_SHEET_NOGO = "noGo";
    public static final String TALLY_SHEET_OVERFLOW = "overflow";
    public static final String TALLY_SHEET_TABLE_NUMBER = "tableNumber";
    public static final String TALLY_SHEET_TUB_COMPLETED = "tubCompleted";

//    constants for box count
    public static final String BOX_COUNT_TABLE = "BoxCount";
    public static final String BOX_COUNT_ID = "id";
    public static final String BOX_COUNT_TALLY_ID = "tallyId";
    public static final String BOX_COUNT_BOX_TIME = "boxTime";

//    constants for parts
    public static final String PART_TABLE = "Part";
    public static final String PART_PART_NUMBER = "partNumber";
    public static final String PART_DESCRIPTION = "description";
    public static final String PART_PACKAGING = "packaging";
    public static final String PART_PER_BOX = "perBox";
    public static final String PART_PER_SKID = "perSkid";
    public static final String PART_WEIGHT_CLASS = "weightClass";
    public static final String PART_PIECE_PRICE = "piecePrice";
    public static final String PART_MUTILATION = "mutilation";
    public static final String PART_PLATING = "plating";
    public static final String PART_MIXED = "mixed";
    public static final String PART_NOGO = "noGo";
    public static final String PART_BOX_ONLY = "boxOnly";
    public static final String PART_COMMENTS = "comments";




//    query statements

    public static final String QUERY_AVAILABLE = "SELECT * FROM " +
            VIEW_AVAILABLE + VIEW_AVAILABLE_ORDER_BY;
    private PreparedStatement queryAvailable;

    public static final String QUERY_READY_TO_SHIP = "SELECT * FROM " +
            LOT_TABLE;
    private PreparedStatement readyToShip;

    private Connection conn;

    private static Datasource instance = new Datasource();

    public Datasource() {

    }

    public static Datasource getInstance() {
        return instance;
    }

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PASSWORD);
            readyToShip = conn.prepareStatement(QUERY_READY_TO_SHIP);
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


    //    Method to build list of lots available for sorting
    public List<AvailableToShip> queryReadyToShip() {

        String sb = "SELECT "+ LOT_COLUMN_LOT_ID + ", " + LOT_COLUMN_LOT_NUMBER + ", " + LOT_COLUMN_PART_NUMBER + ", " +
                LOT_COLUMN_COMPLETED + " FROM " + LOT_TABLE + " WHERE " + LOT_COLUMN_COMPLETED + "='1'";


        try (Statement statement = conn.createStatement();
             ResultSet results = statement.executeQuery(sb)) {

            List<AvailableToShip> availableToShip = new ArrayList<>();
            while (results.next()) {
                AvailableToShip ship = new AvailableToShip();
                ship.setReadyLotId(results.getInt(INDEX_LOT_LOT_ID));
                ship.setReadyLotNumber(results.getString(INDEX_LOT_LOT_NUMBER));
                ship.setReadyPartNumber(results.getString(INDEX_LOT_PART));
                ship.setReadyCompleted(results.getBoolean(INDEX_LOT_COMPLETED));
                availableToShip.add(ship);
            }
//            System.out.println();
            return availableToShip;

        } catch (SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }
    }


    }
