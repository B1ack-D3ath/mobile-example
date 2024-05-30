package com.example.mobil_programlama_ders.activities.main_activity;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.mobil_programlama_ders.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.zip.Inflater;

public class SharedPreferenecesFragment extends Fragment {

    private TextInputLayout textInputLayout;
    private MaterialButton materialButton;

    public SharedPreferenecesFragment() {    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shared_prefereneces, container, false);
        textInputLayout = view.findViewById(R.id.searchTextInputLayout);
        materialButton = view.findViewById(R.id.materialButton);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState){

    }
}