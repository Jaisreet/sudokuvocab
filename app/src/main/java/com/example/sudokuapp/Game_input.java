package com.example.sudokuapp;

import java.util.concurrent.ThreadLocalRandom;

public class Game_input {
    int[][] input;
    int[][] solution;
    int N = 9; // length and width of the grid
    int SQRT = 3; // length and width of the diagonal sub-grids
    int K =  60; // number of elements to be removed



    Game_input(){
        input = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        solution = new int[9][9];

        // 1. Fill the diagonal sub-matrices
        fillDiagonal(input);

        // 2. Fill the remaining cells using reccursion
        fillRemaining(0, SQRT);

        // 3. copy the grid to the solution board before we remove elements
        gridCopy(input, solution, N);

        // 4.
        removeKDigits(input, N, K);


    }

    // copy the solution to a separate solution board to check if the user has completed the game
    void gridCopy(int arr1[][], int arr2[][], int len){

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++) {
                arr2[i][j] = arr1[i][j];
            }
        }
    }


    // program to fill the diagonal sub matries first
    void fillDiagonal(int arr[][]) {

        for (int i = 0; i<N; i=i+SQRT)

            // for diagonal box, start coordinates->i==j
            fillBox(i, i);
    }

    // return a random number
    int randomNum(int num)
    {
        return (int) Math.floor((Math.random()*num+1));
    }

    // check if a specific number is used in a row and column
    boolean unUsedInBox(int rowStart, int colStart, int num)
    {
        for (int i = 0; i<SQRT; i++)
            for (int j = 0; j<SQRT; j++)
                if (input[rowStart+i][colStart+j]==num)
                    return false;

        return true;
    }

    // Fill the diagonal sub-matrices
    void fillBox(int row,int col)
    {
        int num;
        for (int i=0; i<SQRT; i++)
        {
            for (int j=0; j<SQRT; j++)
            {
                do
                {
                    num = randomNum(N);
                }
                while (!unUsedInBox(row, col, num));

                input[row+i][col+j] = num;
            }
        }
    }


    // recursively fill remaining cells in matrix
    boolean fillRemaining(int i, int j)
    {
        // if we are at the end of the col, go to begining of the next row
        if (j>=N && i<N-1)
        {
            i = i + 1;
            j = 0;
        }

        // if we have filled every cell, return true
        if (i>=N && j>=N)
            return true;


        if (i < SQRT)
        {
            if (j < SQRT)
                j = SQRT;
        }
        else if (i < N-SQRT)
        {
            if (j==(int)(i/SQRT)*SQRT)
                j =  j + SQRT;
        }
        else
        {
            if (j == N-SQRT)
            {
                i = i + 1;
                j = 0;
                if (i>=N)
                    return true;
            }
        }

        for (int num = 1; num<=N; num++)
        {
            if (CheckIfSafe(i, j, num))
            {
                input[i][j] = num;
                if (fillRemaining(i, j+1))
                    return true;

                input[i][j] = 0;
            }
        }
        return false;
    }


    // Check if safe to put in cell
    boolean CheckIfSafe(int i,int j,int num)
    {
        return (unUsedInRow(i, num) &&
                unUsedInCol(j, num) &&
                unUsedInBox(i-i%SQRT, j-j%SQRT, num));
    }

    // check in the row for existence
    boolean unUsedInRow(int i,int num)
    {
        for (int j = 0; j<N; j++)
            if (input[i][j] == num)
                return false;
        return true;
    }

    // check in the row for existence
    boolean unUsedInCol(int j,int num)
    {
        for (int i = 0; i<N; i++)
            if (input[i][j] == num)
                return false;
        return true;
    }


    // Remove the K no. of digits from board
    public void removeKDigits(int arr[][], int len, int count)
    {
        while (count != 0)
        {
            int i = (int) (Math.random() * 9 );
            int j = (int) (Math.random() * 9 );

            // System.out.println(i+" "+j);
            if (arr[i][j] != 0)
            {
                count--;
                arr[i][j] = 0;
            }
        }
    }

    public int[][] getInput(){
        return this.input;
    }
}
