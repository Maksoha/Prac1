package com.example.prac1.ui.fragments;

import android.app.Application;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.prac1.R;
import com.example.prac1.data.data_source.AppData;
import com.example.prac1.data.repository.AppRepository;
import com.example.prac1.databinding.FragmentAnimalsBinding;
import com.example.prac1.ui.adapters.AnimalAdapter;
import com.example.prac1.ui.adapters.ImageTextAdapter;
import com.example.prac1.ui.vm.MainViewModel;


public class AnimalsFragment extends Fragment {

    FragmentAnimalsBinding binding;

    private MainViewModel viewViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        viewViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = FragmentAnimalsBinding.inflate(inflater);

        binding.listAnimals.setLayoutManager(new LinearLayoutManager(requireContext()));
        AnimalAdapter adapter = new AnimalAdapter();
        binding.listAnimals.setAdapter(adapter);

        binding.buttonAdd.setOnClickListener(v ->
                viewViewModel.addAnimal(binding.editTextAnimalName.getText().toString())
                );

        viewViewModel.getAllAnimals().observe(getViewLifecycleOwner(), animals ->
                adapter.setAnimalEntities(animals));
        return binding.getRoot();
    }
}