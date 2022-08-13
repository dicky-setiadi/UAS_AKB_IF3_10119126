package com.example.uas_akb_if3_10119126;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;

// NIM: 10119126
// Nama: Dicky Setiadi
// Kelas: IF-3

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager viewPager;
    private ArrayList<Model> modelArrayList;
    private Adapter adapter;
    private MaterialButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        viewPager = findViewById(R.id.viewPager);
        loadCards();

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                String title = modelArrayList.get(position).getTitle();

                if (position == modelArrayList.size()-1){
                    button.setText("Started");
                } else {
                    button.setText("Next");
                }
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (viewPager.getCurrentItem()+1<modelArrayList.size()){
                    viewPager.setCurrentItem(viewPager.getCurrentItem()+1);
                } else {
                    //kembali ke main activity
                    startActivity(new Intent(ViewPagerActivity.this, LoginActivity.class));
                    finish();
                }
            }
        });
    }

    private void loadCards() {
        modelArrayList = new ArrayList<>();

        modelArrayList.add(new Model("Write It!","Tulis apapun yang penting untukmu!",R.drawable.icon1));
        modelArrayList.add(new Model("Save It!","Simpan catatan yang penting untukmu!",R.drawable.icon2));
        modelArrayList.add(new Model("Organize!","Mengatur catatan pentingmu agar tetap terorganisir!",R.drawable.icon3));

        adapter = new Adapter(this,modelArrayList);
        viewPager.setAdapter(adapter);
        viewPager.setPadding(100,0,100,0);
    }

}
