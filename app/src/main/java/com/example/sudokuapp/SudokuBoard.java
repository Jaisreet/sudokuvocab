package com.example.sudokuapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class SudokuBoard extends View {
    private final int boardColor;
    private final Paint boardColorPaint = new Paint();
    private int cellsize;

    public SudokuBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SudokuBoard,
                0, 0);

        try {
            // extract board color from typed array
            boardColor = a.getInteger(R.styleable.SudokuBoard_boardColor, 0);
        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);

        // set the dimension to the min of the height and width
        int dimension = Math.min(this.getMeasuredWidth(), this.getMeasuredHeight());
        //int dimension = getMeasuredWidth();

        cellsize = dimension / 9;


        // set our view width and height to the dimension
        setMeasuredDimension(dimension, dimension);
    }

    // draw rectangle
    @Override
    protected void onDraw(Canvas canvas) {
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(25);
        boardColorPaint.setColor(boardColor);
        boardColorPaint.setAntiAlias(true);

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), boardColorPaint);
        drawBoard(canvas);

    }

    private void DrawThickLine() {
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(10);
        boardColorPaint.setColor(boardColor);
    }

    private void DrawThinLine() {
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(5);
        boardColorPaint.setColor(boardColor);
    }

    private void drawBoard(Canvas canvas){
        for (int col = 0; col < 10; col++ ) {
            if (col%3 == 0) {
                DrawThickLine();
            } else {
                DrawThinLine();
            }
            canvas.drawLine(cellsize * col, 0, cellsize * col,
                    getWidth(),boardColorPaint);
        }

        for (int row = 0; row < 10; row++ ) {
            if (row%3 == 0) {
                DrawThickLine();
            } else {
                DrawThinLine();
            }
            canvas.drawLine(0, cellsize * row,getWidth() ,
                    cellsize * row,boardColorPaint);
        }
    }
}
