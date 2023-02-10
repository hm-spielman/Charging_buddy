package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * autostandzeit & autoladdezeit (=autostandzeit)
 * autoabwesenheit
 */
public class PVSystem {
    String canBeCharged;
    List<List<Integer>> carParked = new ArrayList<>();
    List<List<Integer>> pvPower = new ArrayList<>();

    private final int minimumPvChargePower = 0;
    User user;

    public PVSystem(User user) {
        this.user = user;
        initialiseCarParked();
        initialisePvPower();
    }

    /**
     * charges the battery until its full
     * OR until the user needs the car for another drive
     */
    public void chargeBattery(Car car, int dayNumber, int from, int to) {
        if (getSevenDayList(car.getCarName()).get(dayNumber).get(from) == 0) {
            if (getPvPower().get(dayNumber).get(from) >= minimumPvChargePower) {
                for (int i = from; i < to; i++)
                    car.chargeBattery();
                canBeCharged = ("Car " + car.getCarName() + " will be charged from " + from + "h to " + to + "h.");
            }
        } else {
            canBeCharged = ("Car " + car.getCarName() + " can not be charged at that time.");
        }
    }

    public String getCanBeCharged() {
        return canBeCharged;
    }

    public int getDayNumber(String s) {
        return switch (s) {
            case "Montag" -> 0;
            case "Dienstag" -> 1;
            case "Mittwoch" -> 2;
            case "Donnerstag" -> 3;
            case "Freitag" -> 4;
            case "Samstag" -> 5;
            case "Sonntag" -> 6;
            default -> -1;
        };
    }

    public void chargeBatteryWithString(String dayNum, String from, String to) {
        //int dayNumInt = Integer.parseInt(dayNum);
        //dayNumInt--;
        int dayNumInt = getDayNumber(dayNum);
        int fromInt = Integer.parseInt(from);
        int toInt = Integer.parseInt(to);

        chargeBattery(user.getCars().get(0), dayNumInt, fromInt, toInt);
    }

    public void fillCarParkedHours(String carName) {
        for (Drive drive : getUser().getDrives()) {
            if (drive.getCarName().equals(carName)) {
                int dayNumber = drive.getDayNumber();
                int abfahrt = drive.getDepartureTime();
                int ankunft = drive.getArrivalTime();

                for (int drivingHour = abfahrt; drivingHour <= ankunft; drivingHour++) {
                    carParked.get(dayNumber).set(drivingHour, 1);
                }
            }
        }
    }

    public List<List<Integer>> getSevenDayList(String carName) {
        fillCarParkedHours(carName);
        return List.copyOf(carParked);
    }

    public List<List<Integer>> getPvPower() {
        return List.copyOf(pvPower);
    }

    private void initialiseCarParked() {
        for (int i = 0; i < 7; i++) {
            carParked.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
        }
    }

    private void initialisePvPower() {
        pvPower.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 113, 1119, 663, 1693, 691, 1392, 798, 374, 22, 0, 0, 0, 0, 0, 0)); //Montag
        pvPower.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 113, 1119, 663, 1693, 691, 1392, 798, 374, 22, 0, 0, 0, 0, 0, 0)); //Montag
        pvPower.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 113, 1119, 663, 1693, 691, 1392, 798, 374, 22, 0, 0, 0, 0, 0, 0)); //Montag
        pvPower.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 113, 1119, 663, 1693, 691, 1392, 798, 374, 22, 0, 0, 0, 0, 0, 0)); //Montag
        pvPower.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 113, 1119, 663, 1693, 691, 1392, 798, 374, 22, 0, 0, 0, 0, 0, 0)); //Montag
        pvPower.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 113, 1119, 663, 1693, 691, 1392, 798, 374, 22, 0, 0, 0, 0, 0, 0)); //Montag
        pvPower.add(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 0, 0, 113, 1119, 663, 1693, 691, 1392, 798, 374, 22, 0, 0, 0, 0, 0, 0)); //Montag
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
