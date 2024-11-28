package com.example.mobil_programlama_ders.activities.main_activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobil_programlama_ders.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.imageview.ShapeableImageView;

public class FavouriteFragment extends Fragment {

    private MaterialButton buttonFavourite;
    private ShapeableImageView imageViewFavourite;

    public FavouriteFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_favourite,container, false);
        initComponents(view);
        registerEventHandler();
        return view;
    }

    private void initComponents(View view){
        buttonFavourite = view.findViewById(R.id.buttonFavouriteFragment);
        imageViewFavourite = view.findViewById(R.id.imageViewFavouriteFragment);
    }

    private void registerEventHandler(){
        buttonFavourite_onClick();
    }

    private void buttonFavourite_onClick(){
        buttonFavourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentView, MainFragment.class, null)
                        .commit();
            }
        });
    }
}