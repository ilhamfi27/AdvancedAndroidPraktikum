package com.example.advancedandroidpraktikum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class DetailKontak extends AppCompatActivity {

    ListView listNomor;
    int[] idNomor;
    int idKontak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kontak);
        initializeComponents();
        populateListView();
        clickListView();
        Bundle data = getIntent().getExtras();
        idKontak = data.getInt("id");
    }

    private void initializeComponents(){
        listNomor = findViewById(R.id.list_nomor);
    }

    private void populateListView(){
        DataTransaction dt = new DataTransaction(this);
        ArrayList<TeleponModel> dataTelepon = dt.getNomorFromKontak(idKontak);
        String[] nomor = new String[dataTelepon.size()];

        for (int i = 0; i < dataTelepon.size(); i++){
            idNomor[i] = dataTelepon.get(i).getId();
            nomor[i] = dataTelepon.get(i).getNomor();
        }

        ArrayAdapter adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                nomor
        );
        listNomor.setAdapter(adapter);
    }

    private void clickListView(){
        listNomor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle data = new Bundle();
                data.putInt("id", idNomor[i]);
//                Intent intent = new Intent(KontakActivity.this, DetailKontak.class);
//                intent.putExtras(data);
//                startActivity(intent);
                Log.d("info", "onItemClick: Clicked");
            }
        });
    }

}
