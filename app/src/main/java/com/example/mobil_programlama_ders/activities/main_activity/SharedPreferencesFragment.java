package com.example.mobil_programlama_ders.activities.main_activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mobil_programlama_ders.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class SharedPreferencesFragment extends Fragment {

    private TextInputLayout sharedPreferencesTextInputLayout;
    private MaterialButton sharedPreferencesButton;

    public SharedPreferencesFragment() {    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shared_preferences, container, false);
        initComponents(view);
        registerEventHandler();
        return view;
    }

    private void initComponents(View view){
        sharedPreferencesTextInputLayout = view.findViewById(R.id.sharedPreferencesTextInputLayout);
        sharedPreferencesButton = view.findViewById(R.id.sharedPreferencesButton);
    }

    private void registerEventHandler(){
        sharedPreferencesTextInputLayout_endIconOnClick();
    }

    private void sharedPreferencesTextInputLayout_endIconOnClick(){
        sharedPreferencesTextInputLayout.setEndIconOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String preferencesString = Objects.requireNonNull(sharedPreferencesTextInputLayout.getEditText()).getText().toString();
                SharedPreferences.Editor editor = getActivity().getPreferences(Context.MODE_PRIVATE).edit();
                editor.putString("textInputLayout",preferencesString);
                editor.apply();
            }
        });
    }

    private void sharedPreferencesButton_onClick(){
        sharedPreferencesButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentView, MainFragment.class, null)
                        .commit();
            }
        });
    }
}