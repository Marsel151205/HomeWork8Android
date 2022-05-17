package com.example.homework8android1.fragments.models;

import java.io.Serializable;

public class TaskModel implements Serializable {
    String task;

    public String getTask() {
        return task;
    }

    public TaskModel(String task) {
        this.task = task;
    }
}
