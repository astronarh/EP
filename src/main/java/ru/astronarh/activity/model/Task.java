package ru.astronarh.activity.model;

public class Task {


    private Long id;
    private boolean complete;
    private String postValue;
    private String randomData;
    private String sum;
    private String taskCharacteristic;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
    public String getPostValue() {
        return postValue;
    }

    public void setPostValue(String postValue) {
        this.postValue = postValue;
    }

    public String getRandomData() {
        return randomData;
    }

    public void setRandomData(String randomData) {
        this.randomData = randomData;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getTaskCharacteristic() {
        return taskCharacteristic;
    }

    public void setTaskCharacteristic(String taskCharacteristic) {
        this.taskCharacteristic = taskCharacteristic;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", complete=" + complete +
                ", postValue='" + postValue + '\'' +
                ", randomData='" + randomData + '\'' +
                ", sum='" + sum + '\'' +
                ", taskCharacteristic='" + taskCharacteristic + '\'' +
                '}';
    }
}
