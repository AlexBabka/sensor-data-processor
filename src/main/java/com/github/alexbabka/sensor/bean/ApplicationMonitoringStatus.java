package com.github.alexbabka.sensor.bean;

public class ApplicationMonitoringStatus {
    private int internalQueueLoad;
    private int executorQueueLoad;
    private long processedItemsAmount;

    public ApplicationMonitoringStatus(int internalQueueLoad, int executorQueueLoad, long processedItemsAmount) {
        this.internalQueueLoad = internalQueueLoad;
        this.executorQueueLoad = executorQueueLoad;
        this.processedItemsAmount = processedItemsAmount;
    }

    public int getInternalQueueLoad() {
        return internalQueueLoad;
    }

    public void setInternalQueueLoad(int internalQueueLoad) {
        this.internalQueueLoad = internalQueueLoad;
    }

    public int getExecutorQueueLoad() {
        return executorQueueLoad;
    }

    public void setExecutorQueueLoad(int executorQueueLoad) {
        this.executorQueueLoad = executorQueueLoad;
    }

    public long getProcessedItemsAmount() {
        return processedItemsAmount;
    }

    public void setProcessedItemsAmount(long processedItemsAmount) {
        this.processedItemsAmount = processedItemsAmount;
    }
}
