package com.example.sudokuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private SudokuBoard gameBoard;
    private boardFill gameBoardFill;
    private Button hint;
    private Button erase;
    private Button check;
    private ImageView reset;
    private ImageView settingsDialog;

    public MainActivity() {
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = findViewById(R.id.sudokuBoard);
        gameBoardFill = gameBoard.getBoardFill();
        gameBoardFill.getEmptyBoxIndexs();

        //listener for hint button
        hint = (Button) findViewById(R.id.hint);
        hint.setOnClickListener(new View.OnClickListener() {
            //dialog box is opened when hint button is clicked
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });

        //listener for erase button
        erase = (Button) findViewById(R.id.erase);
        erase.setOnClickListener(new View.OnClickListener() {
            //eraseText function is called when erase button is clicked
            @Override
            public void onClick(View view) {
                eraseText();
            }
        });

        //listener for click button
        check = (Button) findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            //calls check function when check button is clicked
            @Override
            public void onClick(View v) {
                check();
            }
        });

        //listener for reset button
        reset = (ImageView) findViewById(R.id.resetbtn);
        reset.setOnClickListener(new View.OnClickListener() {
            //calls the reset function when reset button is clicked
            @Override
            public void onClick(View view) {
                reset();
            }
        });

        //setting dialog box
        settingsDialog = (ImageView) findViewById(R.id.settingsDialog);
        settingsDialog.setOnClickListener(new View.OnClickListener() {
            //setting dialog box is opened when setting button is clicked
            @Override
            public void onClick(View view) {
               openSettingDialog();
            }
        });


    }

    //if value at given row and column doesn't match with the value of solution at given row and column it is removed
    //otherwise it is kept in the board
    public void check(){
        for(ArrayList<Object> letter : gameBoardFill.getEmptyBoxIndex()) {
            int r = (int) letter.get(0);
            int c = (int) letter.get(1);
            if (gameBoardFill.getBoard()[r][c] != gameBoardFill.getSolution()[r][c]) {
                gameBoardFill.getBoard()[r][c] = 0;
            }
        }
    }
    //goes back to the first page of the game
    public void backToMain(){
        Intent intent = new Intent(this, First_page.class);
        this.startActivity(intent);
    }

    //setting value to 1 when button one is pressed that is "un"
    public void BTNOnePress(View view) {
        gameBoardFill.setNumberPos(1);
        gameBoard.invalidate();
    }

    //setting value to 2 when button two is pressed that is "deux"
    public void BTNTwoPress(View view) {
        gameBoardFill.setNumberPos(2);
        gameBoard.invalidate();
    }

    //setting value to 3 when button three is pressed that is "trois"
    public void BTNThreePress(View view) {
        gameBoardFill.setNumberPos(3);
        gameBoard.invalidate();
    }

    //setting value to 4 when button four is pressed that is "quatre"
    public void BTNFourPress(View view) {
        gameBoardFill.setNumberPos(4);
        gameBoard.invalidate();
    }

    //setting value to 5 when button five is pressed that is "cinq"
    public void BTNFivePress(View view) {
        gameBoardFill.setNumberPos(5);
        gameBoard.invalidate();
    }

    //setting value to 6 when button six is pressed that is "six"
    public void BTNSixPress(View view) {
        gameBoardFill.setNumberPos(6);
        gameBoard.invalidate();
    }

    //setting value to 7 when button seven is pressed that is "sept"
    public void BTNSevenPress(View view) {
        gameBoardFill.setNumberPos(7);
        gameBoard.invalidate();
    }

    //setting value to 8 when button eight is pressed that is "huit"
    public void BTNEightPress(View view) {
        gameBoardFill.setNumberPos(8);
        gameBoard.invalidate();
    }

    //setting value to 9 when button nine is pressed that is "neuf"
    public void BTNNinePress(View view) {
        gameBoardFill.setNumberPos(9);
        gameBoard.invalidate();
    }

    //calls erase number function in boardfill class that removes the value in the current cell
    public void eraseText() {
        gameBoardFill.eraseNumber();
    }

    //reset the game by removing all the input values by user
    public void reset() {
        for(ArrayList<Object> letter : gameBoardFill.getEmptyBoxIndex()) {

            int r = (int) letter.get(0);
            int c = (int) letter.get(1);
            if (gameBoardFill.getBoard()[r][c] != 0) {
                gameBoardFill.getBoard()[r][c] = 0;
                }
        }
    }

    //opens hint dialog box
    public void openDialog() {
        hintDialog hint = new hintDialog();
        hint.show(getSupportFragmentManager(), "hintDialog");
    }

    //setting dialog box
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

        //starts new game when new game button is pressed in the dialog box
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNewGame();

            }
        });

        //opens quit button dialog box when quit button is pressed
        quitgame.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                quit();

            }
        });

        //setting page is opened when setting page button is pressed
        settings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //do something more here
                settingPage();
            }
        });

    }

    //starts new game by recalling the Main Activity when starts new instance of game
    public void startNewGame(){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }

    //opens the setting page
    public void settingPage() {
        Intent intent = new Intent(this, setting_page.class);
        this.startActivity(intent);

    }

    //quit dialog box
    public void quit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // text shown on quit dialog box
        builder.setMessage("Are you sure you want to quit?")
                //if yes, it goes back to the first page
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        backToMain();
                    }
                })
                //if no it goes back to the dialog box
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

}