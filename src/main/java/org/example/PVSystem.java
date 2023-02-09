package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * autostandzeit & autoladdezeit (=autostandzeit)
 * autoabwesenheit
 */
public class PVSystem {
    List<List<Integer>> sevenDayList = new ArrayList<>();
    User user;

    public PVSystem(User user) {
        this.user = user;
        initialiseArray();
    }

    public void fillCarParkedHours(int carNumber) {
        for (Drive drive : getUser().getDrives()) {
            int dayNumber = drive.getDayNumber();
            int abfahrt = drive.getDepartureTime();
            int ankunft = drive.getArrivalTime();

            for (int drivingHour = abfahrt; drivingHour <= ankunft; drivingHour++) {
                sevenDayList.get(dayNumber).set(drivingHour, 1);
            }
        }
    }

    public List<List<Integer>> getSevenDayList(int carNumber) {
        fillCarParkedHours(carNumber);
        return List.copyOf(sevenDayList);
    }

    private void initialiseArray() {
        for (int i = 0; i < 7; i++) {
            sevenDayList.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
