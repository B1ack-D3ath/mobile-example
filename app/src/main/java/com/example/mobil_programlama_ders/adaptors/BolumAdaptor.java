package com.example.mobil_programlama_ders.adaptors;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mobil_programlama_ders.entities.Bolum;

import java.util.List;

public class BolumAdaptor extends ArrayAdapter<Bolum> {

    private Context context;
    private List<Bolum> bolums;
    public BolumAdaptor(Context context,int textViewResourceId,List<Bolum> bolums){
        super(context,textViewResourceId,bolums);
        this.context = context;
        this.bolums = bolums;
    }

    @Override
    public int getCount(){return bolums.size();}

    @Override
    public Bolum getItem(int indeks){return bolums.get(indeks);}

    @Override
    public View getView(int position, View view, ViewGroup parent){
        TextView label = (TextView) super.getView(position, view, parent);
        label.setText(bolums.get(position).getBolumAdi());
        return label;
    }

    @Override
    public View getDropDownView(int position,View view,ViewGroup parent){
        TextView label = (TextView) super.getDropDownView(position, view, parent);
        label.setText(bolums.get(position).getBolumAdi());
        return label;
    }
}
