package ru.astronarh.activity.controller;

import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.astronarh.activity.model.PostValue;
import ru.astronarh.activity.service.EPService;
import ru.astronarh.activity.service.EndTaskList;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EPController {

    @Autowired
    private EPService epService;

    @RequestMapping(value = "/completetask")
    public String completeTask(@RequestParam String id) {
        epService.completeTask(id);
        return "Task with id " + id + " has been completed!";
    }

    /*@RequestMapping(value = "/start", method = RequestMethod.POST)
    public String start(@RequestParam String postValue) {
        return epService.startProcess(postValue);
    }*/

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    public @ResponseBody
    String start(@RequestBody PostValue postValue) {
        return epService.startProcess(postValue.getPostValue());
    }

    @RequestMapping(path = "/tasks")
    public List<ru.astronarh.activity.model.Task> tasks() {
        List<ru.astronarh.activity.model.Task> myTaskList = new ArrayList<>();
        List<Task> taskList = epService.getAllTasks();
        for (Task task : taskList) {
            ru.astronarh.activity.model.Task myTask = new ru.astronarh.activity.model.Task();
            myTask.setId(Long.valueOf(task.getId()));
            myTask.setTaskCharacteristic(task.getName());
            myTaskList.add(myTask);
        }
        return myTaskList;
    }

    @RequestMapping(value = "/result")
    public List<ru.astronarh.activity.model.Task> result() {
        return EndTaskList.getTaskList();
    }
}
