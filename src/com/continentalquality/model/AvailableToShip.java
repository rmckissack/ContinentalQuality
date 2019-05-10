package com.continentalquality.model;

import javafx.beans.property.*;
import javafx.scene.control.CheckBox;

public class AvailableToShip {


    private IntegerProperty readyLotId = new SimpleIntegerProperty(0);
    private StringProperty readyLotNumber = new SimpleStringProperty("");
    private StringProperty readyPartNumber = new SimpleStringProperty("");
    private IntegerProperty readyPerBox = new SimpleIntegerProperty(0);
    private IntegerProperty readyPerSkid = new SimpleIntegerProperty(0);
    private BooleanProperty readyCompleted = new SimpleBooleanProperty(false);
    private IntegerProperty readyBoxed = new SimpleIntegerProperty(0);
    private IntegerProperty readyShipped = new SimpleIntegerProperty(0);
    private IntegerProperty readyToShip = new SimpleIntegerProperty(0);
    private CheckBox select = new CheckBox();

    public AvailableToShip() {
    }

    public AvailableToShip(IntegerProperty readyLotId, StringProperty readyLotNumber, StringProperty readyPartNumber, IntegerProperty readyPerBox, IntegerProperty readyPerSkid, BooleanProperty readyCompleted, IntegerProperty readyBoxed, IntegerProperty readyShipped, IntegerProperty readyToShip, CheckBox select) {
        this.readyLotId = readyLotId;
        this.readyLotNumber = readyLotNumber;
        this.readyPartNumber = readyPartNumber;
        this.readyPerBox = readyPerBox;
        this.readyPerSkid = readyPerSkid;
        this.readyCompleted = readyCompleted;
        this.readyBoxed = readyBoxed;
        this.readyShipped = readyShipped;
        this.readyToShip = readyToShip;
        this.select = select;
    }

    public int getReadyLotId() {
        return readyLotId.get();
    }

    public IntegerProperty readyLotIdProperty() {
        return readyLotId;
    }

    public void setReadyLotId(int readyLotId) {
        this.readyLotId.set(readyLotId);
    }

    public String getReadyLotNumber() {
        return readyLotNumber.get();
    }

    public StringProperty readyLotNumberProperty() {
        return readyLotNumber;
    }

    public void setReadyLotNumber(String readyLotNumber) {
        this.readyLotNumber.set(readyLotNumber);
    }

    public String getReadyPartNumber() {
        return readyPartNumber.get();
    }

    public StringProperty readyPartNumberProperty() {
        return readyPartNumber;
    }

    public void setReadyPartNumber(String readyPartNumber) {
        this.readyPartNumber.set(readyPartNumber);
    }

    public int getReadyPerBox() {
        return readyPerBox.get();
    }

    public IntegerProperty readyPerBoxProperty() {
        return readyPerBox;
    }

    public void setReadyPerBox(int readyPerBox) {
        this.readyPerBox.set(readyPerBox);
    }

    public int getReadyPerSkid() {
        return readyPerSkid.get();
    }

    public IntegerProperty readyPerSkidProperty() {
        return readyPerSkid;
    }

    public void setReadyPerSkid(int readyPerSkid) {
        this.readyPerSkid.set(readyPerSkid);
    }

    public boolean isReadyCompleted() {
        return readyCompleted.get();
    }

    public BooleanProperty readyCompletedProperty() {
        return readyCompleted;
    }

    public void setReadyCompleted(boolean readyCompleted) {
        this.readyCompleted.set(readyCompleted);
    }

    public int getReadyBoxed() {
        return readyBoxed.get();
    }

    public IntegerProperty readyBoxedProperty() {
        return readyBoxed;
    }

    public void setReadyBoxed(int readyBoxed) {
        this.readyBoxed.set(readyBoxed);
    }

    public int getReadyShipped() {
        return readyShipped.get();
    }

    public IntegerProperty readyShippedProperty() {
        return readyShipped;
    }

    public void setReadyShipped(int readyShipped) {
        this.readyShipped.set(readyShipped);
    }

    public int getReadyToShip() {
        return readyToShip.get();
    }

    public IntegerProperty readyToShipProperty() {
        return readyToShip;
    }

    public void setReadyToShip(int readyToShip) {
        this.readyToShip.set(readyToShip);
    }

    public javafx.scene.control.CheckBox getSelect() {
        return select;
    }

    public void setSelect(javafx.scene.control.CheckBox select) {
        this.select = select;
    }
}
