package com.example.sudokuapp;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import Model.Board_Generation;


public class Board_GenerationTest {
    Board_Generation newBoard = new Board_Generation();

    // test 1
    @Test
    public void gridCopyTest() {
        int[][] arr1 = new int[9][9];
        int[][] arr2 = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                arr1[i][j] = i+j+1;
            }
        }

        newBoard.gridCopy(arr1, arr2, 9);
        //Check if arr2 is equal to arr1
        for(int i = 0; i <9; i++){
            for(int j = 0; j < 9; j++){
                assertEquals(arr1[i][j], arr2[i][j]);
            }
        }
    }

    // test 2
    @Test
    public void getSolutionTest() {
        int arr[][] = newBoard.getArr_solutionBoard();

        // check every row and col to make sure their sum equals the same thing
        int rowSum = 0;
        int colSum = 0;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                rowSum+= arr[i][j];
                colSum+= arr[j][i];
            }
            assertTrue(rowSum == colSum);
        }
    }


    // test 3
    @Test
    public void fillDiagonalTest(){

        int testArr[][] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        newBoard.fillDiagonal(testArr);

        for (int i = 0; i<9; i=i+3)
        {
            assertTrue(testArr[i][i] != 0);
        }
    }



    // test 4
    @Test
    public void randomNumTest(){
        int RandomResult1 = newBoard.randomNum(1);
        int RandomResult2 = newBoard.randomNum(2);
        int RandomResult3 = newBoard.randomNum(3);
        int RandomResult4 = newBoard.randomNum(4);
        int RandomResult5 = newBoard.randomNum(5);
        assertTrue(RandomResult1 != RandomResult2 ||
                RandomResult2 !=RandomResult3 ||
                RandomResult3 !=RandomResult4 ||
                RandomResult4!=RandomResult5);
    }

    // test 5
    @Test
    public void unUsedInBoxTest(){
        int testArr[][] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        int rowStart = 4;
        int colStart = 4;
        int num = 1;

        // Call unUsedInBox function
        System.out.print("Test 1");
        boolean result = newBoard.unUsedInBox(testArr,rowStart, colStart, num);

        // Check that the result is true
        assertTrue(result);

        // Set one of the values in the box to the number we're checking for
        testArr[rowStart][colStart] = num;

        // Call unUsedInBox function again
        result = newBoard.unUsedInBox(testArr,rowStart, colStart, num);

        // Check that the result is false
        assertFalse(result);
    }


    // Test 6
    //@Ignore
    @Test
    public void fillBoxTest(){
        int arr[][] = {{ 3, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
        newBoard.fillBox(arr,0,0);

        // Check that all values in the box are between 1 and 9
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(arr[i][j] >= 1 && arr[i][j] <= 9);
            }
        }

        // Check that all values in the box are unique
        Set<Integer> uniqueValues = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                uniqueValues.add(arr[i][j]);
            }
        }
        assertEquals(9, uniqueValues.size());
    }



    // Test 7
    @Test
    public void fillRemainingTest() {
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};


        // check diagonals are zero
        newBoard.fillRemaining(arr,0, 3);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
               assertTrue(arr[i][j] == 0);
            }
        }
        boolean isNotEmpty = false;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 3; j < 9; j++)
            {
                if (arr[i][j] != 0)
                {
                    isNotEmpty = true;
                }
            }
        }
        assertTrue(isNotEmpty);
    }

    // test 8
    @Test
    public void CheckIfSafeTest(){
        int[][] arr = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        arr[0][0] = 1;
        arr[3][3] = 2;
        arr[7][8] = 9;
        // Check for an unsafe value in the same row
        assertFalse(newBoard.CheckIfSafe(arr,3,3,2));
        // Check for an unsafe value in the same column
        //assertFalse(newBoard.CheckIfSafe(arr,1, 2, 2));
        // Check for an unsafe value in the same box
        //assertFalse(newBoard.CheckIfSafe(4, 4, 5));
    }

    // test 10
    @Test
    public void unUsedInRowTest1() {
        int[][] input = {{0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};

        //assertTrue(newBoard.unUsedInRow(0, 2));
        assertFalse(newBoard.unUsedInRow(input,1,0));
    }
    @Test
    public void unUsedInRowTest2() {
        int[][] input = {
                {0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};

        assertTrue(newBoard.unUsedInRow(input,0, 2));
        //assertFalse(newBoard.unUsedInRow(1,0));
    }

    // test 11
    @Test
    public void unUsedInColTest1() {
        int[][] input = {{0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};

        assertTrue(newBoard.unUsedInCol(input,0, 2));
        //assertFalse(newBoard.unUsedInCol(1,5));
    }
    @Test
    public void unUsedInColTest2() {
        int[][] input = {{0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};

        //assertTrue(newBoard.unUsedInCol(0, 2));
        assertFalse(newBoard.unUsedInCol(input,1,5));
    }


    // Test 12
    @Test
    public void removeKDigitsTest(){
        int[][] arr = {{0, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};
        int numberOfZero = 6;   // In arr, there are 6 zeros
        int len = 9;
        int count = 9;
        newBoard.removeKDigits(arr, len, count);
        int zeroCount = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(arr[i][j] == 0)
                    zeroCount++;
            }
        }

        assertEquals(zeroCount, numberOfZero + count);
    }


    // Test 13
    @Test
    public void getInputTest(){
        assertArrayEquals(newBoard.getArr_gameBoard(), newBoard.getArr_gameBoard());
    }


}
