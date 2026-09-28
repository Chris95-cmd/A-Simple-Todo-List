package org.example;
import java.util.ArrayList;

public class TodoList {
    private ArrayList<Task> taskList;

    public TodoList() {
        taskList = new ArrayList<>();
    }

    public void addTask(String taskName, String taskDescription){
        if (taskName == null || taskName.trim().isEmpty()){
            System.out.println("Cannot add a blank Task Name!");
            return;
        }
        taskList.add(new Task(taskName, taskDescription));
    }

    public void completeTaskItem(String taskName){
        for (Task n : taskList){
            if (n.getTaskName().equals(taskName)){
                n.completeTask();
                return;
            }
        }
        System.out.println("Task not found: " + taskName);
    }

    public void printAllTasks() {
        for (Task n : taskList) {
            System.out.println("Your To-Do list is: " + n.getTaskName());
        }
    }

    public void printIncompleteTasks() {
        for (Task n : taskList) {
            if (!n.isTaskComplete()) {
                System.out.println(n.getTaskName());
            }
        }
    }

    public void clearTasks(){
        taskList.clear();
    }
}
