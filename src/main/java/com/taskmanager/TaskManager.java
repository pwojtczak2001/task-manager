package com.taskmanager;

import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String description) {
        tasks.add(new Task(description));
    }

    private void validateId(int id) {
        if (id < 1 || id > tasks.size()) {
            throw new IllegalArgumentException("Invalid task id");
        }
    }

    public void deleteTask(int id) {
        validateId(id);
        tasks.remove(id-1);
    }

    public String getTaskDescription(int id) {
        validateId(id);
        return tasks.get(id-1).getDescription();
    }

    public boolean completeTask(int id) {
        validateId(id);
        if (tasks.get(id - 1).isCompleted()) {
            return false;
        } else {
            tasks.get(id-1).markCompleted();
            return true;
        }
    }

    public int getTasksCount() {
        return tasks.size();
    }

    public boolean isTaskCompleted(int id) {
        validateId(id);
        return tasks.get(id-1).isCompleted();
    }
}