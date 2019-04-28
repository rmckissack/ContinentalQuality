/*
 * Created by Randy McKissack 2019/04/24
 *
 */
package com.continentalquality.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class QueryDatabase {

////    Method to build list of lots available for sorting
//
//    public static final String AVAILABLE_LOT_NUMBER = "viewAvailableLotNumber";
//    public static final String AVAILABLE_PART_NUMBER = "viewAvailablePartNumber";
//
//    public List<AvailableToSort> queryAvaialableLot() {
//
//        try (Statement statement = conn.createStatement();
//             ResultSet results = statement.executeQuery("SELECT Lot Part FROM AvailableLotView " +
//                     "where Completed = 0")) {
//
//            List<AvailableToSort> availableLots = new ArrayList<>();
//            while (results.next()) {
//                AvailableToSort lot = new AvailableToSort();
//                lot.setViewAvailablePartNumber(results.getString(AVAILABLE_PART_NUMBER));
//                lot.setViewAvailableLotNumber(results.getString(AVAILABLE_LOT_NUMBER));
//                availableLots.add(lot);
//            }
//            System.out.println();
//            return availableLots;
//
//        } catch (SQLException e) {
//            System.out.println("Query failed: " + e.getMessage());
//            return null;
//        }

//    }






















}
