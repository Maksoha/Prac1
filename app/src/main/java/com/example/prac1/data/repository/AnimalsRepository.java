package com.example.prac1.data.repository;

import androidx.lifecycle.LiveData;

import com.example.prac1.data.data_source.AnimalsData;
import com.example.prac1.data.model.ImageTextModel;

import java.util.List;

public class AnimalsRepository {

    public LiveData<List<ImageTextModel>> getDogsData() {
        return AnimalsData.buildDogsData();
    }

    public LiveData<List<ImageTextModel>> getCatsData() {
        return AnimalsData.buildCatsData();
    }
}
