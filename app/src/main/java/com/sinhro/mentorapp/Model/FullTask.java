package com.sinhro.mentorapp.Model;

import java.io.Serializable;
import java.net.URL;

public class FullTask implements Serializable {
    Task task;
    String description;
    URL url;

    public FullTask(Task task, String description) {
        this.task = task;
        this.description = description;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }
}
