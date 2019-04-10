package edu.iis.mto.time;

import org.joda.time.DateTime;

public class FakeDateTime {

    private DateTime dataTime;

    public FakeDateTime() {
        dataTime = new DateTime();
    }

    public void setNewDataTime(DateTime dataTime) {
        this.dataTime = dataTime;
    }

    public DateTime getDataTime() {
        return dataTime;
    }
}
