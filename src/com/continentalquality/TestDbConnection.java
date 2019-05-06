package com.continentalquality;


import com.continentalquality.model.Datasource;
import com.continentalquality.model.AvailableToShip;


import java.util.List;

public class TestDbConnection {


    public static void main(String[] args) {



    Datasource datasource = new Datasource();
if(!datasource.open()) {
        System.out.println("Can't open Database");
    }

        List<AvailableToShip> lots = datasource.queryReadyToShip();
        if(lots == null) {
            System.out.println("No lots available!");
            return;
        }

        for(AvailableToShip lot : lots) {
            System.out.println("ID Number = " + lot.getReadyLotId() + ", Part Number = " +
                    lot.getReadyPartNumber() +
                    ", Lot Number = " + lot.getReadyLotNumber()
                    );
        }



datasource.close();


}
}
