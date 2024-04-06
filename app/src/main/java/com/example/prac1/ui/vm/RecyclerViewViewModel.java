package com.example.prac1.ui.vm;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.prac1.data.model.ImageTextModel;
import com.example.prac1.data.repository.AppRepository;

import java.util.List;

public class RecyclerViewViewModel extends AndroidViewModel {

    private LiveData<List<ImageTextModel>> dogsData;
    private LiveData<List<ImageTextModel>> catsData;

    private LiveData<String> dogTitle;
    private LiveData<String> catTitle;


    public RecyclerViewViewModel(@NonNull Application application) {
        super(application);
        AppRepository appRepository = new AppRepository(application);
        dogsData = appRepository.getDogsData();
        catsData = appRepository.getCatsData();
        dogTitle = appRepository.getDogTitle();
        catTitle = appRepository.getCatTitle();
    }

    public LiveData<List<ImageTextModel>> getDogsData() {
        return dogsData;
    }

    public LiveData<String> getDogTitle() {
        return dogTitle;
    }

    public LiveData<String> getCatTitle() {
        return catTitle;
    }

    public LiveData<List<ImageTextModel>> getCatsData() {
        return catsData;
    }
}
