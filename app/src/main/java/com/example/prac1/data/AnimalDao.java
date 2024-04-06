package com.example.prac1.data;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.prac1.data.model.AnimalEntity;

import java.util.List;

@Dao
public interface AnimalDao {
    @Query("SELECT * FROM animalentity")
    LiveData<List<AnimalEntity>> getAllItems();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(AnimalEntity entity);
}
