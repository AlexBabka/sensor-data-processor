package com.github.alexbabka.sensor.bean;

public class SensorData {
    private Long sensorId;
    private Boolean value;

    public SensorData(Long sensorId, Boolean value) {
        this.sensorId = sensorId;
        this.value = value;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
    }

    public Boolean getValue() {
        return value;
    }

    public void setValue(Boolean value) {
        this.value = value;
    }
}
