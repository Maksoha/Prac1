package com.example.prac1.data.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.example.prac1.data.AppDatabase;
import com.example.prac1.data.data_source.AppData;
import com.example.prac1.data.model.AnimalEntity;
import com.example.prac1.data.model.ImageTextModel;

import java.util.List;

public class AppRepository {

    private AppDatabase appDatabase;

    public AppRepository(Application application) {
        appDatabase = AppDatabase.getDataBase(application);
    }
    public LiveData<List<AnimalEntity>> getAllAnimals() {
        return appDatabase.animalDao().getAllItems();
    }

    public void addAnimals(AnimalEntity animal) {
        AppDatabase.databaseWriterExecutor.execute(() -> {
            appDatabase.animalDao().insert(animal);
        });
    }

    public LiveData<List<ImageTextModel>> getDogsData() {
        return AppData.buildDogsData();
    }

    public LiveData<List<ImageTextModel>> getCatsData() {
        return AppData.buildCatsData();
    }

    public LiveData<String> getNavigateButtonCats() {
        return AppData.getButtonNavigateToCats();
    }

    public LiveData<String> getNavigateButtonDogs() {
        return AppData.getButtonNavigateToDogs();
    }

    public LiveData<List<Integer>> getColors() {
        return AppData.getColors();
    }

    public LiveData<String> getCatTitle() {
        return AppData.getCatTitle();
    }

    public LiveData<String> getDogTitle() {
        return AppData.getDogTitle();
    }


}
