package com.hanati.ddolmen;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_history, btn_counsel, btn_join, btn_hanamembers, btn_hanalife;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();


    }

    void initView(){    //화면의 View 정의
        btn_history = (Button)findViewById(R.id.btn_history);
        btn_counsel = (Button)findViewById(R.id.btn_counsel);
        btn_join = (Button)findViewById(R.id.btn_join);
        btn_hanamembers = (Button)findViewById(R.id.btn_hanamembers);
        btn_hanalife = (Button)findViewById(R.id.btn_hanalife);

        viewPager = (ViewPager)findViewById(R.id.viewPager);
    }


}

