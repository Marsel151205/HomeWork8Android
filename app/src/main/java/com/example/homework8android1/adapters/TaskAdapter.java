package com.example.homework8android1.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.homework8android1.databinding.TaskItemBinding;
import com.example.homework8android1.fragments.models.TaskModel;
import com.example.homework8android1.interf.OnItemClickListener;

import java.util.ArrayList;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.TaskHolder> {

    ArrayList<TaskModel> list = new ArrayList<>();
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TaskHolder(TaskItemBinding.inflate(LayoutInflater.from(parent.getContext())));
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        holder.onBind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void getData(ArrayList<TaskModel> taskModel){
        this.list.addAll(taskModel);
        notifyDataSetChanged();
    }

    public class TaskHolder extends RecyclerView.ViewHolder {
        TaskItemBinding binding;
        public TaskHolder(@NonNull TaskItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(TaskModel taskModel) {
            binding.tvTaskData.setText(taskModel.getTask());
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onItemClickListener.onItemClick(taskModel);

                }
            });
        }
    }

}
