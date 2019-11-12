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

        String queryInsert1 = "INSERT INTO contact (id, nama_depan, nama_belakang) VALUES (1, 'Wahid', 'Waluyo');";
        sqLiteDatabase.execSQL(queryInsert1);
        String queryInsert2 = "INSERT INTO contact (id, nama_depan, nama_belakang) VALUES (2, 'Bambang', 'Surapto');";
        sqLiteDatabase.execSQL(queryInsert2);
        String queryInsert3 = "INSERT INTO telepon (id, id_contact, nomor, jenis_contact) VALUES (1, 1, '089897683', 'Pribadi');";
        sqLiteDatabase.execSQL(queryInsert3);
        String queryInsert4 = "INSERT INTO telepon (id, id_contact, nomor, jenis_contact) VALUES (2, 2, '082113123', 'Kantor');";
        sqLiteDatabase.execSQL(queryInsert4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
}
