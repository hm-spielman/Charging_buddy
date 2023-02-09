package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Drive {
    private LocalDateTime departure;
    private LocalDateTime arrival;
    private int batteryUsage;

    /**
     *
     * @param departure
     * @param arrival
     * @param batteryUsage
     */
    public Drive(LocalDateTime departure, LocalDateTime arrival, int batteryUsage) {
        this.departure = departure;
        this.arrival = arrival;
        this.batteryUsage = batteryUsage;
    }

    public float getAwayTime() {
        // Anzahl der Abwesenheitszeit des Autos in GANZEN Stunden
        return (float)this.departure.until(this.arrival, ChronoUnit.HOURS);
    }

    public String getDay() {
        return getDeparture().getDayOfWeek().toString();
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
