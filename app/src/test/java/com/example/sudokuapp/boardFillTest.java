package com.example.sudokuapp;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

public class boardFillTest {

    boardFill board = new boardFill();
    ArrayList<ArrayList<Object>> emptyBoxIndexBoard;
    ArrayList<ArrayList<Object>> emptyBoxIndexInput;

    @Test
    public void getEmptyBoxIndexs() {
        emptyBoxIndexBoard = board.emptyBoxIndex;
        emptyBoxIndexInput = board.emptyBoxIndex;

        assertEquals(emptyBoxIndexBoard, emptyBoxIndexInput);
    }

    @Test
    public void setNumberPos() {

    }

    @Test
    public void eraseNumber() {
    }

    @Test
    public void getNum() {
    }

    @Test
    public void getBoard() {
    }

    @Test
    public void getEmptyBoxIndex() {
    }

    @Test
    public void getSelected_row() {
    }

    @Test
    public void getSelected_column() {
    }

    @Test
    public void setSelected_row() {
    }

    @Test
    public void setSelected_column() {
    }
}