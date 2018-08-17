package ru.astronarh.activity.service;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class EPService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    public String startProcess(String postValue){
        Map<String, Object> variables = new HashMap<String, Object>();
        variables.put("postValue", postValue);
        runtimeService.startProcessInstanceByKey("testTask", variables);
        return "Process started";
    }

    public void completeTask(String taskId) {
        Task task = taskService.createTaskQuery().taskId(taskId).includeProcessVariables().orderByTaskCreateTime().desc().singleResult();

        Map<String, Object> taskVaribles = task.getProcessVariables();

        ru.astronarh.activity.model.Task myTask = new ru.astronarh.activity.model.Task();
        myTask.setId(Long.valueOf(task.getId()));
        myTask.setComplete(true);
        myTask.setPostValue((String) taskVaribles.get("postValue"));
        myTask.setRandomData(taskVaribles.get("randomData").toString());
        myTask.setSum(String.valueOf((Integer.parseInt(String.valueOf(taskVaribles.get("postValue"))) + (int)taskVaribles.get("randomData"))));
        myTask.setTaskCharacteristic(task.getName());
        EndTaskList.addTask(myTask);

        taskService.complete(taskId);
    }

    public List<Task> getAllTasks() {
        return taskService.createTaskQuery().list();
    }

}
