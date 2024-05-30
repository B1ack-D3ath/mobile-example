package com.example.mobil_programlama_ders.activities.main_activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import com.example.mobil_programlama_ders.R;
import com.google.android.material.textview.MaterialTextView;

public class MainActivity extends AppCompatActivity {

    private MaterialTextView textView;
    private FragmentContainerView fragmentView;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents(){
        textView = findViewById(R.id.textView);
        preferences = getPreferences(MODE_PRIVATE);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentView, MainFragment.class, null)
                .commit();
    }
}