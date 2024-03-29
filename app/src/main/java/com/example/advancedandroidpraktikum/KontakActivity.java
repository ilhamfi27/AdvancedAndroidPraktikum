package com.example.advancedandroidpraktikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class KontakActivity extends AppCompatActivity {

    ListView listKontak;
    int[] idKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        initializeComponents();
        populateListView();
        clickListView();
    }

    private void initializeComponents(){
        listKontak = findViewById(R.id.list_kontak);
    }

    private void populateListView(){
        DataTransaction dt = new DataTransaction(this);
        ArrayList<ContactModel> dataKontak = dt.getAllData();
        idKontak = new int[dataKontak.size()];
        String[] nama = new String[dataKontak.size()];

        for (int i = 0; i < dataKontak.size(); i++){
            idKontak[i] = dataKontak.get(i).getId();
            nama[i] = dataKontak.get(i).getNamaDepan() + " " + dataKontak.get(i).getNamaBelakang();
            Log.d("populate", "Data nama: " + dataKontak.get(i).getNamaDepan() + " " + dataKontak.get(i).getNamaBelakang());
        }

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                nama
        );
        listKontak.setAdapter(adapter);
    }

    private void clickListView(){
        listKontak.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle data = new Bundle();
                data.putInt("id", idKontak[i]);
                Intent intent = new Intent(KontakActivity.this, DetailKontak.class);
                intent.putExtras(data);
                startActivity(intent);
                Log.d("info", "onItemClick: Clicked");
            }
        });
    }

}
