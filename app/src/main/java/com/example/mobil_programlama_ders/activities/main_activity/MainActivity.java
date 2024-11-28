package com.example.mobil_programlama_ders.activities.main_activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainerView;

import com.example.mobil_programlama_ders.R;
import com.google.android.material.textview.MaterialTextView;
import com.google.firebase.Firebase;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;
    private MaterialTextView textView;
    private FragmentContainerView fragmentView;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }

    private void initComponents(){
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
        textView = findViewById(R.id.textView);
        preferences = getPreferences(MODE_PRIVATE);
        fragmentView = findViewById(R.id.fragmentView);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragmentView, MainFragment.class, null)
                .commit();
    }
}