package com.sinhro.mentorapp.Model;

import java.io.Serializable;
import java.util.List;

public class TasksList implements Serializable {
    private List<Task> tasks;

    public TasksList(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
