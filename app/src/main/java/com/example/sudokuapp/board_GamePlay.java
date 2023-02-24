package com.example.sudokuapp;

import android.content.Context;

import java.util.ArrayList;

public class board_GamePlay {

    int[][] board;
    Board_Generation input = new Board_Generation();
    ArrayList<ArrayList<Object>> emptyBoxIndex;
    int selected_row;
    int selected_column;
    int [][] flag;
    private Context boardFill;

    public board_GamePlay(){
        // when the user has not selected a square yet, set selected col and row to -1
        selected_column = -1;
        selected_row = -1;
        board = new int[9][9];  // main working board
        flag = new int[9][9];   // flag to keep track of pre-filled squares

        // algorithm to move generated board set up into main board

        // for every row
        for(int r=0; r<9; r++) {
            // for every colomn
            for(int c=0;c<9;c++) {
                board[r][c] = input.getArr_gameBoard()[r][c];

                // if the board at that spot is not empty, set the flag to one
                if(board[r][c] != 0){
                    flag[r][c] = 1;
                }
                else{
                    // if this square is empty, set the flag to zero
                    flag[r][c]=0;
                }
            }
        }

        emptyBoxIndex = new ArrayList<>();
    }

    //getting indexes of boxes with 0 (empty boxes)
    public void getEmptyBoxIndexs(){
        for(int r=0; r<9; r++){
            for(int c= 0; c<9; c++){
                if(this.board[r][c]==0){
                    this.emptyBoxIndex.add(new ArrayList<>());
                    this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(r);
                    this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(c);
                }
            }
        }
    }

    public void setNumberPos(int num){
        if(this.selected_row != -1 && this.selected_column != -1){
            if(this.board[this.selected_row-1][this.selected_column-1]== 0 && this.flag[this.selected_row-1][this.selected_column-1] == 0){
                    this.board[this.selected_row - 1][this.selected_column - 1] = num;

            }
        }

    }

    public void eraseNumber() {
        if(this.selected_row != -1 && this.selected_column != -1){
            if(this.board[this.selected_row-1][this.selected_column-1]!= 0 && this.flag[this.selected_row-1][this.selected_column-1] == 0){
                this.board[this.selected_row-1][this.selected_column-1] = 0;
            }
        }
    }

    public int getNum(){
        return this.board[this.selected_row-1][this.selected_column-1];
    }

    public int[][] getBoard(){
        return this.board;
    }

    public ArrayList<ArrayList<Object>> getEmptyBoxIndex() {
        return this.emptyBoxIndex;
    }

    public int getSelected_row(){
        return selected_row;
    }

    public int getSelected_column(){
        return selected_column;
    }

    public void setSelected_row(int r){
        selected_row = r;
    }

    public void setSelected_column(int c){
        selected_column = c;
    }

}
