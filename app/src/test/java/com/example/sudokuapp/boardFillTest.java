package com.example.sudokuapp;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class boardFillTest {

    boardFill boardFill = new boardFill();
    ArrayList<ArrayList<Object>> emptyBoxIndexBoard;
    ArrayList<ArrayList<Object>> emptyBoxIndexInput;

    @Test
    public void getEmptyBoxIndexesTest() {
        emptyBoxIndexBoard = boardFill.emptyBoxIndex;
        emptyBoxIndexInput = boardFill.emptyBoxIndex;

        assertEquals(emptyBoxIndexBoard, emptyBoxIndexInput);
    }

    @Test
    public void setNumberPosTest() {
        boardFill.setNumberPos(1);
        assertEquals(1, boardFill.getBoard()[boardFill.getSelected_row() - 1][boardFill.getSelected_column() - 1]);
    }

    @Test
    public void eraseNumberTest() {
        eraseNumberTest();
        assertEquals(0, boardFill.getBoard()[boardFill.getSelected_row() - 1][boardFill.getSelected_column() - 1]);
    }

    @Test
    public void getNumTest() {
        assertEquals(boardFill.getNum(), boardFill.getBoard()[boardFill.getSelected_row() - 1][boardFill.getSelected_column() - 1]);
    }

    @Test
    public void getBoardTest() {
       //assertEquals(boardFill.board, boardFill.getBoard());
    }

    @Test
    public void getEmptyBoxIndexTest() {
        assertEquals(boardFill.emptyBoxIndex, boardFill.getEmptyBoxIndex());
    }

    @Test
    public void getSelected_rowTest() {
        assertEquals(boardFill.selected_row, boardFill.getSelected_row());
    }

    @Test
    public void getSelected_columnTest() {
        assertEquals(boardFill.selected_column, boardFill.getSelected_column());
    }

    @Test
    public void setSelected_rowTest() {
       boardFill.setSelected_row(1);
       assertEquals(1, boardFill.getSelected_row());
    }

    @Test
    public void setSelected_columnTest() {
        boardFill.setSelected_column(1);
        assertEquals(1, boardFill.getSelected_column());
    }
}