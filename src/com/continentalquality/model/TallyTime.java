package com.continentalquality.model;

public class TallyTime {

    private int timeId;
    private int timeEmployeeId;
    private String timeStart;
    private String timeStop;
    private int timeTallyId;

    public int getTimeId() {
        return timeId;
    }

    public void setTimeId(int timeId) {
        this.timeId = timeId;
    }

    public int getTimeEmployeeId() {
        return timeEmployeeId;
    }

    public void setTimeEmployeeId(int timeEmployeeId) {
        this.timeEmployeeId = timeEmployeeId;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeStop() {
        return timeStop;
    }

    public void setTimeStop(String timeStop) {
        this.timeStop = timeStop;
    }

    public int getTimeTallyId() {
        return timeTallyId;
    }

    public void setTimeTallyId(int timeTallyId) {
        this.timeTallyId = timeTallyId;
    }
}
