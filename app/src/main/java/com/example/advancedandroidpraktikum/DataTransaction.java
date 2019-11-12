package com.example.advancedandroidpraktikum;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataTransaction extends DataHelper {
    public DataTransaction(@Nullable Context context) {
        super(context);
    }

    public ArrayList<ContactModel> getAllData(){
        SQLiteDatabase db = this.getReadableDatabase();
        String querySelect = "Select * FROM contact";
        ContactModel cm = new ContactModel();
        ArrayList<ContactModel> arrCon = new ArrayList<ContactModel>();
        Cursor cursor = db.rawQuery(querySelect, null);
        while (cursor.moveToNext()){
            cm.setId(Integer.parseInt(cursor.getString(0)));
            cm.setNamaDepan(cursor.getString(1));
            cm.setNamaBelakang(cursor.getString(2));
            arrCon.add(cm);
        }
        return arrCon;
    }
}
