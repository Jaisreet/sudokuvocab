package com.example.sudokuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class First_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
    }

    public void newGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    public void settingPage(View view) {
        Intent intent = new Intent(this, setting_page.class);
        this.startActivity(intent);

    }

}
