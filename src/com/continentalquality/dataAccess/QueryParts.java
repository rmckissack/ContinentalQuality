package com.continentalquality.dataAccess;

import java.util.List;

public class QueryParts {

    dBAccess datasource = new dBAccess();
		if(!datasource.open()) {
        System.out.println("Can't open datasource");
        return;
    }

    List<Part> parts = datasource.queryParts();
        if(parts == null) {
        System.out.println("No parts!");
        return;
    }

        for(Part part : parts) {
        System.out.println("Part Number = " + part.getPartNumber() + ", Description = " + part.getPartDescription());
    }
		datasource.close();
}

