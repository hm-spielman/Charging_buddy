package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PVData {
    private String dayName;
    private List<Integer> pvPowerDayInHours;

    List<List<Integer>> sevenDayList = new ArrayList<>();

    public PVData(String dayName, List<Integer> pvPowerDayInHours) {
        initialiseArray();
        this.dayName = dayName;
        this.pvPowerDayInHours = pvPowerDayInHours;
    }

    private void initialiseArray() {
            sevenDayList.add(Arrays.asList(0,0,0,0,0,0,0,0,0,113,1119,663,1693,691,1392,798,374,22,0,0,0,0,0,0)); //Montag
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
