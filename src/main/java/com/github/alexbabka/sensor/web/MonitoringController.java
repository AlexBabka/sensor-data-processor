package com.github.alexbabka.sensor.web;

import com.github.alexbabka.sensor.bean.ApplicationMonitoringStatus;
import com.github.alexbabka.sensor.pipeline.SensorDataConsumer;
import com.github.alexbabka.sensor.pipeline.SensorDataQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MonitoringController {

    @Autowired
    private SensorDataQueue sensorDataQueue;

    @Autowired
    private SensorDataConsumer sensorDataConsumer;

    @Autowired
    private TaskExecutor taskExecutor;

    @GetMapping("/status")
    @ResponseBody
    public ApplicationMonitoringStatus appStatus() {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = (ThreadPoolTaskExecutor) this.taskExecutor;

        int executorQueueSize = threadPoolTaskExecutor.getThreadPoolExecutor().getQueue().size();
        return new ApplicationMonitoringStatus(sensorDataQueue.load(), executorQueueSize, sensorDataConsumer.amountProcessed());
    }
}
