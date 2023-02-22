package com.example.sudokuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class setting_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page);
    }

    public void backToMain(View view){
        Intent intent = new Intent(this, First_page.class);
        this.startActivity(intent);
    }


}