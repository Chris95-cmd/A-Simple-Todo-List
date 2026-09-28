package org.example;

public class Task {
    private String taskName;
    private boolean taskComplete;
    private String taskDescription;

    public Task(String taskName, String taskDescription){
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskComplete = false;
    }

    public String getTaskName(){
        return taskName;
    }

    public boolean isTaskComplete(){
        return taskComplete;
    }

    public void completeTask(){
        taskComplete = true;
    }
}
