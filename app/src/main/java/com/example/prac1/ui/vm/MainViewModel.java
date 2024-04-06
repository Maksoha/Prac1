package com.example.prac1.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.prac1.data.model.AnimalEntity;
import com.example.prac1.data.repository.AppRepository;

import java.util.List;

public class MainViewModel extends AndroidViewModel {

    AppRepository appRepository;

    public LiveData<List<AnimalEntity>> getAllAnimals() {
        return appRepository.getAllAnimals();
    }

    public void addAnimal(String name) {
        appRepository.addAnimals(new AnimalEntity(name));
    }

    public MainViewModel(@NonNull Application application) {
        super(application);

        appRepository = new AppRepository(application);
    }

    public LiveData<String> getButtonNavigateToCats() {
        return appRepository.getNavigateButtonCats();
    }

    public LiveData<String> getButtonNavigateToDogs() {
        return appRepository.getNavigateButtonDogs();
    }

    public LiveData<List<Integer>> getColors() {
        return appRepository.getColors();
    }
}
