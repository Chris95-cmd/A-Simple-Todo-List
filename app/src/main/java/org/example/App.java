package org.example;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TodoList todolist = new TodoList();

        boolean running = true;
        while (running) {
            System.out.println("1. Add task");
            System.out.println("2. Show all");
            System.out.println("3. Complete Task");
            System.out.println("4. Clear To-Do List");
            System.out.println("5. Quit");
            System.out.print("Choose: ");
            String choice = input.nextLine();

            if (choice.equals("1")) {
                System.out.print("Task Name: ");
                String taskName = input.nextLine();
                System.out.print("Write a brief Task Description: ");
                String taskDescription = input.nextLine();
                todolist.addTask(taskName, taskDescription);
            } else if (choice.equals("2")) {
                todolist.printAllTasks();
                System.out.print("You still need to complete the following tasks: ");
                todolist.printIncompleteTasks();
            } else if (choice.equals("3")) {
                System.out.print("Enter the task name that you have completed: ");
                String taskName = input.nextLine();
                todolist.completeTaskItem(taskName);
            } else if (choice.equals("4")) {
                todolist.clearTasks();
            } else if (choice.equals("5")) {
                running = false;
            } else {
                System.out.println("Invalid choice, try again.");
            }
        }
    }
}
