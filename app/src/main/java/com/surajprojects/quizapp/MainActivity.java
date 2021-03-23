package com.surajprojects.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> arrayList = new ArrayList<>();
    Bitmap bitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void submit(View v){
        Intent intent = new Intent(getApplicationContext(), Questions.class);
        switch (v.getId()){
            case R.id.reg1:
                 arrayList.add("Manoj Kumar");
                 arrayList.add("11811654");
                intent.putExtra("reg", arrayList);

                startActivity(intent);

            case R.id.reg2:
                arrayList.add("Suraj Patil");
                arrayList.add("11811754");
                intent.putExtra("reg",arrayList);

                startActivity(intent);

            case R.id.reg3:
                arrayList.add("Amit Singh");
                arrayList.add("11809654");
                intent.putExtra("reg", arrayList);

                startActivity(intent);

            case R.id.reg4:
                arrayList.add("Ankur Singh");
                arrayList.add("11862074");
                intent.putExtra("reg", arrayList);

                startActivity(intent);

            case R.id.reg5:
                arrayList.add("Shivani Kapoor");
                arrayList.add("11892090");
                intent.putExtra("reg", arrayList);

                startActivity(intent);

            case R.id.reg6:
                arrayList.add("Amrit Kumar");
                arrayList.add("11811800");
                intent.putExtra("reg", arrayList);

                startActivity(intent);

            case R.id.reg7:
                arrayList.add("Ajay Panwal");
                arrayList.add("11809011");
                intent.putExtra("reg", arrayList);

                startActivity(intent);

            case R.id.reg8:
                arrayList.add("Anmol Parakh");
                arrayList.add("11899123");
                intent.putExtra("reg", arrayList);

                startActivity(intent);
        }
    }
}