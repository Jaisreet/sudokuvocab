package com.example.sudokuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private SudokuBoard gameBoard;
    private boardFill gameBoardFill;

    private Game_input input;

    private Button hint;
    private Button erase;

    private ImageView reset;
    private ImageView settingsDialog;

    private settingsDialog dialog;

    private Button resume;
    private Button settings;
    private Button newGame;
    private Button quitGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = findViewById(R.id.sudokuBoard);
        gameBoardFill = gameBoard.getBoardFill();
        gameBoardFill.getEmptyBoxIndexs();

        hint = (Button) findViewById(R.id.hint);
        hint.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        erase = (Button) findViewById(R.id.erase);
        erase.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                eraseText();
            }
        });

        reset = (ImageView) findViewById(R.id.resetbtn);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reset();
            }
        });


        settingsDialog = (ImageView) findViewById(R.id.settingsDialog);
        settingsDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               openSettingDialog();
               System.out.println("Hello from dialog");
            }
        });
    }
    public void backToMain(View view){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }


    public void BTNOnePress(View view) {
        gameBoardFill.setNumberPos(1);
        gameBoard.invalidate();
    }

    public void BTNTwoPress(View view) {
        gameBoardFill.setNumberPos(2);
        gameBoard.invalidate();
    }

    public void BTNThreePress(View view) {
        gameBoardFill.setNumberPos(3);
        gameBoard.invalidate();
    }

    public void BTNFourPress(View view) {
        gameBoardFill.setNumberPos(4);
        gameBoard.invalidate();
    }

    public void BTNFivePress(View view) {
        gameBoardFill.setNumberPos(5);
        gameBoard.invalidate();
    }

    public void BTNSixPress(View view) {
        gameBoardFill.setNumberPos(6);
        gameBoard.invalidate();
    }

    public void BTNSevenPress(View view) {
        gameBoardFill.setNumberPos(7);
        gameBoard.invalidate();
    }

    public void BTNEightPress(View view) {
        gameBoardFill.setNumberPos(8);
        gameBoard.invalidate();
    }

    public void BTNNinePress(View view) {
        gameBoardFill.setNumberPos(9);
        gameBoard.invalidate();
    }

    public void eraseText() {
        gameBoardFill.eraseNumber();
    }

    public void reset() {
       boardFill board= new boardFill();

    }
    public void openDialog() {
        hintDialog hint = new hintDialog();
        hint.show(getSupportFragmentManager(), "hintDialog");
    }

    public void openSettingDialog() {
        settingsDialog settings = new settingsDialog();
        settings.show(getSupportFragmentManager(), "Settings");
    }
}