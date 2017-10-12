package com.github.alexbabka.sensor.service;

import com.github.alexbabka.sensor.bean.SensorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SensorDataProcessingService {
    private static final Logger LOG = LoggerFactory.getLogger(SensorDataProcessingService.class);

    public void process(SensorData data) {
//        LOG.info("Processed one data from sensor: " + data.getSensorId());
    }
}
