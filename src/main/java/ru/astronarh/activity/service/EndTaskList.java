package ru.astronarh.activity.service;

import ru.astronarh.activity.model.Task;

import java.util.ArrayList;
import java.util.List;

public class EndTaskList {
    private static List<Task> taskList = new ArrayList<>();

    public static List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        EndTaskList.taskList = taskList;
    }

    static void addTask(Task task) {
        taskList.add(task);
    }

}
