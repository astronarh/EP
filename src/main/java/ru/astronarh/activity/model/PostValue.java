package ru.astronarh.activity.model;

public class PostValue {
    private String postValue;

    public String getPostValue() {
        return postValue;
    }

    public void setPostValue(String postValue) {
        this.postValue = postValue;
    }

    @Override
    public String toString() {
        return "PostValue{" +
                "postValue='" + postValue + '\'' +
                '}';
    }
}
