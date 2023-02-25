package com.example.sudokuapp;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import Model.board_GamePlay;

public class board_GamePlayTest {

    Model.board_GamePlay board_GamePlay = new board_GamePlay();
    ArrayList<ArrayList<Object>> emptyBoxIndexBoard;
    ArrayList<ArrayList<Object>> emptyBoxIndexInput;

    @Test
    public void getEmptyBoxIndexesTest() {
        emptyBoxIndexBoard = board_GamePlay.emptyBoxIndex;
        emptyBoxIndexInput = board_GamePlay.emptyBoxIndex;

        assertEquals(emptyBoxIndexBoard, emptyBoxIndexInput);
    }

    @Test
    public void setNumberPosTest() {
        board_GamePlay.setNumberPos(1);
        assertEquals(1, board_GamePlay.getBoard()[board_GamePlay.getSelected_row() - 1][board_GamePlay.getSelected_column() - 1]);
    }

    @Test
    public void eraseNumberTest() {
        eraseNumberTest();
        assertEquals(0, board_GamePlay.getBoard()[board_GamePlay.getSelected_row() - 1][board_GamePlay.getSelected_column() - 1]);
    }

    @Test
    public void getNumTest() {
        assertEquals(board_GamePlay.getNum(), board_GamePlay.getBoard()[board_GamePlay.getSelected_row() - 1][board_GamePlay.getSelected_column() - 1]);
    }

    @Test
    public void getBoardTest() {
        //assertEquals(boardFill.board, boardFill.getBoard());
    }

    @Test
    public void getEmptyBoxIndexTest() {
        assertEquals(board_GamePlay.emptyBoxIndex, board_GamePlay.getEmptyBoxIndex());
    }

    @Test
    public void getSelected_rowTest() {
        assertEquals(board_GamePlay.getSelected_row(), board_GamePlay.getSelected_row());
    }

    @Test
    public void getSelected_columnTest() {
        assertEquals(board_GamePlay.selected_column, board_GamePlay.getSelected_column());
    }

    @Test
    public void setSelected_rowTest() {
        board_GamePlay.setSelected_row(1);
        assertEquals(1, board_GamePlay.getSelected_row());
    }

    @Test
    public void setSelected_columnTest() {
        board_GamePlay.setSelected_column(1);
        assertEquals(1, board_GamePlay.getSelected_column());
    }
}