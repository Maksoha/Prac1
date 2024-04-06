package com.example.prac1.data.data_source;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.prac1.R;
import com.example.prac1.data.model.ImageTextModel;

import java.util.ArrayList;
import java.util.List;

public class AppData {

    public static LiveData<List<ImageTextModel>> buildDogsData() {
        MutableLiveData<List<ImageTextModel>> dogsData = new MutableLiveData<>();
        ArrayList<ImageTextModel> dogs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dogs.add(new ImageTextModel(R.drawable.dog, "собака" + i));
        }
        dogsData.setValue(dogs);
        return dogsData;
    }

    public static LiveData<List<ImageTextModel>> buildCatsData() {
        MutableLiveData<List<ImageTextModel>> catsData = new MutableLiveData<>();
        ArrayList<ImageTextModel> cats = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            cats.add(new ImageTextModel(R.drawable.cat, "кошка" + i));
        }
        catsData.setValue(cats);
        return catsData;
    }

    public static LiveData<String> getButtonNavigateToCats() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Перейти к котикам");
        return data;
    }

    public static LiveData<String> getButtonNavigateToDogs() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Перейти к собачкам");
        return data;
    }

    public static LiveData<List<Integer>> getColors() {
        MutableLiveData<List<Integer>> data = new MutableLiveData<>();
        ArrayList<Integer> list = new ArrayList<>();
        list.add(R.color.blue);
        list.add(R.color.white);
        list.add(R.color.black);
        list.add(R.color.green);
        list.add(R.color.yellow);
        return data;
    }

    public static LiveData<String> getCatTitle() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Коты");
        return data;
    }

    public static LiveData<String> getDogTitle() {
        MutableLiveData<String> data = new MutableLiveData<>();
        data.setValue("Собаки");
        return data;
    }

}
