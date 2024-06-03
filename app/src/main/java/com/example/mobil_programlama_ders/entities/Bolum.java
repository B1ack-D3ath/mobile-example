package com.example.mobil_programlama_ders.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bolum")
public class Bolum {

    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "bolum_adi")
    private String bolumAdi;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBolumAdi() {
        return bolumAdi;
    }

    public void setBolumAdi(String bolumAdi) {
        this.bolumAdi = bolumAdi;
    }
}
