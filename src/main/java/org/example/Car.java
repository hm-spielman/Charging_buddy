package org.example;

public class Car {
    private String carName;
    private int maxBatteryCapacity;
    private int currentBatteryCapacity;
    private int maxChargeRate;

    /**
     * A class which represents a car. It has a name and a battery
     *
     * @param carName                the name of the car model
     * @param maxBatteryCapacity     the fixed maximum battery capacity in kWh
     * @param currentBatteryCapacity the current battery capacity in kWh; can be decreased by driving and increased by charging
     * @param maxChargeRate          the rate in kWh at which the battery can be charged
     */
    public Car(String carName, int maxBatteryCapacity, int currentBatteryCapacity, int maxChargeRate) {
        this.carName = carName;
        this.maxBatteryCapacity = maxBatteryCapacity;
        this.currentBatteryCapacity = currentBatteryCapacity;
        this.maxChargeRate = maxChargeRate;
    }

    /**
     * Decreases the current battery power by the value specified in a drive
     *
     * @param drive the drive which uses up battery power
     */
    public void decreaseCurrentBatteryCapacity(Drive drive) {
        int driveUsage = drive.getBatteryUsage();
        this.currentBatteryCapacity = currentBatteryCapacity - driveUsage;
    }

    /**
     * charges the battery until its full
     * OR until the user needs the car for another drive
     */
    public void chargeBattery() {
        //Ladezeiten
        while (this.currentBatteryCapacity < maxBatteryCapacity) {
            this.currentBatteryCapacity = this.currentBatteryCapacity + this.maxChargeRate;
        }

        // falls Batterie doch über max geht
        if (this.currentBatteryCapacity > maxBatteryCapacity) {
            this.currentBatteryCapacity = maxBatteryCapacity;
        }
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getMaxBatteryCapacity() {
        return maxBatteryCapacity;
    }

    public void setMaxBatteryCapacity(int maxBatteryCapacity) {
        this.maxBatteryCapacity = maxBatteryCapacity;
    }

    public int getCurrentBatteryCapacity() {
        return currentBatteryCapacity;
    }

    public void setCurrentBatteryCapacity(int currentBatteryCapacity) {
        this.currentBatteryCapacity = currentBatteryCapacity;
    }

    public int getMaxChargeRate() {
        return maxChargeRate;
    }

    public void setMaxChargeRate(int maxChargeRate) {
        this.maxChargeRate = maxChargeRate;
    }
}
