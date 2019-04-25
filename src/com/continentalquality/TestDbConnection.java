package com.continentalquality;

import com.continentalquality.model.Datasource;
import com.continentalquality.model.ViewAvailableLot;

import java.util.List;

public class TestDbConnection {


    public static void main(String[] args) {



    Datasource datasource = new Datasource();
if(!datasource.open()) {
        System.out.println("Can't open Database");
    }

        List<ViewAvailableLot> lots = datasource.queryAvaialableLot();
        if(lots == null) {
            System.out.println("No lots available!");
            return;
        }

        for(ViewAvailableLot lot : lots) {
            System.out.println("Part Number = " + lot.getViewAvailablePartNumber() + ", Lot Number = " + lot.getViewAvailableLotNumber());
        }



datasource.close();


}
}
