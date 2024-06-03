package com.example.mobil_programlama_ders.entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "ogrenci",foreignKeys = {@ForeignKey(entity = Bolum.class,parentColumns = "id",childColumns = "bolum_id",onDelete = ForeignKey.CASCADE,onUpdate = ForeignKey.CASCADE)})
public class Ogrenci {
    @PrimaryKey(autoGenerate = true)
    private long id;
    private String ad;
    private String soyad;
    @ColumnInfo(name = "bolum_id")
    private long bolumId;
    @ColumnInfo(name = "ogrenci_no")
    private long ogrenciNo;
    @ColumnInfo(name = "mezun_durumu")
    private int nezunDurumu;
    @Ignore
    private String adSoyad;
    @Ignore
    private Bolum bolum;

    private int donem;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public long getBolumId() {
        return bolumId;
    }

    public void setBolumId(long bolumId) {
        this.bolumId = bolumId;
    }

    public long getOgrenciNo() {
        return ogrenciNo;
    }

    public void setOgrenciNo(long ogrenciNo) {
        this.ogrenciNo = ogrenciNo;
    }

    public int getNezunDurumu() {
        return nezunDurumu;
    }

    public void setNezunDurumu(int nezunDurumu) {
        this.nezunDurumu = nezunDurumu;
    }

    public String getAdSoyad() {
        return adSoyad;
    }

    public void setAdSoyad(String adSoyad) {
        this.adSoyad = adSoyad;
    }

    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

    public int getDonem() {
        return donem;
    }

    public void setDonem(int donem) {
        this.donem = donem;
    }
}
