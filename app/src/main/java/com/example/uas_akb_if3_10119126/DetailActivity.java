package com.example.uas_akb_if3_10119126;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

// NIM: 10119126
// Nama: Dicky Setiadi
// Kelas: IF-3

public class DetailActivity extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    TextView judul, deskripsi, tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        database = new Database(this);
        judul = findViewById(R.id.judul);
        deskripsi = findViewById(R.id.deskripsi);
        tanggal = findViewById(R.id.tanggal);
        btn_simpan = findViewById(R.id.btn_simpan);
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM catatan WHERE judul = '" +
                getIntent().getStringExtra("judul") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            judul.setText(cursor.getString(0).toString());
            deskripsi.setText(cursor.getString(1).toString());
            tanggal.setText(cursor.getString(2).toString());
        }
    }
}