package org.example;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private int zipCode; // postal code
    private List<Car> cars = new ArrayList();
    private List<Drive> drives = new ArrayList<>();

    private List<String> driveList = new ArrayList<>();

    /**
     * A class which describes a user.
     * A user can have several cars aswell as planned drives for a car
     *
     * @param name    the name of the user
     * @param zipCode the postal code of the user
     * @param cars    a list of cars that the user has
     * @param drives  a list of drives that the user has planned
     */
    public User(String name, int zipCode, List<Car> cars, List<Drive> drives) {
        this.name = name;
        this.zipCode = zipCode;
        this.cars = cars;
        this.drives = drives;
    }

    public String getCarNames() {
        StringBuilder s = new StringBuilder();
        for (Car car : this.getCars()) {
            s.append(car.getCarName());
        }

        return s.toString();
    }

    public void addDriveList(String s) {
        driveList.add(s);
    }

    public List<String> getDriveList() {
        return driveList;
    }


    /**
     * adds a car to the list of current cars
     *
     * @param carName
     * @param maxBatteryCapacity
     * @param currentBatteryCapacity
     * @param maxChargeRate
     */
    public void addCar(String carName, int maxBatteryCapacity, int currentBatteryCapacity, int maxChargeRate) {
        Car car = new Car(carName, maxBatteryCapacity, currentBatteryCapacity, maxChargeRate);
        cars.add(car);
    }

    /**
     * adds planned drives for a car
     * @param departure
     * @param arrival
     * @param batteryUsage
     */
    public void addDrive(LocalDateTime departure, LocalDateTime arrival, int batteryUsage, Car car) {
        Drive drive = new Drive(departure, arrival, batteryUsage, car);
        drives.add(drive);
    }

    public void addDriveByString(String departure, String arrival, String batteryUsage) {
        LocalDateTime dep = LocalDateTime.parse(departure);
        LocalDateTime arr = LocalDateTime.parse(arrival);
        int batUsage = Integer.parseInt(batteryUsage);

        addDrive(dep, arr, batUsage, this.getCars().get(0));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Drive> getDrives() {
        return drives;
    }

    public void setDrives(List<Drive> drives) {
        this.drives = drives;
    }
}
