package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> pvPowerDayOneInHours = Arrays.asList(0,0,0,0,0,0,0,0,0,113,1119,663,1693,691,1392,798,374,22,0,0,0,0,0,0);


        User user = new User("Benni", 12345, new ArrayList<>(), new ArrayList<>());
        PVData monday = new PVData("Monday", pvPowerDayOneInHours);
        user.addCar("BMW i4", 60, 60, 4);
        System.out.println("Current battery power level: " + user.getCars().get(0).getCurrentBatteryCapacity());
        LocalDateTime p = LocalDateTime.now();
        LocalDateTime f = LocalDateTime.now().plusHours(2);
        user.addDrive(p, f, 10);

        LocalDateTime p2 = LocalDateTime.now().plusDays(1).plusHours(5);
        LocalDateTime f2 = LocalDateTime.now().plusHours(6);
        user.addDrive(p2, f2, 10);

        //System.out.println(p.getDayOfWeek());
        user.getCars().get(0).decreaseCurrentBatteryCapacity(user.getDrives().get(0));
        System.out.println("New battery power level after drive: " + user.getCars().get(0).getCurrentBatteryCapacity());
        System.out.println("Driving duration: ~" + user.getDrives().get(0).getAwayTime() + "h");

        List<PVData> d = new ArrayList<>();
        d.add(monday);
        PVSystem data = new PVSystem(d, user);

        System.out.println(data.getCarParkedHoursForCar(0));
    }
}