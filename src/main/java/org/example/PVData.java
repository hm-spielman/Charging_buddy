package org.example;

import java.util.List;

public class PVData {
    private String dayName;
    private List<Integer> pvPowerDayInHours;

    private User user;

    public PVData(String dayName, List<Integer> pvPowerDayInHours) {
        this.dayName = dayName;
        this.pvPowerDayInHours = pvPowerDayInHours;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public List<Integer> getPvPowerDayInHours() {
        return pvPowerDayInHours;
    }

    public void setPvPowerDayInHours(List<Integer> pvPowerDayInHours) {
        this.pvPowerDayInHours = pvPowerDayInHours;
    }
}
