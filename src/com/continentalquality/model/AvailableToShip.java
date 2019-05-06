package com.continentalquality.model;

import javafx.beans.property.*;

public class AvailableToShip {

    private IntegerProperty readyLotId = new SimpleIntegerProperty(0);
    private StringProperty readyLotNumber = new SimpleStringProperty("");
    private StringProperty readyPartNumber = new SimpleStringProperty("");
    private BooleanProperty readyCompleted = new SimpleBooleanProperty(false);

    public AvailableToShip() {
    }

    public AvailableToShip(Integer readyLotId, String readyLotNumber, String readyPartNumber, Boolean readyCompleted) {
        this.readyLotId = new SimpleIntegerProperty(readyLotId);
        this.readyLotNumber = new SimpleStringProperty(readyLotNumber);
        this.readyPartNumber = new SimpleStringProperty(readyPartNumber);
        this.readyCompleted = new SimpleBooleanProperty(readyCompleted);
    }

//    Getters


    public int getReadyLotId() {
        return readyLotId.get();
    }

    public IntegerProperty readyLotIdProperty() {
        return readyLotId;
    }

    public String getReadyLotNumber() {
        return readyLotNumber.get();
    }

    public StringProperty readyLotNumberProperty() {
        return readyLotNumber;
    }

    public String getReadyPartNumber() {
        return readyPartNumber.get();
    }

    public StringProperty readyPartNumberProperty() {
        return readyPartNumber;
    }

    public boolean isReadyCompleted() {
        return readyCompleted.get();
    }

    public BooleanProperty readyCompletedProperty() {
        return readyCompleted;
    }

//    Setters


    public void setReadyLotId(int value) {
        this.readyLotId.set(value);
    }

    public void setReadyLotNumber(String value) {
        this.readyLotNumber.set(value);
    }

    public void setReadyPartNumber(String value) {
        this.readyPartNumber.set(value);
    }

    public void setReadyCompleted(boolean value) {
        this.readyCompleted.set(value);
    }
}