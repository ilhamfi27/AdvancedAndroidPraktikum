package com.example.advancedandroidpraktikum;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DataHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "db_kontak";
    private static final int DATABASE_VERSION = 1;

    public DataHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String queryTabelContact = "CREATE TABLE contact ( \n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "nama_depan TEXT,\n" +
                "nama_belakang TEXT" +
                ");";
        String queryTabelTelepon = "CREATE TABLE telepon ( \n" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                "id_contact INTEGER\n," +
                "nomor TEXT,\n" +
                "jenis_contact TEXT,\n" +
                "FOREIGN KEY (id_contact) REFERENCES contact (id)  \n" +
                ");";
        String insertContact = "";

        Log.d("info", "onCreate: " + queryTabelContact);
        Log.d("info", "onCreate: " + queryTabelTelepon);
        sqLiteDatabase.execSQL(queryTabelContact);
        sqLiteDatabase.execSQL(queryTabelTelepon);

        String queryInsert = "";

        queryInsert = "INSERT INTO contact (id, nama_depan, nama_belakang) VALUES (1, 'Wahid', 'Waluyo');";
        sqLiteDatabase.execSQL(queryInsert);
        queryInsert = "INSERT INTO contact (id, nama_depan, nama_belakang) VALUES (2, 'Bambang', 'Surapto');";
        sqLiteDatabase.execSQL(queryInsert);
        queryInsert = "INSERT INTO telepon (id, id_contact, nomor, jenis_contact) VALUES (1, 1, '089897683', 'Pribadi');";
        sqLiteDatabase.execSQL(queryInsert);
        queryInsert = "INSERT INTO telepon (id, id_contact, nomor, jenis_contact) VALUES (2, 2, '082113123', 'Kantor');";
        sqLiteDatabase.execSQL(queryInsert);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS contact");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS telepon");
        onCreate(sqLiteDatabase);
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
