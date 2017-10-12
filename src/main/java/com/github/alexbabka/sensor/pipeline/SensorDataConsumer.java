package com.github.alexbabka.sensor.pipeline;

import com.github.alexbabka.sensor.bean.SensorData;
import com.github.alexbabka.sensor.service.SensorDataProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class SensorDataConsumer {
    private static final Logger LOG = LoggerFactory.getLogger(SensorDataConsumer.class);

    private AtomicLong processItemsAmount = new AtomicLong(0);

    @Autowired
    private SensorDataQueue sensorDataQueue;
    @Autowired
    private TaskExecutor taskExecutor;
    @Autowired
    private SensorDataProcessingService processingService;

    @PostConstruct
    public void afterPropertiesSet() {
        new Thread(() -> {
            while (true) {
                SensorData sensorData = sensorDataQueue.take();

                processItemsAmount.incrementAndGet();

                try {
                    taskExecutor.execute(() -> processingService.process(sensorData));
                } catch (TaskRejectedException e) {
                    LOG.error("Executor failed to process task");
                }
            }
        }).start();
    }

    public long amountProcessed() {
        return processItemsAmount.longValue();
    }
}
