package com.example.homework8android1.fragments;

import static androidx.fragment.app.FragmentKt.setFragmentResult;
import static androidx.fragment.app.FragmentKt.setFragmentResultListener;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.homework8android1.R;
import com.example.homework8android1.databinding.FragmentTaskBinding;
import com.example.homework8android1.fragments.models.TaskModel;

import java.util.Objects;

public class TaskFragment extends Fragment {
    FragmentTaskBinding binding;
    TaskModel taskModel;
    String value;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentTaskBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sentData();

    }

    private void sentData() {
        binding.btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = binding.etTask.getText().toString().trim();
                taskModel = new TaskModel(task);
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", taskModel);
                Navigation.findNavController(view).navigate(R.id.homeFragment, bundle);
            }
        });
        if (getArguments() != null) {
            taskModel = (TaskModel) getArguments().getSerializable("marsel");
            binding.etTask.setText(taskModel.getTask());
        }
    }
}