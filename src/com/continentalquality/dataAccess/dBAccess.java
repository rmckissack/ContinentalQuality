package com.continentalquality.dataAccess;


import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;
        import java.util.List;

public class dBAccess {
    public static final String DB_NAME = "randyqua_sort_db";
    public static final String CONNECTION_PARAMETERS = "?serverTimezone=US/Eastern";
    public static final String USER_NAME = "randyqua_web";
    public static final String PWD = "abc123!!!";

    public static final String CONNECTION_STRING = "jdbc:mysql://sort.continentalquality.com/" + DB_NAME + CONNECTION_PARAMETERS;

    public static final String TABLE_PART = "Part";
    public static final String PART_NUMBER = "partNumber";
    public static final String PART_DESCRIPTION = "description";
    public static final String PART_PACKAGING = "packaging";
    public static final String PART_PER_BOX = "perBox";
    public static final String PART_PER_SKID = "perSkid";
    public static final String PART_WEIGHT_CLASS = "weightClass";
    public static final String PART_PIECE_PRICE = "piecePrice";
    public static final String PART_MUTILATION = "mutilation";
    public static final String PART_PLATING = "plating";
    public static final String PART_MIXED = "mixed";
    public static final String PART_NO_GO = "noGo";
    public static final String PART_BOX_ONLY = "boxOnly";
    public static final String PART_COMMENTS = "comments";

    private Connection conn;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING, USER_NAME, PWD);
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

    public List<Part> queryParts() {


        try(Statement statement = conn.createStatement();
            ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_PART)) {

            List<Part> parts = new ArrayList<>();
            while(results.next()) {
                Part thing = new Part();
                thing.setPartNumber(results.getString(PART_NUMBER));
                thing.setPartDescription(results.getString(PART_DESCRIPTION));
                thing.setPartPackaging(results.getString(PART_PACKAGING));
                parts.add(thing);
            }

            return parts;

        } catch(SQLException e) {
            System.out.println("Query failed: " + e.getMessage());
            return null;
        }

    }
}