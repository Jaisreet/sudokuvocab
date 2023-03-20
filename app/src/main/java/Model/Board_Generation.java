package Model;

import android.content.Context;
import android.widget.Toast;

import java.util.concurrent.ThreadLocalRandom;

public class Board_Generation {
    private Context Board_Generation;
    int[][] arr_gameBoard;
    int[][] arr_solutionBoard;

    int N ; // length and width of the grid
    int SQRT; // length and width of the diagonal sub-grids
    int removeNum;  // number of elements to be removed



    public Board_Generation(int size, int difficulty ){

        N = size;
        if(N == 12){
            SQRT = 2;
        }else if (N == 4) {
            SQRT = 2;
        } else {
            SQRT = (int) Math.sqrt(N);
        }
        arr_gameBoard = new int[N][N];
        arr_solutionBoard = new int[N][N];

        //1. Fill the diagonal sub-matrices
        fillDiagonal(arr_gameBoard);

        // 2. Fill the remaining cells using recursion
        if (N == 9) {

            fillRemaining(arr_gameBoard, 0, SQRT); }
        else {
            fillRemainingDiffGridSizes(arr_gameBoard);
        }
        // 3. copy the grid to the solution board before we remove elements
        gridCopy(arr_gameBoard, arr_solutionBoard, N);

        if(difficulty == 1){
            if( N==9) {
                removeNum = 10;
            } else if (N ==12) {
                removeNum = 40;
            } else if (N == 6) {
                removeNum = 3;
            }else{
                removeNum = 2;
            }
        } else if (difficulty ==2) {
            if(N==9) {
                removeNum = 30;
            } else if (N ==12) {
                removeNum = 60;
            } else if (N == 6) {
                removeNum = 5;
            }else{
                removeNum = 4;
            }
        }else{
            if(N==9) {
                removeNum = 65;
            } else if (N ==12) {
                removeNum = 100;
            } else if (N == 6) {
                removeNum = 7;
            }else{
                removeNum = 6;
            }
        }
        // 4.
        removeKDigits(arr_gameBoard, N, removeNum);


        // print board
        //printBoard(arr_gameBoard);
        //printBoard(arr_solutionBoard);

    }

    // functions to return important grid nums
    int return_n() {return N;}
    int return_sqrt() {return SQRT;}
    int return_k() {return removeNum;}



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




    public boolean fillRemainingDiffGridSizes(int arr[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
               if (arr[i][j] == 0)
               {
                   for (int num = 1; num<=N; num++)
                   {
                       if (CheckIfSafe(arr,i, j, num)) {
                           arr[i][j] = num;
                       } else {
                           arr[i][j] = (int)(Math.random() * N);
                       }
                   }
               }
            }
        }
        return true;
    }

    // Check if safe to put in cell
    public boolean CheckIfSafe(int arr[][], int i, int j, int num)
    {
        return (arr[i][j] == 0 &&
                unUsedInRow(arr, i, num) &&
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
        printBoard(arr_gameBoard);
        while (count != 0)
        {
            int i = (int) (ThreadLocalRandom.current().nextInt(0, len));
            int j = (int) (ThreadLocalRandom.current().nextInt(0, len));

            System.out.println("i is "+ i +" ,j is" + j + " ,and count is "+count+" we're removing "+ arr[i][j]);
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
