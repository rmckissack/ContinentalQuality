package com.continentalquality.model;

import java.util.Date;

public class Lot {

    private int lotId;
    private String lotNumber;
    private String lotPartNumber;
    private Date lotDueDate;
    private boolean lotHot;
    private boolean lotCompleted;

    public int getLotId() {
        return lotId;
    }

    public void setLotId(int lotId) {
        this.lotId = lotId;
    }

    public String getLotNumber() {
        return lotNumber;
    }

    public void setLotNumber(String lotNumber) {
        this.lotNumber = lotNumber;
    }

    public String getLotPartNumber() {
        return lotPartNumber;
    }

    public void setLotPartNumber(String lotPartNumber) {
        this.lotPartNumber = lotPartNumber;
    }

    public Date getLotDueDate() {
        return lotDueDate;
    }

    public void setLotDueDate(Date lotDueDate) {
        this.lotDueDate = lotDueDate;
    }

    public boolean isLotHot() {
        return lotHot;
    }

    public void setLotHot(boolean lotHot) {
        this.lotHot = lotHot;
    }

    public boolean isLotCompleted() {
        return lotCompleted;
    }

    public void setLotCompleted(boolean lotCompleted) {
        this.lotCompleted = lotCompleted;
    }
}
