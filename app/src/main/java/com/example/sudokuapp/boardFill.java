package com.example.sudokuapp;

import static java.lang.System.*;

import java.util.ArrayList;

public class boardFill {


    int[][] board;

    private Game_input input = new Game_input();
    ArrayList<ArrayList<Object>> emptyBoxIndex;
    int selected_row;
    int selected_column;
    int [][] flag;

    boardFill(){
        // when the user has not selected a square yet, set selected col and row to -1
        selected_column = -1;
        selected_row = -1;
<<<<<<< HEAD
        board = new int[9][9];
        flag = new int[9][9];
=======


        input = new int[][]{
                {0, 0, 1, 7, 0, 0, 5, 0, 9},
                {5,7,3, 0, 2, 4, 1, 0, 6},
                {8, 0, 0, 5, 0, 1, 0, 0, 2},
                {7, 0, 0, 2, 9, 5, 0, 1, 8},
                {0, 0, 9, 4, 0, 0, 3, 0, 5},
                {6, 5, 2, 8, 0, 0, 0, 0,7},
                {4, 6, 5, 0, 8, 0, 0, 7, 1},
                {0, 0, 0, 1, 5, 9, 0, 0, 4},
                {9, 0, 8, 0, 0, 7, 0, 5, 3}};

        board = new int[9][9];  // main working board
        flag = new int[9][9];   // flag to keep track of pre-filled squares

        // algorithm to move generated board set up into main board

        // for every row
>>>>>>> 751a4004f824cd63a77063cdc541de02629dd7c5
        for(int r=0; r<9; r++) {
            // for every colomn
            for(int c=0;c<9;c++) {
<<<<<<< HEAD
                board[r][c] = input.getInput()[r][c];
=======

                // copy the value from input to main board
                board[r][c] = input[r][c];

                // if the board at that spot is not empty, set the flag to one
>>>>>>> 751a4004f824cd63a77063cdc541de02629dd7c5
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
