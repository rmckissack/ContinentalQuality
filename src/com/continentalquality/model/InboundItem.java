package com.continentalquality.model;

public class InboundItem {

    private int inItemId;
    private int inLotId;
    private String inboundBOL;
    private String inPoNumber;
    private int inQuantityOfTubs;
    private int inQuantityOfSkids;
    private int inQuantityOfBoxes;

    public int getInItemId() {
        return inItemId;
    }

    public void setInItemId(int inItemId) {
        this.inItemId = inItemId;
    }

    public int getInLotId() {
        return inLotId;
    }

    public void setInLotId(int inLotId) {
        this.inLotId = inLotId;
    }

    public String getInboundBOL() {
        return inboundBOL;
    }

    public void setInboundBOL(String inboundBOL) {
        this.inboundBOL = inboundBOL;
    }

    public String getInPoNumber() {
        return inPoNumber;
    }

    public void setInPoNumber(String inPoNumber) {
        this.inPoNumber = inPoNumber;
    }

    public int getInQuantityOfTubs() {
        return inQuantityOfTubs;
    }

    public void setInQuantityOfTubs(int inQuantityOfTubs) {
        this.inQuantityOfTubs = inQuantityOfTubs;
    }

    public int getInQuantityOfSkids() {
        return inQuantityOfSkids;
    }

    public void setInQuantityOfSkids(int inQuantityOfSkids) {
        this.inQuantityOfSkids = inQuantityOfSkids;
    }

    public int getInQuantityOfBoxes() {
        return inQuantityOfBoxes;
    }

    public void setInQuantityOfBoxes(int inQuantityOfBoxes) {
        this.inQuantityOfBoxes = inQuantityOfBoxes;
    }
}
