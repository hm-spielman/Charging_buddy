package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        User user = new User("Benni", 12345, new ArrayList<>(), new ArrayList<>());
        user.addCar("BMW i4", 60, 60, 4);

        LocalDateTime p = LocalDateTime.now();
        LocalDateTime f = LocalDateTime.now().plusHours(3);
        user.addDrive(p, f, 20, user.getCars().get(0));
        user.getCars().get(0).decreaseCurrentBatteryCapacity(user.getDrives().get(0));

        System.out.println("New battery power level after drive: " + user.getCars().get(0).getCurrentBatteryCapacity());

        PVSystem data = new PVSystem(user);
        System.out.println(data.getSevenDayList("BMW i4"));

        data.chargeBattery(user.getCars().get(0),3,15,17);

        System.out.println("New battery power level after drive: " + user.getCars().get(0).getCurrentBatteryCapacity());

        new FXGUI();
    }
}