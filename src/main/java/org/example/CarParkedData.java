package org.example;

import java.util.Arrays;
import java.util.List;

public class CarParkedData {
    private User user;

    public CarParkedData(User user) {
        this.user = user;//idk
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
