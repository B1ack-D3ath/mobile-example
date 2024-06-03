package com.example.mobil_programlama_ders.interfaces;

import android.hardware.lights.LightsManager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mobil_programlama_ders.entities.Bolum;

import java.util.List;

@Dao
public interface IBolumDao {

    @Insert
    void insertBolum(Bolum bolum);

    @Update
    void updateBolum(Bolum bolum);

    @Delete
    void deleteBolum(Bolum bolum);

    @Query("Select * From bolum ")
    List<Bolum> loadAllBolum();

    @Query("Select * From bolum Where id=:bolumId")
    Bolum loadBolumById(long bolumId);
}
