package ru.astronarh.activity.service;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class GenerateDataService implements JavaDelegate {

    public void execute(DelegateExecution execution) throws Exception {
        Random randomGenerator = new Random();
        int randomData = randomGenerator.nextInt(10);
        execution.setVariable("randomData", randomData);
    }
}
