package com.example.prac1.ui.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.prac1.data.model.ImageTextModel;
import com.example.prac1.data.repository.AnimalsRepository;

import java.util.List;

public class RecyclerViewViewModel extends ViewModel {

    private LiveData<List<ImageTextModel>> dogsData;
    private LiveData<List<ImageTextModel>> catsData;

    public RecyclerViewViewModel() {
        AnimalsRepository animalsRepository = new AnimalsRepository();
        dogsData = animalsRepository.getDogsData();
        catsData = animalsRepository.getCatsData();
    }

    public LiveData<List<ImageTextModel>> getDogsData() {
        return dogsData;
    }

    public LiveData<List<ImageTextModel>> getCatsData() {
        return catsData;
    }
}
