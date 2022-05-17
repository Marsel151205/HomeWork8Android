package com.example.homework8android1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.homework8android1.R;
import com.example.homework8android1.adapters.TaskAdapter;
import com.example.homework8android1.databinding.FragmentHomeBinding;
import com.example.homework8android1.fragments.models.TaskModel;
import com.example.homework8android1.interf.OnItemClickListener;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    TaskAdapter taskAdapter = new TaskAdapter();
    TaskModel taskModel;
    ArrayList<TaskModel> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.recyclerTaskTxt.setAdapter(taskAdapter);
        getData();
        listeners();
        taskModel = null;
        taskAdapter = null;
    }

    private void getData() {
        if (getArguments() !=null) {
            taskModel = (TaskModel) getArguments().getSerializable("key");
            list.add(taskModel);
            taskAdapter.getData(list);
        }
    }

    private void listeners() {
        binding.btnOpenInputTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.taskFragment);
            }
        });
        taskAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(TaskModel taskModel, int adapterPosition) {

            }

            @Override
            public void onItemClick(TaskModel taskModel) {
                Bundle bundle = new Bundle();
                bundle.putSerializable("marsel", taskModel);
                Navigation.findNavController(requireView()).navigate(R.id.taskFragment, bundle) ;
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}