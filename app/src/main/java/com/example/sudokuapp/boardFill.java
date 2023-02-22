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
        selected_column = -1;
        selected_row = -1;
        board = new int[9][9];
        flag = new int[9][9];
        for(int r=0; r<9; r++) {
            for(int c=0;c<9;c++) {
                board[r][c] = input.getInput()[r][c];
                if(board[r][c] != 0){
                    flag[r][c] = 1;
                }
                else{
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
