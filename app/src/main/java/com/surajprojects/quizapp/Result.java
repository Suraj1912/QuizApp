package com.surajprojects.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class Result extends AppCompatActivity {

    Button neww, rateus;
    RatingBar ratebar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        neww = findViewById(R.id.newbtn);
        rateus = findViewById(R.id.rateus);
        ratebar = findViewById(R.id.ratebar);

        neww.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        rateus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratebar.setVisibility(View.VISIBLE);
            }
        });
    }
}