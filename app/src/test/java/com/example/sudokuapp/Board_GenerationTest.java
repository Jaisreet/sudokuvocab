package com.example.sudokuapp;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import Model.Board_Generation;


public class Board_GenerationTest {
    Board_Generation newBoard4x4 = new Board_Generation(4, 20);
    Board_Generation newBoard6x6 = new Board_Generation(6, 20);
    Board_Generation newBoard9x9 = new Board_Generation(9, 20);
    Board_Generation newBoard12x12 = new Board_Generation(12, 20);

    // test 1
    @Test
    public void gridCopyTest() {

        int[][] arr1a = new int[4][4];
        int[][] arr1b = new int[4][4];

        int[][] arr2a = new int[6][6];
        int[][] arr2b = new int[6][6];

        int[][] arr3a = new int[9][9];
        int[][] arr3b = new int[9][9];

        int[][] arr4a = new int[12][12];
        int[][] arr4b = new int[12][12];

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                arr1a[i][j] = i+j+1;
            }
        }

        newBoard4x4.gridCopy(arr1a, arr1b, 4);
        //Check if arr1b is equal to arr1a
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                assertEquals(arr1a[i][j], arr1b[i][j]);
            }
        }

        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                arr2a[i][j] = i+j+1;
            }
        }

        newBoard6x6.gridCopy(arr2a, arr2b, 6);
        //Check if arr2b is equal to arr2a
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                assertEquals(arr2a[i][j], arr2b[i][j]);
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                arr3a[i][j] = i+j+1;
            }
        }

        newBoard9x9.gridCopy(arr3a, arr3b, 9);
        //Check if arr3b is equal to arr3a
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                assertEquals(arr3a[i][j], arr3b[i][j]);
            }
        }

        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                arr4a[i][j] = i+j+1;
            }
        }

        newBoard9x9.gridCopy(arr4a, arr4b, 12);
        //Check if arr3b is equal to arr3a
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                assertEquals(arr4a[i][j], arr4b[i][j]);
            }
        }
    }

    // test 2
    @Test
    public void getSolutionTest() {
        int arr1[][] = newBoard4x4.getArr_solutionBoard();
        int arr2[][] = newBoard6x6.getArr_solutionBoard();
        int arr3[][] = newBoard9x9.getArr_solutionBoard();
        int arr4[][] = newBoard12x12.getArr_solutionBoard();


        //For 4x4 grid: check every row and col to make sure their sum equals the same thing
        /**for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
         assertTrue(arr1[i][j] != 0 &&  arr1[j][i] != 0);
         }
         }*/

        // For 6x6 grid: check every row and col to make sure their sum equals the same thing
        /**for (int i = 0; i < 6; i++){
         for (int j = 0; j < 6; j++) {
         System.out.print("|" + arr2[i][j] + "|" );
         //assertTrue(arr2[i][j] != 0 && arr2[j][i] != 0);
         }System.out.print("\n");
         }System.out.print("\n");*/

        //For 9x9 grid:
        // check every row and col to make sure their sum equals the same thing
        int rowSum9x9 = 0;
        int colSum9x9 = 0;
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++) {
                rowSum9x9+= arr3[i][j];
                colSum9x9+= arr3[j][i];
            }
            assertTrue(rowSum9x9 == colSum9x9);
        }

        //For 12x12: check every row and col to make sure their sum equals the same thing
        /**int rowSum12x12 = 0;
         int colSum12x12 = 0;
         for (int i = 0; i < 9; i++){
         for (int j = 0; j < 9; j++) {
         rowSum12x12 += arr4[i][j];
         colSum12x12 += arr4[j][i];
         }
         assertTrue(rowSum12x12 == colSum12x12);
         }*/
    }


    // test 3
    @Test
    public void fillDiagonalTest(){
        //For 4x4
        int testArr1[][] = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        newBoard4x4.fillDiagonal(testArr1);

        for (int i = 0; i < 4; i=i+3)
        {
            assertTrue(testArr1[i][i] != 0);
        }

        //For 6x6:
        int testArr2[][] = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};
        newBoard6x6.fillDiagonal(testArr2);

        for (int i = 0; i<6; i=i+3)
        {
            assertTrue(testArr2[i][i] != 0);
        }

        //For 9x9
        int testArr3[][] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};
        newBoard9x9.fillDiagonal(testArr3);

        for (int i = 0; i<9; i=i+3)
        {
            assertTrue(testArr3[i][i] != 0);
        }

        //For 12x12
        int testArr4[][] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        newBoard12x12.fillDiagonal(testArr4);

        for (int i = 0; i<12; i=i+4)
        {
            assertTrue(testArr4[i][i] != 0);
        }
    }



    // test 4
    @Test
    public void randomNumTest(){
        //For 4x4
        int RandomResult1a = newBoard4x4.randomNum(1);
        int RandomResult2a = newBoard4x4.randomNum(2);
        int RandomResult3a = newBoard4x4.randomNum(3);
        int RandomResult4a = newBoard4x4.randomNum(4);
        int RandomResult5a = newBoard4x4.randomNum(5);
        assertTrue(RandomResult1a != RandomResult2a ||
                RandomResult2a !=RandomResult3a ||
                RandomResult3a !=RandomResult4a ||
                RandomResult4a!=RandomResult5a);

        //For 6x6
        int RandomResult1b = newBoard6x6.randomNum(1);
        int RandomResult2b = newBoard6x6.randomNum(2);
        int RandomResult3b = newBoard6x6.randomNum(3);
        int RandomResult4b = newBoard6x6.randomNum(4);
        int RandomResult5b = newBoard6x6.randomNum(5);
        assertTrue(RandomResult1b != RandomResult2b ||
                RandomResult2b !=RandomResult3b ||
                RandomResult3b !=RandomResult4b ||
                RandomResult4b!=RandomResult5b);

        //For 9x9
        int RandomResult1c = newBoard9x9.randomNum(1);
        int RandomResult2c = newBoard9x9.randomNum(2);
        int RandomResult3c = newBoard9x9.randomNum(3);
        int RandomResult4c = newBoard9x9.randomNum(4);
        int RandomResult5c = newBoard9x9.randomNum(5);
        assertTrue(RandomResult1c != RandomResult2c ||
                RandomResult2c != RandomResult3c ||
                RandomResult3c !=RandomResult4c ||
                RandomResult4c !=RandomResult5c);

        //For 12x12
        int RandomResult1d = newBoard12x12.randomNum(1);
        int RandomResult2d = newBoard12x12.randomNum(2);
        int RandomResult3d = newBoard12x12.randomNum(3);
        int RandomResult4d = newBoard12x12.randomNum(4);
        int RandomResult5d = newBoard12x12.randomNum(5);
        assertTrue(RandomResult1d != RandomResult2d ||
                RandomResult2d != RandomResult3d ||
                RandomResult3d !=RandomResult4d ||
                RandomResult4d !=RandomResult5d);
    }

    // test 5
    @Test
    public void unUsedInBoxTest(){
        //For 4x4
        int testArr1[][] = new int[][]{
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        int rowStart1 = 2;
        int colStart1 = 2;
        int num1 = 1;

        // Call unUsedInBox function
        boolean result1 = newBoard4x4.unUsedInBox(testArr1,rowStart1, colStart1, num1);

        // Check that the result is true
        assertTrue(result1);

        // Set one of the values in the box to the number we're checking for
        testArr1[rowStart1][colStart1] = num1;

        // Call unUsedInBox function again
        result1 = newBoard4x4.unUsedInBox(testArr1,rowStart1, colStart1, num1);

        // Check that the result is false
        assertFalse(result1);

        //For 6x6
        int testArr2[][] = new int[][]{
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};

        int rowStart2 = 4;
        int colStart2 = 4;
        int num2 = 1;

        // Call unUsedInBox function
        boolean result2 = newBoard4x4.unUsedInBox(testArr2,rowStart2, colStart2, num2);

        // Check that the result is true
        assertTrue(result2);

        // Set one of the values in the box to the number we're checking for
        testArr2[rowStart2][colStart2] = num2;

        // Call unUsedInBox function again
        result2 = newBoard4x4.unUsedInBox(testArr2,rowStart2, colStart2, num2);

        // Check that the result is false
        assertFalse(result2);

        //For 9x9
        int testArr3[][] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        int rowStart3 = 4;
        int colStart3 = 4;
        int num3 = 1;

        // Call unUsedInBox function
        boolean result3 = newBoard9x9.unUsedInBox(testArr3,rowStart3, colStart3, num3);

        // Check that the result is true
        assertTrue(result3);

        // Set one of the values in the box to the number we're checking for
        testArr3[rowStart3][colStart3] = num3;

        // Call unUsedInBox function again
        result3 = newBoard9x9.unUsedInBox(testArr3,rowStart3, colStart3, num3);

        // Check that the result is false
        assertFalse(result3);

        //For 12x12
        int testArr4[][] = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        int rowStart4 = 5;
        int colStart4 = 5;
        int num4 = 1;

        // Call unUsedInBox function
        boolean result4 = newBoard12x12.unUsedInBox(testArr4,rowStart4, colStart4, num4);

        // Check that the result is true
        assertTrue(result4);

        // Set one of the values in the box to the number we're checking for
        testArr4[rowStart4][colStart4] = num4;

        // Call unUsedInBox function again
        result4 = newBoard12x12.unUsedInBox(testArr4,rowStart4, colStart4, num4);

        // Check that the result is false
        assertFalse(result4);
    }


    // Test 6
    //@Ignore
    @Test
    public void fillBoxTest(){
        //For 4x4
        int arr1[][] = {{3, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};
        newBoard4x4.fillBox(arr1,0,0);

        // Check that all values in the box are between 1 and 4
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                assertTrue(arr1[i][j] >= 1 && arr1[i][j] <= 4);
            }
        }

        // Check that all values in the box are unique
        Set<Integer> uniqueValues1 = new HashSet<>();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                uniqueValues1.add(arr1[i][j]);
            }
        }
        assertEquals(4, uniqueValues1.size());

        //For 6x6
        /**int arr2[][] = {{0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0}};
         newBoard6x6.fillBox(arr2,0,0);

         // Check that all values in the box are between 1 and 9
         for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
         System.out.print("|" + arr2[i][j] + "|" );
         assertTrue(arr2[i][j] >= 1 && arr2[i][j] <= 6);
         }System.out.print("\n");
         }System.out.print("\n");


         // Check that all values in the box are unique
         Set<Integer> uniqueValues2 = new HashSet<>();
         for (int i = 0; i < 3; i++) {
         for (int j = 0; j < 3; j++) {
         uniqueValues2.add(arr2[i][j]);
         }
         }
         assertEquals(6, uniqueValues2.size());*/

        //For 9x9
        int arr3[][] = {{ 3, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 0, 0 }};
        newBoard9x9.fillBox(arr3,0,0);

        // Check that all values in the box are between 1 and 9
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(arr3[i][j] >= 1 && arr3[i][j] <= 9);
            }
        }

        // Check that all values in the box are unique
        Set<Integer> uniqueValues3 = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                uniqueValues3.add(arr3[i][j]);
            }
        }
        assertEquals(9, uniqueValues3.size());

        //For 12x12
        /**int arr4[][] = {{3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
         newBoard12x12.fillBox(arr4,0,0);

         // Check that all values in the box are between 1 and 9
         for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
         assertTrue(arr4[i][j] >= 1 && arr4[i][j] <= 16);
         }
         }

         // Check that all values in the box are unique
         Set<Integer> uniqueValues4 = new HashSet<>();
         for (int i = 0; i < 4; i++) {
         for (int j = 0; j < 4; j++) {
         uniqueValues4.add(arr3[i][j]);
         }
         }
         assertEquals(16, uniqueValues4.size());*/
    }



    // Test 7
    @Test
    public void fillRemainingTest() {
        //For 4x4
        int[][] arr1 = {{0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};


        // check diagonals are zero
        newBoard4x4.fillRemaining(arr1,0, 2);
        for (int i = 0; i < 2; i++)
        {
            for (int j = 0; j < 2; j++)
            {
                assertTrue(arr1[i][j] == 0);
            }
        }
        boolean isNotEmpty1 = false;
        for (int i = 0; i < 2; i++)
        {
            for (int j = 2; j < 4; j++)
            {
                if (arr1[i][j] != 0)
                {
                    isNotEmpty1 = true;
                }
            }
        }
        assertTrue(isNotEmpty1);

        //For 6x6
        /**int[][] arr2 = {{0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0}};


         // check diagonals are zero
         newBoard6x6.fillRemaining(arr2,0, 3);
         for (int i = 0; i < 3; i++)
         {
         for (int j = 0; j < 3; j++)
         {
         assertTrue(arr2[i][j] == 0);
         }
         }
         boolean isNotEmpty2 = false;
         for (int i = 0; i < 3; i++)
         {
         for (int j = 3; j < 6; j++)
         {
         if (arr2[i][j] != 0)
         {
         isNotEmpty2 = true;
         }
         }
         }
         assertTrue(isNotEmpty2);*/

        //For 9x9
        int[][] arr3 = {{0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};


        // check diagonals are zero
        newBoard9x9.fillRemaining(arr3,0, 3);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                assertTrue(arr3[i][j] == 0);
            }
        }
        boolean isNotEmpty3 = false;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 3; j < 9; j++)
            {
                if (arr3[i][j] != 0)
                {
                    isNotEmpty3 = true;
                }
            }
        }
        assertTrue(isNotEmpty3);

        //For 12x12
        /**int[][] arr4 = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
         {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};


         // check diagonals are zero
         newBoard12x12.fillRemaining(arr4,0, 4);
         for (int i = 0; i < 4; i++)
         {
         for (int j = 0; j < 4; j++)
         {
         assertTrue(arr4[i][j] == 0);
         }
         }
         boolean isNotEmpty4 = false;
         for (int i = 0; i < 4; i++)
         {
         for (int j = 4; j < 12; j++)
         {
         if (arr4[i][j] != 0)
         {
         isNotEmpty4 = true;
         }
         }
         }
         assertTrue(isNotEmpty4);*/


    }

    // test 8
    @Test
    public void CheckIfSafeTest(){
        //For 4x4
        int[][] arr1 = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}};

        arr1[3][3] = 2;
        // Check for an unsafe value in the same row
        assertFalse(newBoard4x4.CheckIfSafe(arr1,3,3,2));

        //For 6x6:
        int[][] arr2 = {
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0}};

        arr2[3][3] = 2;
        // Check for an unsafe value in the same row
        assertFalse(newBoard6x6.CheckIfSafe(arr2,3,3,2));
        //For 9x9:
        int[][] arr3 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0}};

        arr3[7][8] = 9;
        // Check for an unsafe value in the same row
        assertFalse(newBoard9x9.CheckIfSafe(arr3,7,8,9));
        // Check for an unsafe value in the same column
        //assertTrue(newBoard9x9.CheckIfSafe(arr3,1, 2, 2));
        // Check for an unsafe value in the same box
        //assertFalse(newBoard.CheckIfSafe(4, 4, 5));

        //For 12x12:
        int[][] arr4 = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        arr4[7][8] = 9;
        // Check for an unsafe value in the same row
        assertFalse(newBoard12x12.CheckIfSafe(arr4,7,8,9));
        // Check for an unsafe value in the same column
        //assertTrue(newBoard9x9.CheckIfSafe(arr3,1, 2, 2));
        // Check for an unsafe value in the same box
        //assertFalse(newBoard.CheckIfSafe(4, 4, 5));
    }

    // Test 9
    @Test
    public void unUsedInRowTest1() {
        //For 4x4
        int[][] input = {{0, 5, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};

        assertTrue(newBoard4x4.unUsedInRow(input, 0, 2));
        //assertFalse(newBoard4x4.unUsedInRow(input,1,4));

        int[][] input2 = {{0, 5, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1}};

        assertTrue(newBoard6x6.unUsedInRow(input2, 0, 2));
        //assertFalse(newBoard6x6.unUsedInRow(input2,1,0));

        //For 9x9
        int[][] input3 = {{0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};

        assertTrue(newBoard9x9.unUsedInRow(input3, 0, 2));
        //assertFalse(newBoard9x9.unUsedInRow(input3,1,0));

        //For 12x12
        int[][] input4 = {{0, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}};

        assertTrue(newBoard12x12.unUsedInRow(input4, 0, 2));
    }
    @Test
    public void unUsedInRowTest2() {
        //For 4x4
        int[][] input1 = {{0, 3, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};

        assertFalse(newBoard4x4.unUsedInRow(input1,1,1));

        //For 6x6
        int[][] input2 = {{0, 5, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1}};

        assertFalse(newBoard6x6.unUsedInRow(input2,1,0));

        //For 9x9
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
        assertFalse(newBoard9x9.unUsedInRow(input,1,0));


        //For 12x12
        int[][] input4 = {{0, 5, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}};

        assertFalse(newBoard12x12.unUsedInRow(input4,1,0));
    }

    // test 11
    @Test
    public void unUsedInColTest1() {
        //Test 4x4
        int[][] input1 = {{0, 4, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};

        assertTrue(newBoard4x4.unUsedInCol(input1,0, 2));
        //assertFalse(newBoard4x4.unUsedInCol(input1,1,5));

        //Test 6x6
        int[][] input2 = {{0, 3, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1}};

        assertTrue(newBoard6x6.unUsedInCol(input2,0, 2));
        //assertFalse(newBoard6x6.unUsedInCol(input2,1,5));
        //Test 9x9
        int[][] input = {{0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};

        assertTrue(newBoard9x9.unUsedInCol(input,0, 2));
        //assertFalse(newBoard9x9.unUsedInCol(input, 1,5));

        //Test 12x12
        int[][] input4 = {{0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}};

        assertTrue(newBoard12x12.unUsedInCol(input4,0, 2));
        //assertFalse(newBoard9x9.unUsedInCol(input, 1,5));
    }
    @Test
    public void unUsedInColTest2() {
        //Test 4x4
        int[][] input1 = {{0, 4, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};

        assertFalse(newBoard4x4.unUsedInCol(input1,1,1));

        //Test 6x6
        int[][] input2 = {{0, 3, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1}};

        assertFalse(newBoard6x6.unUsedInCol(input2,1,3));

        //Test 9x9
        int[][] input = {{0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1}};

        assertFalse(newBoard9x9.unUsedInCol(input,1,5));

        //Test 12x12
        int[][] input4 = {{0, 5, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}};

        assertFalse(newBoard12x12.unUsedInCol(input4,1,5));
    }


    // Test 12
    @Test
    public void removeKDigitsTest(){
        //For 4x4
        int[][] arr1 = {{0, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}};
        int numberOfZero1 = 1;   // In arr, there are 1 zeros
        int len1 = 4;
        int count1 = 1;
        newBoard9x9.removeKDigits(arr1, len1, count1);
        int zeroCount1 = 0;
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 4; j++){
                if(arr1[i][j] == 0)
                    zeroCount1++;
            }
        }
        assertEquals(zeroCount1, numberOfZero1 + count1);

        //For 6x6
        int[][] arr2 = {{0, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1}};
        int numberOfZero2 = 3;   // In arr, there are 3 zeros
        int len2 = 6;
        int count2 = 6;
        newBoard9x9.removeKDigits(arr2, len2, count2);
        int zeroCount2 = 0;
        for(int i = 0; i < 6; i++){
            for(int j = 0; j < 6; j++){
                if(arr2[i][j] == 0)
                    zeroCount2++;
            }
        }
        assertEquals(zeroCount2, numberOfZero2 + count2);

        //For 9x9
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
        newBoard9x9.removeKDigits(arr, len, count);
        int zeroCount = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(arr[i][j] == 0)
                    zeroCount++;
            }
        }

        assertEquals(zeroCount, numberOfZero + count);

        //For 12x12
        int[][] arr4 = {{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1}};
        int numberOfZero4 = 6;   // In arr, there are 6 zeros
        int len4 = 12;
        int count4 = 12;
        newBoard12x12.removeKDigits(arr4, len4, count4);
        int zeroCount4 = 0;
        for(int i = 0; i < 12; i++){
            for(int j = 0; j < 12; j++){
                if(arr4[i][j] == 0)
                    zeroCount4++;
            }
        }

        assertEquals(zeroCount4, numberOfZero4 + count4);
    }


    // Test 13
    @Test
    public void getInputTest(){
        assertArrayEquals(newBoard4x4.getArr_gameBoard(), newBoard4x4.getArr_gameBoard());
        assertArrayEquals(newBoard6x6.getArr_gameBoard(), newBoard6x6.getArr_gameBoard());
        assertArrayEquals(newBoard9x9.getArr_gameBoard(), newBoard9x9.getArr_gameBoard());
        assertArrayEquals(newBoard12x12.getArr_gameBoard(), newBoard12x12.getArr_gameBoard());
    }


}