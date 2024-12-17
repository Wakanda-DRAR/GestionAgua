package com.example.GestionAgua;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SensorData {
    @Id
    private String sensorId;
    private double value;

    // Getters y setters
    public String getSensorId() {
        return sensorId;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}

