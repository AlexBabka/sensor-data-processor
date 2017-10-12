package com.github.alexbabka.sensor.pipeline;

import com.github.alexbabka.sensor.bean.SensorData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.stream.IntStream;

@Component
public class SensorDataProducer {

    @Autowired
    private SensorDataQueue dataQueue;

    @Scheduled(fixedRate = 1000)
    public void produce() {
        Random random = new Random();

        IntStream.range(0, 10000)
                .forEach((i) -> dataQueue.push(new SensorData(random.nextLong(), random.nextBoolean())));
    }
}
