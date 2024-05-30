package com.example.mobil_programlama_ders.activities.main_activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mobil_programlama_ders.R;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView textView;
    private FragmentContainerView fragmentView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents(){
        textView = findViewById(R.id.textView);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentView, MainFragment.class, null)
                .commit();
    }
}