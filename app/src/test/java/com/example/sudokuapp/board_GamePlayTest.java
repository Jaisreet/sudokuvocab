package com.example.sudokuapp;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import Model.board_GamePlay;

public class board_GamePlayTest {

    Model.board_GamePlay board_GamePlay9x9 = new board_GamePlay(5,9,0, false);
    ArrayList<ArrayList<Object>> emptyBoxIndexBoard9x9;
    ArrayList<ArrayList<Object>> emptyBoxIndexInput9x9;


    Model.board_GamePlay board_gamePlay4x4 = new board_GamePlay(5, 4, 0, false);
    ArrayList<ArrayList<Object>> emptyBoxIndexBoard4x4;
    ArrayList<ArrayList<Object>> emptyBoxIndexInput4x4;


    Model.board_GamePlay board_gamePlay6x6 = new board_GamePlay(5, 6, 0, false);
    ArrayList<ArrayList<Object>> emptyBoxIndexBoard6x6;
    ArrayList<ArrayList<Object>> emptyBoxIndexInput6x6;


    Model.board_GamePlay board_gamePlay12x12 = new board_GamePlay(5, 12, 0, false);
    ArrayList<ArrayList<Object>> emptyBoxIndexBoard12x12;
    ArrayList<ArrayList<Object>> emptyBoxIndexInput12x12;

    @Test
    public void getEmptyBoxIndexesTest() {
        emptyBoxIndexBoard9x9 = board_GamePlay9x9.emptyBoxIndex;
        emptyBoxIndexInput9x9 = board_GamePlay9x9.emptyBoxIndex;

        assertEquals(emptyBoxIndexBoard9x9, emptyBoxIndexInput9x9);

        emptyBoxIndexBoard4x4 = board_gamePlay4x4.emptyBoxIndex;
        emptyBoxIndexInput4x4 = board_gamePlay4x4.emptyBoxIndex;
        assertEquals(emptyBoxIndexBoard4x4, emptyBoxIndexInput4x4);

        emptyBoxIndexBoard6x6 = board_gamePlay6x6.emptyBoxIndex;
        emptyBoxIndexInput6x6 = board_gamePlay6x6.emptyBoxIndex;
        assertEquals(emptyBoxIndexBoard6x6, emptyBoxIndexInput6x6);

        emptyBoxIndexBoard12x12 = board_gamePlay12x12.emptyBoxIndex;
        emptyBoxIndexInput12x12 = board_gamePlay12x12.emptyBoxIndex;
        assertEquals(emptyBoxIndexBoard12x12, emptyBoxIndexInput12x12);
    }

/* to be fixed
    @Test
    public void setNumberPosTest() {
        board_GamePlay.setNumberPos(1, 0);
        assertEquals(1, board_GamePlay.getBoard()[board_GamePlay.getSelected_row() - 1][board_GamePlay.getSelected_column() - 1]);
    }

    @Test
    public void eraseNumberTest() {
        eraseNumberTest();
        assertEquals(0, board_GamePlay.getBoard()[board_GamePlay.getSelected_row() - 1][board_GamePlay.getSelected_column() - 1]);
    }


    @Test
    public void getNumTest() {
        assertEquals(board_GamePlay.getNum(),
                board_GamePlay.getBoard()[board_GamePlay.getSelected_row() - 1][board_GamePlay.getSelected_column() - 1]);
    }
    */



    @Test
    public void getBoardTest() {
        int[][] board9x9 = board_GamePlay9x9.getBoard();
        assertEquals(board9x9, board_GamePlay9x9.getBoard());

        int[][] board4x4 = board_gamePlay4x4.getBoard();
        assertEquals(board4x4, board_gamePlay4x4.getBoard());

        int[][] board6x6 = board_gamePlay6x6.getBoard();
        assertEquals(board6x6, board_gamePlay6x6.getBoard());

        int[][] board12x12 = board_gamePlay12x12.getBoard();
        assertEquals(board12x12, board_gamePlay12x12.getBoard());
    }

    @Test
    public void getEmptyBoxIndexTest() {
        assertEquals(board_GamePlay9x9.emptyBoxIndex, board_GamePlay9x9.getEmptyBoxIndex());
        assertEquals(board_gamePlay4x4.emptyBoxIndex, board_gamePlay4x4.getEmptyBoxIndex());
        assertEquals(board_gamePlay6x6.emptyBoxIndex, board_gamePlay6x6.getEmptyBoxIndex());
        assertEquals(board_gamePlay12x12.emptyBoxIndex, board_gamePlay12x12.getEmptyBoxIndex());
    }

    @Test
    public void getSelected_rowTest() {
        assertEquals(board_GamePlay9x9.getSelected_row(), board_GamePlay9x9.getSelected_row());
        assertEquals(board_gamePlay4x4.getSelected_row(), board_gamePlay4x4.getSelected_row());
        assertEquals(board_gamePlay6x6.getSelected_row(), board_gamePlay6x6.getSelected_row());
        assertEquals(board_gamePlay12x12.getSelected_row(), board_gamePlay12x12.getSelected_row());
    }

    @Test
    public void getSelected_columnTest() {
        assertEquals(board_GamePlay9x9.selected_column, board_GamePlay9x9.getSelected_column());
        assertEquals(board_gamePlay4x4.selected_column, board_gamePlay4x4.getSelected_column());
        assertEquals(board_gamePlay6x6.selected_column, board_gamePlay6x6.getSelected_column());
        assertEquals(board_gamePlay12x12.selected_column, board_gamePlay12x12.getSelected_column());
    }

    @Test
    public void setSelected_rowTest() {
        board_GamePlay9x9.setSelected_row(1);
        assertEquals(1, board_GamePlay9x9.getSelected_row());
        board_gamePlay4x4.setSelected_row(1);
        assertEquals(1, board_gamePlay4x4.getSelected_row());
        board_gamePlay6x6.setSelected_row(1);
        assertEquals(1, board_gamePlay6x6.getSelected_row());
        board_gamePlay12x12.setSelected_row(1);
        assertEquals(1, board_gamePlay12x12.getSelected_row());
    }

    @Test
    public void setSelected_columnTest() {
        board_GamePlay9x9.setSelected_column(1);
        assertEquals(1, board_GamePlay9x9.getSelected_column());
        board_gamePlay4x4.setSelected_column(2);
        assertEquals(2, board_gamePlay4x4.getSelected_column());
        board_gamePlay6x6.setSelected_column(3);
        assertEquals(3, board_gamePlay6x6.getSelected_column());
        board_gamePlay12x12.setSelected_column(5);
        assertEquals(5, board_gamePlay12x12.getSelected_column());
    }

    @Test
    public void setBoardTest(){
        int[][] newBoard9x9 = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        board_GamePlay9x9.setBoard(newBoard9x9);
        assertArrayEquals(newBoard9x9[0], board_GamePlay9x9.getBoard()[0]);
        assertArrayEquals(newBoard9x9[1], board_GamePlay9x9.getBoard()[1]);
        assertArrayEquals(newBoard9x9[2], board_GamePlay9x9.getBoard()[2]);
        assertArrayEquals(newBoard9x9[3], board_GamePlay9x9.getBoard()[3]);
        assertArrayEquals(newBoard9x9[4], board_GamePlay9x9.getBoard()[4]);
        assertArrayEquals(newBoard9x9[5], board_GamePlay9x9.getBoard()[5]);
        assertArrayEquals(newBoard9x9[6], board_GamePlay9x9.getBoard()[6]);
        assertArrayEquals(newBoard9x9[7], board_GamePlay9x9.getBoard()[7]);
        assertArrayEquals(newBoard9x9[8], board_GamePlay9x9.getBoard()[8]);


        int[][] newBoard4x4 = {
                {1, 2, 3, 4},
                {3, 4, 1, 2},
                {2, 1, 4, 3},
                {4, 3, 2, 1}
        };
        board_gamePlay4x4.setBoard(newBoard4x4);
        assertArrayEquals(newBoard4x4[0], board_gamePlay4x4.getBoard()[0]);
        assertArrayEquals(newBoard4x4[1], board_gamePlay4x4.getBoard()[1]);
        assertArrayEquals(newBoard4x4[2], board_gamePlay4x4.getBoard()[2]);
        assertArrayEquals(newBoard4x4[3], board_gamePlay4x4.getBoard()[3]);


        int[][] newBoard6x6 = {
                {1, 2, 3, 4, 5, 6},
                {4, 5, 6, 1, 2, 3},
                {2, 3, 4, 5, 6, 1},
                {5, 6, 1, 2, 3, 4},
                {3, 4, 5, 6, 1, 2},
                {6, 1, 2, 3, 4, 5}
        };

        board_gamePlay6x6.setBoard(newBoard6x6);
        assertArrayEquals(newBoard6x6[0], board_gamePlay6x6.getBoard()[0]);
        assertArrayEquals(newBoard6x6[1], board_gamePlay6x6.getBoard()[1]);
        assertArrayEquals(newBoard6x6[2], board_gamePlay6x6.getBoard()[2]);
        assertArrayEquals(newBoard6x6[3], board_gamePlay6x6.getBoard()[3]);
        assertArrayEquals(newBoard6x6[4], board_gamePlay6x6.getBoard()[4]);
        assertArrayEquals(newBoard6x6[5], board_gamePlay6x6.getBoard()[5]);


        int[][] newBoard12x12 = {
                {8, 9, 5, 6, 1, 3, 10, 11, 12, 2, 7, 4},
                {2, 12, 1, 7, 8, 4, 6, 5, 9, 11, 3, 10},
                {4, 7, 11, 2, 10, 9, 1, 8, 6, 5, 12, 3},
                {3, 8, 7, 11, 12, 5, 4, 2, 1, 6, 9, 10},
                {10, 11, 6, 4, 3, 2, 7, 12, 5, 9, 8, 1},
                {12, 1, 2, 8, 9, 6, 11, 10, 4, 7, 5, 3},
                {7, 5, 10, 3, 6, 8, 9, 1, 11, 12, 4, 2},
                {9, 6, 4, 12, 2, 1, 5, 7, 3, 10, 11, 8},
                {1, 3, 12, 9, 11, 7, 2, 6, 8, 4, 10, 5},
                {5, 2, 8, 1, 7, 10, 12, 3, 10, 11, 6, 9},
                {6, 4, 9, 5, 11, 12, 3, 7, 2, 1, 10, 8},
                {11, 10, 3, 12, 4, 2, 8, 9, 7, 8, 1, 6}
        };
        board_gamePlay12x12.setBoard(newBoard12x12);
        assertArrayEquals(newBoard12x12[0], board_gamePlay12x12.getBoard()[0]);
        assertArrayEquals(newBoard12x12[1], board_gamePlay12x12.getBoard()[1]);
        assertArrayEquals(newBoard12x12[2], board_gamePlay12x12.getBoard()[2]);
        assertArrayEquals(newBoard12x12[3], board_gamePlay12x12.getBoard()[3]);
        assertArrayEquals(newBoard12x12[4], board_gamePlay12x12.getBoard()[4]);
        assertArrayEquals(newBoard12x12[5], board_gamePlay12x12.getBoard()[5]);
        assertArrayEquals(newBoard12x12[6], board_gamePlay12x12.getBoard()[6]);
        assertArrayEquals(newBoard12x12[7], board_gamePlay12x12.getBoard()[7]);
        assertArrayEquals(newBoard12x12[8], board_gamePlay12x12.getBoard()[8]);
        assertArrayEquals(newBoard12x12[9], board_gamePlay12x12.getBoard()[9]);
        assertArrayEquals(newBoard12x12[10], board_gamePlay12x12.getBoard()[10]);
        assertArrayEquals(newBoard12x12[11], board_gamePlay12x12.getBoard()[11]);
    }

    @Test
    public void getFlagTest(){
        int[][] temp9x9_1 = board_GamePlay9x9.getFlag();
        int[][] temp9x9_2 = board_GamePlay9x9.getFlag();
        assertArrayEquals(temp9x9_1[0], temp9x9_2[0]);
        assertArrayEquals(temp9x9_1[1], temp9x9_2[1]);
        assertArrayEquals(temp9x9_1[2], temp9x9_2[2]);
        assertArrayEquals(temp9x9_1[3], temp9x9_2[3]);
        assertArrayEquals(temp9x9_1[4], temp9x9_2[4]);
        assertArrayEquals(temp9x9_1[5], temp9x9_2[5]);
        assertArrayEquals(temp9x9_1[6], temp9x9_2[6]);
        assertArrayEquals(temp9x9_1[7], temp9x9_2[7]);
        assertArrayEquals(temp9x9_1[8], temp9x9_2[8]);

        int[][] temp4x4_1 = board_gamePlay4x4.getFlag();
        int[][] temp4x4_2 = board_gamePlay4x4.getFlag();
        assertArrayEquals(temp4x4_1[0], temp4x4_2[0]);
        assertArrayEquals(temp4x4_1[1], temp4x4_2[1]);
        assertArrayEquals(temp4x4_1[2], temp4x4_2[2]);
        assertArrayEquals(temp4x4_1[3], temp4x4_2[3]);

        int[][] temp6x6_1 = board_gamePlay6x6.getFlag();
        int[][] temp6x6_2 = board_gamePlay6x6.getFlag();
        assertArrayEquals(temp6x6_1[0], temp6x6_2[0]);
        assertArrayEquals(temp6x6_1[1], temp6x6_2[1]);
        assertArrayEquals(temp6x6_1[2], temp6x6_2[2]);
        assertArrayEquals(temp6x6_1[3], temp6x6_2[3]);
        assertArrayEquals(temp6x6_1[4], temp6x6_2[4]);
        assertArrayEquals(temp6x6_1[5], temp6x6_2[5]);

        int[][] temp12x12_1 = board_gamePlay12x12.getFlag();
        int[][] temp12x12_2 = board_gamePlay12x12.getFlag();
        assertArrayEquals(temp12x12_1[0], temp12x12_2[0]);
        assertArrayEquals(temp12x12_1[1], temp12x12_2[1]);
        assertArrayEquals(temp12x12_1[2], temp12x12_2[2]);
        assertArrayEquals(temp12x12_1[3], temp12x12_2[3]);
        assertArrayEquals(temp12x12_1[4], temp12x12_2[4]);
        assertArrayEquals(temp12x12_1[5], temp12x12_2[5]);
        assertArrayEquals(temp12x12_1[6], temp12x12_2[6]);
        assertArrayEquals(temp12x12_1[7], temp12x12_2[7]);
        assertArrayEquals(temp12x12_1[8], temp12x12_2[8]);
        assertArrayEquals(temp12x12_1[9], temp12x12_2[9]);
        assertArrayEquals(temp12x12_1[10], temp12x12_2[10]);
        assertArrayEquals(temp12x12_1[11], temp12x12_2[11]);
    }

    @Test
    public void return_nTest(){
        int temp1 = board_GamePlay9x9.return_n();
        assertEquals(temp1, 9);

        int temp2 = board_gamePlay4x4.return_n();
        assertEquals(temp2, 4);

        int temp3 = board_gamePlay6x6.return_n();
        assertEquals(temp3, 6);

        int temp4 = board_gamePlay12x12.return_n();
        assertEquals(temp4, 12);
    }

    @Test
    public void return_sqrtTest(){
        int temp = board_GamePlay9x9.return_sqrt();
        assertEquals(temp, 3);

        int temp1 = board_gamePlay4x4.return_sqrt();
        assertEquals(temp1, 2);

        int temp2 = board_gamePlay6x6.return_sqrt();
        assertEquals(temp2, 2);

        int temp3 = board_gamePlay12x12.return_sqrt();
        assertEquals(temp3, 2);
    }
}