package edu.iis.mto.time;

import org.joda.time.DateTime;

public class MyDateTime implements DateTimeClock {

    private DateTime dataTime;

    public MyDateTime() {
        dataTime = new DateTime();
    }

    public void setNewDateTime(DateTime dataTime) {
        this.dataTime = dataTime;
    }

    @Override
    public DateTime getDateTime() {
        return dataTime;
    }
}
