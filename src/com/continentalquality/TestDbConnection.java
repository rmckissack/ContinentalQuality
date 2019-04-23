package com.continentalquality;

import com.continentalquality.model.Datasource;

public class TestDbConnection {


    public static void main(String[] args) {



    Datasource datasource = new Datasource();
if(!datasource.open()) {
        System.out.println("Can't open Database");
    }
datasource.close();


}
}
