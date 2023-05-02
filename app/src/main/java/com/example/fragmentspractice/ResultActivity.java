package com.example.fragmentspractice;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    ImageView img;
    TextView header, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        img = findViewById(R.id.resultIV);
        header = findViewById(R.id.resultTV1);
        desc = findViewById(R.id.resultTV2);

        int resId = getIntent().getIntExtra("img",0);
        String header1 = getIntent().getStringExtra("header");
        String desc1 = getIntent().getStringExtra("desc");

        img.setImageResource(resId);
        header.setText(header1);
        desc.setText(desc1);






    }
}