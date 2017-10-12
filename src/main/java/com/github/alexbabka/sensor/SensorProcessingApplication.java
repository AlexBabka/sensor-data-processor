package com.github.alexbabka.sensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SensorProcessingApplication {
    public static void main(String[] args) {
        SpringApplication.run(SensorProcessingApplication.class, args);
    }
}
