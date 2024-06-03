package com.example.mobil_programlama_ders.activities.main_activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobil_programlama_ders.R;
import com.google.android.material.textfield.TextInputLayout;

public class SqlLiteWriteFragment extends Fragment {

    private TextInputLayout isimTextInputLayout,soyisimTextInputLayout

    public SqlLiteWriteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sql_lite_write, container, false);
        initComponents(view);
        registerEventHandler();
        return view;
    }

    private void initComponents(View view){

    }

    private void registerEventHandler(){

    }
}