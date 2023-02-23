package com.example.sudokuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.graphics.Canvas;
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
    public void backToMain(){
        Intent intent = new Intent(this, First_page.class);
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

    public void checkSol(View view){

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
        final Dialog dialog = new Dialog(MainActivity.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.settings_dialog);
        // Set dialog title
        dialog.setTitle("Settings");
        // set values for custom dialog components - text, image and button
        Button resume = (Button) dialog.findViewById(R.id.resume);
        Button newgame = (Button) dialog.findViewById(R.id.newGameBtn);
        Button quitgame = (Button) dialog.findViewById(R.id.quitGame);
        Button settings = (Button) dialog.findViewById(R.id.settingsPage);

        dialog.show();
        dialog.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        // if decline button is clicked, close the custom dialog
        resume.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close dialog
                dialog.dismiss();
            }
        });

        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //do something more here
                startNewGame();

            }
        });

        quitgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quit();
                //do something more here
            }
        });

        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something more here
                settingPage();
            }
        });

    }
    public void startNewGame(){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    public void settingPage(){
        Intent intent = new Intent(this, setting_page.class);
        this.startActivity(intent);

    }

    public void quit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to quit?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        backToMain();
                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}