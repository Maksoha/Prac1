package com.example.prac1.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.prac1.databinding.FragmentRecyclerViewBinding;
import com.example.prac1.ui.adapters.ImageTextAdapter;
import com.example.prac1.ui.vm.RecyclerViewViewModel;

import java.util.Collections;

public class RecyclerViewFragment extends Fragment {

    FragmentRecyclerViewBinding binding;

    private RecyclerViewViewModel viewViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        viewViewModel = new ViewModelProvider(requireActivity()).get(RecyclerViewViewModel.class);

        binding = FragmentRecyclerViewBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String data = getArguments().getString("key");
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireContext()));
        ImageTextAdapter adapter = new ImageTextAdapter();
        binding.recyclerView.setAdapter(adapter);
        if (data == "dogs") {
            viewViewModel.getDogsData().observe(getViewLifecycleOwner(), listData ->
                    adapter.updateList(listData));
            viewViewModel.getDogTitle().observe(getViewLifecycleOwner(), title ->
                    binding.title.setText(title));
        } else if (data == "cats") {
            viewViewModel.getCatsData().observe(getViewLifecycleOwner(), listData ->
                    adapter.updateList(listData));
            viewViewModel.getCatTitle().observe(getViewLifecycleOwner(), title ->
                    binding.title.setText(title));
        }
    }
}