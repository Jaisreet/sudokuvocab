package com.example.sudokuapp;

import static org.junit.Assert.*;
import org.junit.Test;
import com.example.sudokuapp.Game_input;


public class game_inputTest {
    Game_input gameInput = new Game_input();

    @Test
    public void gridCopyTest() {

    }

    @Test
    public void getSolutionTest() {

    }

    @Test
    public void fillDiagonalTest(){

    }

    @Test
    public void randomNumTest(){

    }

    @Test
    public void unUsedInBoxTest(){

    }

    @Test
    public void fillBoxTest(){

    }

    @Test
    public void fillRemainingTest(){}

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
        assertTrue(gameInput.CheckIfSafe(2,2,3));
        // Check for an unsafe value in the same row
        assertFalse(gameInput.CheckIfSafe(2,3,1));
        // Check for an unsafe value in the same column
        assertFalse(gameInput.CheckIfSafe(1, 2, 2));
        // Check for an unsafe value in the same box
        assertFalse(gameInput.CheckIfSafe(4, 4, 5));
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

        assertTrue(gameInput.unUsedInRow(0, 2));
        assertFalse(gameInput.unUsedInRow(1,0));
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

        assertTrue(gameInput.unUsedInCol(0, 2));
        assertFalse(gameInput.unUsedInCol(1,5));
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
        gameInput.removeKDigits(arr, len, count);
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
        assertArrayEquals(gameInput.input, gameInput.getInput());
    }
}
