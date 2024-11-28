package com.example.mobil_programlama_ders.activities.main_activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobil_programlama_ders.R;
import com.example.mobil_programlama_ders.entities.Ogrenci;

public class FirebaseDatabaseFragment extends Fragment {

    private Ogrenci ogrenci;

    public FirebaseDatabaseFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_firebase_database, container, false);
        initComponents(view);
        registerEventHandler();
        return view;
    }
    
    private void initComponents(View view){

    }

    private void registerEventHandler(){

    }
}