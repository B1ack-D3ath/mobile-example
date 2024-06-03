package com.example.mobil_programlama_ders;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mobil_programlama_ders.converters.DateConverter;
import com.example.mobil_programlama_ders.entities.Bolum;
import com.example.mobil_programlama_ders.entities.Ogrenci;
import com.example.mobil_programlama_ders.interfaces.IBolumDao;
import com.example.mobil_programlama_ders.interfaces.IOgrenciDao;

@Database(entities = {Bolum.class, Ogrenci.class},version = 1,exportSchema = true)
@TypeConverters(DateConverter.class)
public abstract class DatabaseConnection extends RoomDatabase {
    private static DatabaseConnection databaseConnection;
    public abstract IOgrenciDao getOgrenciDao();
    public abstract IBolumDao getBolumDao();
    private static final String databaseName="fakulte";

    public static DatabaseConnection getAppDatabase(Context context){
        if (databaseConnection == null){
            databaseConnection = Room.databaseBuilder(context, DatabaseConnection.class,databaseName).allowMainThreadQueries().addCallback(new Callback() {
                @Override
                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                    super.onOpen(db);
                    db.disableWriteAheadLogging();
                }
            }).build();
        }
        return databaseConnection;
    }

    public static void destroyInstance(){
        databaseConnection = null;
    }
}
