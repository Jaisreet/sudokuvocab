package com.example.sudokuapp;

public class Game_input {
    int[][] input;

    Game_input(){
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
    }

    public int[][] getInput(){
        return this.input;
    }
}
