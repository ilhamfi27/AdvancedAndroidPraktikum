package com.example.advancedandroidpraktikum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class KontakActivity extends AppCompatActivity {

    ListView listKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kontak);

        initializeComponents();
        populateListView();
    }

    private void initializeComponents(){
        listKontak = findViewById(R.id.list_kontak);
    }

    private void populateListView(){
        DataTransaction dt = new DataTransaction(this);
        ArrayList dataKontak = dt.getAllData();
        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                dataKontak
        );
        listKontak.setAdapter(adapter);
    }

}
