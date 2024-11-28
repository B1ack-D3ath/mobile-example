package com.example.mobil_programlama_ders.activities.main_activity;

import android.content.Context;
import android.content.SharedPreferences;
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

    private TextView mainFragmentTextView;
    private MaterialButton mainFragmentToFragmentButton,mainFragmentGetPreferencesValueButton;

    public MainFragment(){
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent,Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.fragment_main,parent,false);
        initComponents(view);
        registerEventHandler();
        return view;
    }

    private void initComponents(View view){
        mainFragmentTextView = view.findViewById(R.id.mainFragmentTextView);
        mainFragmentToFragmentButton = view.findViewById(R.id.mainFragmentToFragmentButton);
        mainFragmentGetPreferencesValueButton = view.findViewById(R.id.mainFragmentGetPreferencesValueButton);
    }
    
    private void registerEventHandler(){
        setMainFragmentToFragmentButton_OnClick();
        setMainFragmentGetPreferencesValueButton_OnClick();
    }

    private void setMainFragmentToFragmentButton_OnClick(){
        mainFragmentToFragmentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Butona Bastın", Toast.LENGTH_SHORT).show();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentView, SqlLiteWriteFragment.class, null)
                        .commit();
            }
        });
    }

    private void setMainFragmentGetPreferencesValueButton_OnClick(){
        mainFragmentGetPreferencesValueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getActivity().getPreferences(Context.MODE_PRIVATE);
                    mainFragmentTextView.setText(preferences.getString("textInputLayout","Bulunamadi"));
            }
        });
    }
}