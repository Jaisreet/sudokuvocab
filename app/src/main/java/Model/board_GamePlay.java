package Model;

import android.content.Context;

import java.util.ArrayList;

public class board_GamePlay {

    int[][] board;
    Board_Generation input = new Board_Generation();
    public ArrayList<ArrayList<Object>> emptyBoxIndex;
    int selected_row;
    public int selected_column;
    int [][] flag;
    int[][] solutionBoard;
    private Context boardFill;

    public board_GamePlay(){
        // when the user has not selected a square yet, set selected col and row to -1
        selected_column = -1;
        selected_row = -1;
        board = new int[9][9];  // main working board
        flag = new int[9][9];   // flag to keep track of pre-filled squares
        solutionBoard = new int[9][9];
        // algorithm to move generated board set up into main board

        // for every row
        for(int r=0; r<9; r++) {
            // for every colomn
            for(int c=0;c<9;c++) {
                board[r][c] = input.getArr_gameBoard()[r][c];
                solutionBoard[r][c] = input.getArr_solutionBoard()[r][c];
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

    //set the value of selected column to given value (num)
    public void setNumberPos(int num){
        if(this.selected_row != -1 && this.selected_column != -1){
            if(this.board[this.selected_row-1][this.selected_column-1]== 0 && this.flag[this.selected_row-1][this.selected_column-1] == 0){
                    this.board[this.selected_row - 1][this.selected_column - 1] = num;

            }
        }

    }
    //set the value of selected column to 0 which is equal to erase
    public void eraseNumber() {
        if(this.selected_row != -1 && this.selected_column != -1){
            if(this.board[this.selected_row-1][this.selected_column-1]!= 0 && this.flag[this.selected_row-1][this.selected_column-1] == 0){
                this.board[this.selected_row-1][this.selected_column-1] = 0;
            }
        }
    }
    //return value of selected cell
    public int getNum(){
        return this.board[this.selected_row-1][this.selected_column-1];
    }

    //return the game board
    public int[][] getBoard(){
        return this.board;
    }

    //return the solution board
    public int[][] getSolutionBoard(){return this.solutionBoard;}

   //return the array indexes of the board which has value 0, that is equivalent to empty box
    public ArrayList<ArrayList<Object>> getEmptyBoxIndex() {
        return this.emptyBoxIndex;
    }

    //return the selected row
    public int getSelected_row(){
        return selected_row;
    }

    //return the selected column
    public int getSelected_column(){
        return selected_column;
    }

    //set the row to given value r
    public void setSelected_row(int r){
        selected_row = r;
    }

    //set the column to given value c
    public void setSelected_column(int c){
        selected_column = c;
    }


    public int getCurrentGame(){
        return selected_row;
    }

    public void setCurrentState(int[][] state) {
        this.board = state;
    }
}
