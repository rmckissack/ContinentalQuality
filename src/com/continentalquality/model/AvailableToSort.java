package com.continentalquality.model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class AvailableToSort {

    private SimpleIntegerProperty availableLotId;
    private SimpleStringProperty availableLotNumber;
    private SimpleStringProperty availablePartNumber;
    private SimpleStringProperty availableHot;

    public AvailableToSort() {
        this.availableLotId = new SimpleIntegerProperty();
        this.availableLotNumber = new SimpleStringProperty();
        this.availablePartNumber = new SimpleStringProperty();
        this.availableHot = new SimpleStringProperty();
    }

    public int getAvailableLotId() {
        return availableLotId.get();
    }

    public void setAvailableLotId(int availableLotId) {
        this.availableLotId.set(availableLotId);
    }

    public String getAvailableLotNumber() {
        return availableLotNumber.get();
    }

    public void setAvailableLotNumber(String availableLotNumber) {
        this.availableLotNumber.set(availableLotNumber);
    }

    public String getAvailablePartNumber() {
        return availablePartNumber.get();
    }

    public void setAvailablePartNumber(String availablePartNumber) {
        this.availablePartNumber.set(availablePartNumber);
    }

    public String getAvailableHot() {
        return availableHot.get();
    }

    public void setAvailableHot(String availableHot) {
        this.availableHot.set(availableHot);
    }
}
