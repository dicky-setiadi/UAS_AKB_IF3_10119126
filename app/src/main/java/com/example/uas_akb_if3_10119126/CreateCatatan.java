
package com.example.uas_akb_if3_10119126;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;

// NIM: 10119126
// Nama: Dicky Setiadi
// Kelas: IF-3

public class CreateCatatan extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_simpan;
    EditText judul, deskripsi, tanggal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_catatan);
        database = new Database(this);
        judul = findViewById(R.id.judul);
        deskripsi = findViewById(R.id.deskripsi);
        btn_simpan = findViewById(R.id.btn_simpan);
        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pattern = "dd-MM-yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String tanggal = simpleDateFormat.format(new Date());
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("INSERT INTO catatan(judul, deskripsi, tanggal) values('" +
                        judul.getText().toString()+ "','" +
                        deskripsi.getText().toString() +"','"+ tanggal + "')");
                Toast.makeText(CreateCatatan.this, "Data Tersimpan", Toast.LENGTH_SHORT).show();
                NotesFragment.notes.RefreshList();
                finish();
            }
        });
    }
}