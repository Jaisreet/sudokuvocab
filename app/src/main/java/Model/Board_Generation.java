package Model;

import android.content.Context;
import android.widget.Toast;

public class Board_Generation {
    private Context Board_Generation;
    int[][] arr_gameBoard;
    int[][] arr_solutionBoard;
    int N = 6; // length and width of the grid
    int SQRT = (int) Math.sqrt(N); // length and width of the diagonal sub-grids
    int K =  20; // number of elements to be removed



    public Board_Generation(){
        /*
        arr_gameBoard = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        */
        arr_gameBoard = new int[N][N];
        arr_solutionBoard = new int[N][N];

        // 1. Fill the diagonal sub-matrices
        fillDiagonal(arr_gameBoard);

        // 2. Fill the remaining cells using recursion
        fillRemaining(arr_gameBoard,0, SQRT);

        // 3. copy the grid to the solution board before we remove elements
        gridCopy(arr_gameBoard, arr_solutionBoard, N);

        // 4.
        removeKDigits(arr_gameBoard, N, K);

        // print board
        //printBoard(arr_gameBoard);
        //printBoard(arr_solutionBoard);

    }

    // functions to return important grid nums
    int return_n() {return N;}
    int return_sqrt() {return SQRT;}
    int return_k() {return K;}



    // print board to console

    void printBoard(int arr[][])
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print("|" + arr[i][j] + "|" );
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }



    // copy the solution to a separate solution board to check if the user has completed the game
    public void gridCopy(int arr1[][], int arr2[][], int len){

        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++) {
                arr2[i][j] = arr1[i][j];
            }
        }
    }

    public int[][] getArr_solutionBoard(){
        return this.arr_solutionBoard;
    }


    // program to fill the diagonal sub matries first
    public void fillDiagonal(int arr[][]) {

        for (int i = 0; i<N; i=i+SQRT)

            // for diagonal box, start coordinates->i==j
            fillBox(arr,i, i);
    }

    // return a random number
    public int randomNum(int num)
    {
        return (int) Math.floor((Math.random()*num+1));
    }

    // check if a specific number is used in a row and column
    public boolean unUsedInBox(int arr[][],int rowStart, int colStart, int num)
    {
        for (int i = 0; i<SQRT; i++)
            for (int j = 0; j<SQRT; j++)
                if (arr[rowStart+i][colStart+j]==num)
                    return false;
        return true;

    }

    // Fill the diagonal sub-matrices
    public void fillBox(int arr[][], int row, int col)
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
                while (!unUsedInBox(arr,row, col, num));

                arr[row+i][col+j] = num;
            }
        }
    }


    // recursively fill remaining cells in matrix
    public boolean fillRemaining(int arr[][], int i, int j)
    {
        // if we are at the end of the col, go to beginning of the next row
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
            if (CheckIfSafe(arr,i, j, num))
            {
                arr[i][j] = num;
                if (fillRemaining(arr,i, j+1))
                    return true;

                arr[i][j] = 0;
            }
        }
        return false;
    }


    // Check if safe to put in cell
    public boolean CheckIfSafe(int arr[][], int i, int j, int num)
    {
        return (unUsedInRow(arr, i, num) &&
                unUsedInCol(arr, j, num) &&
                unUsedInBox(arr,i-i%SQRT, j-j%SQRT, num));
    }

    // check in the row for existence
    public boolean unUsedInRow(int arr[][], int i, int num)
    {
        for (int j = 0; j<N; j++)
            if (arr[i][j] == num)
                return false;
        return true;
    }

    // check in the row for existence
    public boolean unUsedInCol(int arr[][], int j, int num)
    {
        for (int i = 0; i<N; i++)
            if (arr[i][j] == num)
                return false;
        return true;
    }


    // Remove the K no. of digits from board
    public void removeKDigits(int arr[][], int len, int count)
    {
        while (count != 0)
        {
            int i = (int) (Math.random() * N );
            int j = (int) (Math.random() * N );

            // System.out.println(i+" "+j);
            if (arr[i][j] != 0)
            {
                count--;
                arr[i][j] = 0;
            }
        }
    }

    public int[][] getArr_gameBoard(){
        return this.arr_gameBoard;
    }

}
