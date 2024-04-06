package com.example.prac1.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.prac1.R;
import com.example.prac1.data.FileUtils;
import com.example.prac1.data.SharedPreferenceUtils;
import com.example.prac1.databinding.FragmentMainBinding;
import com.example.prac1.ui.vm.MainViewModel;

import java.util.Random;

public class MainFragment extends Fragment {

    FragmentMainBinding binding;

    private MainViewModel viewViewModel;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FileUtils.writeToFile(requireContext(), "example1.txt", "startFragment");

        boolean result = FileUtils.writeToExternalStorage("example2.txt", "текст");
        if (result) {
            Log.i("write", "Файл успешно создан и данные записаны");
        } else {
            Log.i("write", "Ошибка при создании файла или записи данных");
        }

        SharedPreferenceUtils.saveData(requireContext(), "some_data");

        binding = FragmentMainBinding.inflate(inflater, container, false);

        viewViewModel = new ViewModelProvider(requireActivity()).get(MainViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewViewModel.getButtonNavigateToCats().observe(getViewLifecycleOwner(), text ->
                binding.navigateToCats.setText(text));

        viewViewModel.getButtonNavigateToDogs().observe(getViewLifecycleOwner(), text ->
                binding.navigateToDogs.setText(text));

        binding.navigateToCats.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", "cats");
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_recycleViewFragment, bundle);
        });

        binding.navigateToDogs.setOnClickListener(v -> {
            Bundle bundle = new Bundle();
            bundle.putString("key", "dogs");
            Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_recycleViewFragment, bundle);
        });

        binding.colorButton.setOnClickListener(v -> {
            viewViewModel.getColors().observe(getViewLifecycleOwner(), colors ->
                    binding.getRoot().setBackgroundColor(colors.get(new Random().nextInt()))
            );
        });

        binding.navigateToAnimals.setOnClickListener(v ->
                Navigation.findNavController(view).navigate(R.id.action_mainFragment_to_animalsFragment));

    }
}