package com.example.sudokuapp;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.util.ArrayList;

public class SudokuBoard extends View {
    private final int boardColor;
    private final int cellFillColor;
    private final int cellHightlightColor;
    private final int letterColor;
    private final int letterColorSolve;
    private final Paint boardColorPaint = new Paint();
    private final Paint cellFillColorPaint = new Paint();
    private final Paint cellHightlightColorPaint = new Paint();
    private final Paint letterPaint = new Paint();
    private final Rect letterPaintBounds = new Rect();
    private int cellsize;

    private final boardFill boardFill = new boardFill();

    public SudokuBoard(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.getTheme().obtainStyledAttributes(attrs, R.styleable.SudokuBoard,
                0, 0);

        try {
            // extract board color from typed array
            boardColor = a.getInteger(R.styleable.SudokuBoard_boardColor, 0);
            cellFillColor = a.getInteger(R.styleable.SudokuBoard_cellFilledColor, 0);
            cellHightlightColor = a.getInteger(R.styleable.SudokuBoard_cellHightlightColor, 0);
            letterColor= a.getInteger(R.styleable.SudokuBoard_letterColor,0 );
            letterColorSolve = a.getInteger(R.styleable.SudokuBoard_letterColorSolve,0);

        } finally {
            a.recycle();
        }
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, width);

        // set the dimension to the min of the height and width
        //int dimension = Math.min(this.getWidth(), this.getHeight());
        int dimension = getMeasuredWidth();

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

        cellFillColorPaint.setStyle(Paint.Style.FILL);
        cellFillColorPaint.setAntiAlias(true);
        cellFillColorPaint.setColor(cellFillColor);

        cellHightlightColorPaint.setStyle(Paint.Style.FILL);
        cellHightlightColorPaint.setAntiAlias(true);
        cellHightlightColorPaint.setColor(cellHightlightColor);

        letterPaint.setStyle(Paint.Style.FILL);
        letterPaint.setAntiAlias(true);
        letterPaint.setColor(letterColor);

        colorCell(canvas, boardFill.getSelected_row(), boardFill.getSelected_column());

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredWidth(), boardColorPaint);
        drawBoard(canvas);
        drawNumbers(canvas);

    }
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent (MotionEvent event){
        boolean isVaild;

        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN){
            boardFill.setSelected_row((int) Math.ceil(y/cellsize));
            boardFill.setSelected_column((int)Math.ceil(x/cellsize));
            isVaild = true;
        }
        else{
            isVaild = false;
        }

        return isVaild;

    }

    private void drawNumbers(Canvas canvas){

        letterPaint.setTextSize(cellsize);

        for(int r=0; r<9;r++){
            for(int c =0; c<9;c++){
                if(boardFill.getBoard()[r][c] != 0){
                    String text = Integer.toString(boardFill.getBoard()[r][c]);
                    float width, height;

                    letterPaint.getTextBounds(text, 0, text.length(), letterPaintBounds);
                    width = letterPaint.measureText(text);
                    height = letterPaintBounds.height();

                    canvas.drawText(text, (c*cellsize)+ ((cellsize-width)/2) ,
                            (r*cellsize+cellsize) - ((cellsize-height)/2),
                            letterPaint);
                }
            }
        }
        letterPaint.setColor(letterColorSolve);

        for(ArrayList<Object> letter : boardFill.getEmptyBoxIndex()){

            int r = (int)letter.get(0);
            int c = (int)letter.get(1);
            if(boardFill.getBoard()[r][c] != 0) {
                String text = Integer.toString(boardFill.getBoard()[r][c]);
                float width, height;

                letterPaint.getTextBounds(text, 0, text.length(), letterPaintBounds);
                width = letterPaint.measureText(text);
                height = letterPaintBounds.height();

                canvas.drawText(text, (c * cellsize) + ((cellsize - width) / 2),
                        (r * cellsize + cellsize) - ((cellsize - height) / 2),
                        letterPaint);
            }
        }
    }

    private void colorCell(Canvas canvas, int r, int c){
            canvas.drawRect((c-1)*cellsize, 0, c*cellsize , cellsize*9,
                    cellHightlightColorPaint );

            canvas.drawRect(0, (r-1)*cellsize, cellsize*9 , r*cellsize,
                    cellHightlightColorPaint );

            canvas.drawRect((c-1)*cellsize, (r-1)*cellsize, c*cellsize , r*cellsize,
                    cellFillColorPaint );

        invalidate();
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

    public boardFill getBoardFill(){

        return this.boardFill;
    }

}
