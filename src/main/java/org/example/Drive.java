package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Drive {
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private int batteryUsage;

    private Car car;

    /**
     * A drive having a departure/arrival time + battery usage for one car
     *
     * @param departure
     * @param arrival
     * @param batteryUsage
     */
    public Drive(LocalDateTime departure, LocalDateTime arrival, int batteryUsage, Car car) {
        this.departure = departure;
        this.arrival = arrival;
        this.batteryUsage = batteryUsage;
        this.car = car;
    }

    public String getCarName() {
        return car.getCarName();
    }

    public float getAwayTime() {
        // Anzahl der Abwesenheitszeit des Autos in GANZEN Stunden
        return (float)this.departure.until(this.arrival, ChronoUnit.HOURS);
    }

    public String getDay() {
        return getDeparture().getDayOfWeek().toString();
    }

    public int getDayNumber() {
        return switch (this.getDay()) {
            case "MONDAY" -> 0;
            case "TUESDAY" -> 1;
            case "WEDNESDAY" -> 2;
            case "THURSDAY" -> 3;
            case "FRIDAY" -> 4;
            case "SATURDAY" -> 5;
            case "SUNDAY" -> 6;
            default -> -1;
        };
    }

    public int getDepartureTime() {
        // Stunde von 0-23
        return departure.getHour();
    }

    public int getArrivalTime() {
        // Stunde von 0-23
        return arrival.getHour();
    }

    public LocalDateTime getDeparture() {
        return departure;
    }

    public void setDeparture(LocalDateTime departure) {
        this.departure = departure;
    }

    public LocalDateTime getArrival() {
        return arrival;
    }

    public void setArrival(LocalDateTime arrival) {
        this.arrival = arrival;
    }

    public int getBatteryUsage() {
        return batteryUsage;
    }

    public void setBatteryUsage(int batteryUsage) {
        this.batteryUsage = batteryUsage;
    }
}
