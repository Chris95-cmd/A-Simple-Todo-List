package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TodoListTest {

    @Test
    public void testTaskGetTaskName() {
        Task task = new Task("Buy milk", "Get 2% milk");
        assertEquals("Buy milk", task.getTaskName());
    }

    @Test
    public void testTaskStartsIncomplete() {
        Task task = new Task("Buy milk", "Get 2% milk");
        assertFalse(task.isTaskComplete());
    }

    @Test
    public void testTaskCompleteMarksComplete() {
        Task task = new Task("Buy milk", "Get 2% milk");
        task.completeTask();
        assertTrue(task.isTaskComplete());
    }

    @Test
    public void testTaskCompleteTwiceStaysComplete() {
        Task task = new Task("Buy milk", "Get 2% milk");
        task.completeTask();
        task.completeTask();
        assertTrue(task.isTaskComplete());
    }

    @Test
    public void testTaskEmptyDescriptionIsAllowed() {
        Task task = new Task("Buy milk", "");
        assertEquals("Buy milk", task.getTaskName());
        assertFalse(task.isTaskComplete());
    }

    @Test
    public void testTaskNullDescriptionDoesNotCrash() {
        assertDoesNotThrow(() -> new Task("Buy milk", null));
    }

    @Test
    public void testAddTaskDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(() -> todolist.addTask("Buy milk", "Get 2% milk"));
    }

    @Test
    public void testAddMultipleTasksDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(() -> {
            todolist.addTask("Buy milk", "Get 2% milk");
            todolist.addTask("Do homework", "Finish lab");
            todolist.addTask("Walk dog", "Around the block");
        });
    }

    @Test
    public void testAddBlankTaskNameDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(() -> todolist.addTask("", "description"));
    }

    @Test
    public void testAddSpacesOnlyTaskNameDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(() -> todolist.addTask("     ", "description"));
    }

    @Test
    public void testAddNullTaskNameDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(() -> todolist.addTask(null, "description"));
    }

    @Test
    public void testAddNullDescriptionDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(() -> todolist.addTask("Buy milk", null));
    }

    @Test
    public void testAddEmptyDescriptionDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(() -> todolist.addTask("Buy milk", ""));
    }

    @Test
    public void testAddDuplicateNamesDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(() -> {
            todolist.addTask("Buy milk", "first");
            todolist.addTask("Buy milk", "second");
        });
    }

    @Test
    public void testPrintAllOnEmptyListDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(todolist::printAllTasks);
    }

    @Test
    public void testPrintIncompleteOnEmptyListDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(todolist::printIncompleteTasks);
    }

    @Test
    public void testPrintAllWithTasksDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");
        todolist.addTask("Do homework", "Finish lab");
        todolist.completeTaskItem("Buy milk");

        assertDoesNotThrow(todolist::printAllTasks);
    }

    @Test
    public void testPrintIncompleteWithMixedTasksDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");
        todolist.addTask("Do homework", "Finish lab");
        todolist.completeTaskItem("Buy milk");

        assertDoesNotThrow(todolist::printIncompleteTasks);
    }

    @Test
    public void testPrintIncompleteWhenAllCompleteDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");
        todolist.completeTaskItem("Buy milk");

        assertDoesNotThrow(todolist::printIncompleteTasks);
    }

    @Test
    public void testCompleteExistingTaskDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");

        assertDoesNotThrow(() -> todolist.completeTaskItem("Buy milk"));
    }

    @Test
    public void testCompleteMissingTaskDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");

        assertDoesNotThrow(() -> todolist.completeTaskItem("Walk the dog"));
    }

    @Test
    public void testCompleteOnEmptyListDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(() -> todolist.completeTaskItem("Buy milk"));
    }

    @Test
    public void testCompleteNullDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");

        assertDoesNotThrow(() -> todolist.completeTaskItem(null));
    }

    @Test
    public void testCompleteEmptyStringDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");

        assertDoesNotThrow(() -> todolist.completeTaskItem(""));
    }

    @Test
    public void testCompleteSameTaskTwiceDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");
        todolist.completeTaskItem("Buy milk");

        assertDoesNotThrow(() -> todolist.completeTaskItem("Buy milk"));
    }

    @Test
    public void testCompleteWrongCaseDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");

        assertDoesNotThrow(() -> todolist.completeTaskItem("buy milk"));
    }

    @Test
    public void testClearOnEmptyListDoesNotCrash() {
        TodoList todolist = new TodoList();
        assertDoesNotThrow(todolist::clearTasks);
    }

    @Test
    public void testClearWithTasksDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");
        todolist.addTask("Do homework", "Finish lab");
        todolist.completeTaskItem("Buy milk");

        assertDoesNotThrow(todolist::clearTasks);
    }

    @Test
    public void testAddAfterClearDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");
        todolist.clearTasks();

        assertDoesNotThrow(() -> todolist.addTask("Do homework", "Finish lab"));
    }

    @Test
    public void testCompleteAfterClearDoesNotCrash() {
        TodoList todolist = new TodoList();
        todolist.addTask("Buy milk", "Get 2% milk");
        todolist.clearTasks();

        assertDoesNotThrow(() -> todolist.completeTaskItem("Buy milk"));
    }
}
