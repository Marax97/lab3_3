package edu.iis.mto.time;

import org.joda.time.DateTime;

public class MyDateTime {

    private DateTime dataTime;

    public MyDateTime() {
        dataTime = new DateTime();
    }

    public void setNewDataTime(DateTime dataTime) {
        this.dataTime = dataTime;
    }

    public DateTime getDataTime() {
        return dataTime;
    }
}
