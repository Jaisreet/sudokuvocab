package com.example.sudokuapp;

import static org.junit.Assert.*;
import org.junit.Test;
import com.example.sudokuapp.board_Generation;

import java.util.HashSet;
import java.util.Set;

import Model.Board_Generation;


public class game_inputTest {
    Board_Generation board_Generation = new Board_Generation();

    @Test
    public void gridCopyTest() {
        int[][] arr1 = new int[9][9];
        int[][] arr2 = new int[9][9];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                arr1[i][j] = i+j+1;
            }
        }
        Board_Generation.gridCopy(arr1, arr2, 9);
        //Check if arr2 is equal to arr1
        for(int i = 0; i <9; i++){
            for(int j = 0; j < 9; j++){
                assertEquals(arr1[i][j], arr2[i][j]);
            }
        }
    }

    @Test
    public void getSolutionTest() {
        assertArrayEquals(board_Generation.solution, board_Generation.getSolution());
    }

    @Test
    public void fillDiagonalTest(){
        int[][] arr = new int[9][9];
        board_Generation.fillDiagonal(arr);

        // Check that each diagonal box has distinct numbers
        for (int i = 0; i < 9; i += 3) {
            int[] boxValues = new int[9];
            int k = 0;
            for (int j = 0; j < 3; j++) {
                for (int l = 0; l < 3; l++) {
                    int value = arr[i+j][i+l];
                    assertTrue(value >= 1 && value <= 9);
                    assertFalse(boxValues[value-1] == value);
                    boxValues[k++] = value;
                }
            }
        }
    }

    @Test
    public void randomNumTest(){
        int[] RandomResult = {0,0,0,0,0};
        for(int i = 0; i < 5; i++){
            RandomResult[i] = board_Generation.randomNum(1);
        }
        for(int i = 1; i < 5; i++){
            assertTrue(RandomResult[0] != RandomResult[i]);
        }

    }

    @Test
    public void unUsedInBoxTest(){
        int[][] arr = {{ 1, 2, 3, 4, 5, 6, 7, 8, 9 },
                { 2, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 3, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 4, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 5, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 6, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 7, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 8, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 9, 0, 0, 0, 0, 0, 0, 0, 0 }};

        int rowStart = 1;
        int colStart = 1;
        int num = 1;

        // Call unUsedInBox function
        boolean result = board_Generation.unUsedInBox(rowStart, colStart, num);

        // Check that the result is true
        assertTrue(result);

        // Set one of the values in the box to the number we're checking for
        arr[rowStart+1][colStart+1] = num;

        // Call unUsedInBox function again
        result = board_Generation.unUsedInBox(rowStart, colStart, num);

        // Check that the result is false
        assertFalse(result);
    }

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
        board_Generation.fillBox(0,0);

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

        arr[0][1] = 1;
        arr[3][3] = 5;
        arr[7][8] = 9;

        assertTrue(board_Generation.fillRemaining(0, 0));
        int sumOfFirstRow = 0;
        for(int i = 0; i < 9; i++){
            sumOfFirstRow += arr[0][i];
        }
        assertEquals(45, sumOfFirstRow); // Check the sum of the first row
    }
    @Test
    public void CheckIfSafeTest(){
        int[][] arr = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        arr[0][1] = 1;
        arr[3][3] = 5;
        arr[7][8] = 9;
        // Check for a safe value
        assertTrue(board_Generation.CheckIfSafe(2,2,3));
        // Check for an unsafe value in the same row
        assertFalse(board_Generation.CheckIfSafe(2,3,1));
        // Check for an unsafe value in the same column
        assertFalse(board_Generation.CheckIfSafe(1, 2, 2));
        // Check for an unsafe value in the same box
        assertFalse(board_Generation.CheckIfSafe(4, 4, 5));
    }

    @Test
    public void unUsedInRowTest() {
        int[][] input = {{0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};

        assertTrue(board_Generation.unUsedInRow(0, 2));
        assertFalse(board_Generation.unUsedInRow(1,0));
    }

    @Test
    public void unUsedInColTest() {
        int[][] input = {{0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};

        assertTrue(board_Generation.unUsedInCol(0, 2));
        assertFalse(board_Generation.unUsedInCol(1,5));
    }

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
        board_Generation.removeKDigits(arr, len, count);
        int zeroCount = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(arr[i][j] == 0)
                    zeroCount++;
            }
        }

        assertEquals(zeroCount, numberOfZero + count);
    }

    @Test
    public void getInputTest(){
        assertArrayEquals(board_Generation.input, board_Generation.getInput());
    }
}
