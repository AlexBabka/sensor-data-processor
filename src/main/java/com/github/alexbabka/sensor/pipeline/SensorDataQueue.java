package com.github.alexbabka.sensor.pipeline;

import com.github.alexbabka.sensor.bean.SensorData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Component
public class SensorDataQueue {
    private static final Logger LOG = LoggerFactory.getLogger(SensorDataQueue.class);

    private final BlockingQueue<SensorData> sensorDataBlockingQueue = new LinkedBlockingQueue<>(1000);

    public void push(SensorData data) {
        try {
            sensorDataBlockingQueue.put(data);
        } catch (InterruptedException e) {
            LOG.error("Error while adding element to the queue");
        }
    }

    public SensorData take() {
        try {
            return sensorDataBlockingQueue.take();
        } catch (InterruptedException e) {
            LOG.error("Error while getting element from the queue");
        }

        return null;
    }

    public int load() {
        return sensorDataBlockingQueue.size();
    }
}
