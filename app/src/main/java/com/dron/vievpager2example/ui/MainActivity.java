package com.dron.vievpager2example.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.dron.vievpager2example.R;
import com.dron.vievpager2example.adapter.ViewPager2Adapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //объявим объект VP2
    ViewPager2 mViewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //найдем объект по id
        mViewPager2 = findViewById(R.id.viewPager2);

        // генерация списка
        List<String> list = new ArrayList<>();
        list.add("First Screen");
        list.add("Second Screen");
        list.add("Third Screen");
        list.add("Fourth Screen");


        //подключаем адаптер
        mViewPager2.setAdapter(new ViewPager2Adapter(this, list, mViewPager2));
    }

}