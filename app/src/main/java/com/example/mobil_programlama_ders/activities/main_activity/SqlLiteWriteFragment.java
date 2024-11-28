package com.example.mobil_programlama_ders.activities.main_activity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mobil_programlama_ders.DatabaseConnection;
import com.example.mobil_programlama_ders.R;
import com.example.mobil_programlama_ders.adaptors.BolumAdaptor;
import com.example.mobil_programlama_ders.entities.Bolum;
import com.example.mobil_programlama_ders.entities.Ogrenci;
import com.example.mobil_programlama_ders.interfaces.IBolumDao;
import com.example.mobil_programlama_ders.interfaces.IOgrenciDao;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.radiobutton.MaterialRadioButton;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;

public class SqlLiteWriteFragment extends Fragment {

    private TextInputLayout isimTextInputLayout,soyisimTextInputLayout,ogrenciNoTextInputLayout;
    private Spinner bolumSpinner;
    private RadioGroup mezunRadioGroup;
    private MaterialButton kaydetButton,fragmentOutButton;
    private DatabaseConnection databaseConnection;
    private IOgrenciDao ogrenciDao;
    private IBolumDao bolumDao;

    public SqlLiteWriteFragment() { }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sql_lite_write, container,false);
        initComponents(view);
        registerEventHandler();
        return view;
    }

    private void initComponents(View view){
        isimTextInputLayout = view.findViewById(R.id.sqlWriteIsimTextInputLayout);
        soyisimTextInputLayout = view.findViewById(R.id.sqlWriteSoyisimTextInputLayout);
        ogrenciNoTextInputLayout = view.findViewById(R.id.sqlWriteOgrenciNoTextInputLayout);
        bolumSpinner = view.findViewById(R.id.sqlWriteBolumSpinner);
        mezunRadioGroup = view.findViewById(R.id.sqlWriteMezunRadioGroup);
        kaydetButton = view.findViewById(R.id.sqlWriteOgrenciKaydetButton);
        fragmentOutButton = view.findViewById(R.id.sqlWriteFragmentOutButton);

        databaseConnection = DatabaseConnection.getAppDatabase(getActivity());
        ogrenciDao = databaseConnection.getOgrenciDao();
        bolumDao = databaseConnection.getBolumDao();

        //setBolumData();
        loadBolumData();
    }

    private void registerEventHandler(){
        setFragmentOutButton();
        setKaydetButton();
    }

    private void setFragmentOutButton(){
        fragmentOutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragmentView, MainFragment.class, null)
                        .commit();
            }
        });
    }

    private void setKaydetButton(){
        kaydetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Ogrenci ogrenci = new Ogrenci();
                ogrenci.setAd(isimTextInputLayout.getEditText().getText().toString());
                ogrenci.setSoyad(soyisimTextInputLayout.getEditText().getText().toString());
                ogrenci.setBolumId(bolumSpinner.getSelectedItemId());
                ogrenci.setOgrenciNo(Long.valueOf(ogrenciNoTextInputLayout.getEditText().getText().toString()));
                int mezunDurum = 0;
                if (mezunRadioGroup.getCheckedRadioButtonId() == R.id.sqlWriteMezunRadioGroupTrueButton){mezunDurum=1;}
                ogrenci.setNezunDurumu(mezunDurum);
                ogrenciDao.insertOgrenci(ogrenci);
                Toast.makeText(getActivity(), "Kayıt Başarılı", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setBolumData(){
        Bolum bolum = new Bolum();
        bolum.setId(1);
        bolum.setBolumAdi("Bilgisayar Müh.");
        bolumDao.insertBolum(bolum);
        bolum = new Bolum();
        bolum.setId(2);
        bolum.setBolumAdi("Elektrik Elektronik Müh.");
        bolumDao.insertBolum(bolum);
        bolum = new Bolum();
        bolum.setId(3);
        bolum.setBolumAdi("Makine Müh.");
        bolumDao.insertBolum(bolum);
    }

    private void loadBolumData(){
        List<Bolum> bolumList = bolumDao.loadAllBolum();
        BolumAdaptor bolumAdaptor = new BolumAdaptor(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,bolumList);
        bolumSpinner.setAdapter(bolumAdaptor);
    }
}