package com.example.mobil_programlama_ders.activities.main_activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.mobil_programlama_ders.R;
import com.google.android.material.button.MaterialButton;

public class MainFragment extends Fragment {

    private TextView blankTextView;
    private MaterialButton blankButton;

    public MainFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_main,null);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        initComponents(view);
        registerEventHandler();
    }

    private void initComponents(View view){
        blankTextView = view.findViewById(R.id.blankTextView);
        blankButton = view.findViewById(R.id.blankButton);
    }
    
    private void registerEventHandler(){
        blankButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Butona Bastın", Toast.LENGTH_SHORT).show();
                blankTextView.setText("Yarak");
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentView, SharedPreferenecesFragment.class, null)
                        .commit();
            }
        });
    }
}