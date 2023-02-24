package com.example.sudokuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private drawBoard gameBoard;
    private board_GamePlay gameBoardGamePlay;

    private Board_Generation input;

    private Button hint;
    private Button erase;

    private ImageView reset;
    private ImageView settingsDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = findViewById(R.id.sudokuBoard);
        gameBoardGamePlay = gameBoard.getBoardFill();
        gameBoardGamePlay.getEmptyBoxIndexs();

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
            }
        });


    }
    public void backToMain(){
        Intent intent = new Intent(this, First_page.class);
        this.startActivity(intent);
    }


    public void BTNOnePress(View view) {
        gameBoardGamePlay.setNumberPos(1);
        gameBoard.invalidate();
    }

    public void BTNTwoPress(View view) {
        gameBoardGamePlay.setNumberPos(2);
        gameBoard.invalidate();
    }

    public void BTNThreePress(View view) {
        gameBoardGamePlay.setNumberPos(3);
        gameBoard.invalidate();
    }

    public void BTNFourPress(View view) {
        gameBoardGamePlay.setNumberPos(4);
        gameBoard.invalidate();
    }

    public void BTNFivePress(View view) {
        gameBoardGamePlay.setNumberPos(5);
        gameBoard.invalidate();
    }

    public void BTNSixPress(View view) {
        gameBoardGamePlay.setNumberPos(6);
        gameBoard.invalidate();
    }

    public void BTNSevenPress(View view) {
        gameBoardGamePlay.setNumberPos(7);
        gameBoard.invalidate();
    }

    public void BTNEightPress(View view) {
        gameBoardGamePlay.setNumberPos(8);
        gameBoard.invalidate();
    }

    public void BTNNinePress(View view) {
        gameBoardGamePlay.setNumberPos(9);
        gameBoard.invalidate();
    }


    public void eraseText() {
        gameBoardGamePlay.eraseNumber();
    }

    public void reset() {
        for(ArrayList<Object> letter : gameBoardGamePlay.getEmptyBoxIndex()) {

            int r = (int) letter.get(0);
            int c = (int) letter.get(1);
            if (gameBoardGamePlay.getBoard()[r][c] != 0) {
                gameBoardGamePlay.getBoard()[r][c] = 0;
                }
        }
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

    public void settingPage() {
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