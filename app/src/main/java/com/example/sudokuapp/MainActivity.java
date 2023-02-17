package com.example.sudokuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private SudokuBoard gameBoard;
    private boardFill gameBoardFill;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = findViewById(R.id.sudokuBoard);
        gameBoardFill = gameBoard.getBoardFill();
        gameBoardFill.getEmptyBoxIndexs();
    }

    public void BTNOnePress(View view){
        gameBoardFill.setNumberPos(1);
        gameBoard.invalidate();
    }
    public void BTNTwoPress(View view){
        gameBoardFill.setNumberPos(2);
        gameBoard.invalidate();
    }
    public void BTNThreePress(View view){
        gameBoardFill.setNumberPos(3);
        gameBoard.invalidate();
    }
    public void BTNFourPress(View view){
        gameBoardFill.setNumberPos(4);
        gameBoard.invalidate();
    }
    public void BTNFivePress(View view){
        gameBoardFill.setNumberPos(5);
        gameBoard.invalidate();
    }
    public void BTNSixPress(View view){
        gameBoardFill.setNumberPos(6);
        gameBoard.invalidate();
    }
    public void BTNSevenPress(View view){
        gameBoardFill.setNumberPos(7);
        gameBoard.invalidate();
    }

    public void BTNEightPress(View view){
        gameBoardFill.setNumberPos(8);
        gameBoard.invalidate();
    }
    public void BTNNinePress(View view){
        gameBoardFill.setNumberPos(9);
        gameBoard.invalidate();
    }
}