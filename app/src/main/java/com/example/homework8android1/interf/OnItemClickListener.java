package com.example.homework8android1.interf;

import com.example.homework8android1.fragments.models.TaskModel;

public interface OnItemClickListener {
    void onItemClick(TaskModel taskModel, int adapterPosition);

    void onItemClick(TaskModel taskModel);
}
