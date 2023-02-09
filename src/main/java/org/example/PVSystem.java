package org.example;

import java.util.Arrays;
import java.util.List;

public class PVSystem {
    List<PVData> pvDataForSevenDays;
    User user;

    public PVSystem(List<PVData> pvDataForSevenDays, User user) {
        this.pvDataForSevenDays = pvDataForSevenDays;
        this.user = user;
    }

    public List<Integer> getCarParkedHoursForCar(int carNumber) {
        List<Integer> carParked = Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);

        for (Drive drive : this.user.getDrives()) {
            int abfahrt = drive.getDepartureTime();
            int ankunft = drive.getArrivalTime();

            for (int startDriveHour = abfahrt; startDriveHour <= ankunft; startDriveHour++) {
                carParked.set(startDriveHour, 1);
            }
        }

        return carParked;
    }

    public List<PVData> getPvDataForSevenDays() {
        return pvDataForSevenDays;
    }

    public void setPvDataForSevenDays(List<PVData> pvDataForSevenDays) {
        this.pvDataForSevenDays = pvDataForSevenDays;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
