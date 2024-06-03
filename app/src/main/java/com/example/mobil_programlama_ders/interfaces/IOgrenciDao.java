package com.example.mobil_programlama_ders.interfaces;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mobil_programlama_ders.entities.Ogrenci;

import java.util.List;

@Dao
public interface IOgrenciDao {

    @Insert
    void insertOgrenci(Ogrenci ogrenci);

    @Update
    void updateOgrenci(Ogrenci ogrenci);

    @Delete
    void deleteOgrenci(Ogrenci ogrenci);

    @Query("Select * From ogrenci")
    List<Ogrenci> loadAllOgrenci();

    @Query("Select * From ogrenci Where id=:ogrenciId")
    Ogrenci loadOgrenciById(long ogrenciId);

    @Query("Select * From ogrenci Where bolum_id=:bolumId and donem=:donem")
    List<Ogrenci> loadOgrenciByBolum(long bolumId,int donem);
}