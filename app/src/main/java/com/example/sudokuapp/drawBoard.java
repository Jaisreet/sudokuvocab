package com.example.sudokuapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class drawBoard extends View {
    private final int boardColor;
    private final int cellFillColor;
    private final int cellHightlightColor;
    private final int letterColor;
    private final int letterColorSolve;

    private final int wrongAns;
    private final Paint boardColorPaint = new Paint();
    private final Paint cellFillColorPaint = new Paint();
    private final Paint cellHightlightColorPaint = new Paint();
    private final Paint letterPaint = new Paint();
    private final Rect letterPaintBounds = new Rect();
    private int cellsize;

    private final board_GamePlay board_GamePlay = new board_GamePlay();


    public drawBoard(Context context, @Nullable AttributeSet attrs) {
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
            wrongAns = a.getInteger(R.styleable.SudokuBoard_wrongAns,0);

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

        colorCell(canvas, board_GamePlay.getSelected_row(), board_GamePlay.getSelected_column());

        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredWidth(), boardColorPaint);
        drawBoard(canvas);
        drawNumbers(canvas);

    }

    //figure out which cell is selected on a click and check if its a valid position or not
    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent (MotionEvent event){
        boolean isVaild;

        float x = event.getX();
        float y = event.getY();

        int action = event.getAction();

        if(action == MotionEvent.ACTION_DOWN){
            board_GamePlay.setSelected_row((int) Math.ceil(y/cellsize));
            board_GamePlay.setSelected_column((int)Math.ceil(x/cellsize));
            isVaild = true;
        }
        else{
            isVaild = false;
        }

        return isVaild;

    }
    //to add numbers to the board
    private void drawNumbers(Canvas canvas){
        //size of numbers are set according to the size of cell
        letterPaint.setTextSize(cellsize);

        for(int r=0; r<9;r++){
            for(int c =0; c<9;c++){
                if(board_GamePlay.getBoard()[r][c] != 0){
                    String text = Integer.toString(board_GamePlay.getBoard()[r][c]);
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
        //paint the number with different colour to show user input
        //only paint the numbers written in emptyboxIndex with letterColorSolve
        letterPaint.setColor(letterColorSolve);

        for(ArrayList<Object> letter : board_GamePlay.getEmptyBoxIndex()){

            int r = (int)letter.get(0);
            int c = (int)letter.get(1);
            if(board_GamePlay.getBoard()[r][c] != 0) {
                String text = Integer.toString(board_GamePlay.getBoard()[r][c]);
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

    //show the selected cell by highlighting it
    private void colorCell(Canvas canvas, int r, int c){
            //highlight the row and column of selected cell with cellHightlightcolorpaint
            canvas.drawRect((c-1)*cellsize, 0, c*cellsize , cellsize*9,
                    cellHightlightColorPaint );

            canvas.drawRect(0, (r-1)*cellsize, cellsize*9 , r*cellsize,
                    cellHightlightColorPaint );
            //highlight the selected cell with cell fill color paint
            canvas.drawRect((c-1)*cellsize, (r-1)*cellsize, c*cellsize , r*cellsize,
                    cellFillColorPaint );

        invalidate();
    }

    //to draw outer think lines of sudoku board
    private void DrawThickLine() {
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(10);
        boardColorPaint.setColor(boardColor);
    }

    //to draw inner thin lines of sudoku board
    private void DrawThinLine() {
        boardColorPaint.setStyle(Paint.Style.STROKE);
        boardColorPaint.setStrokeWidth(5);
        boardColorPaint.setColor(boardColor);
    }

    //draw the sudoku board
    private void drawBoard(Canvas canvas){
        //columns of board
        for (int col = 0; col < 10; col++ ) {
            if (col%3 == 0) {
                //outer think lines
                DrawThickLine();
            } else {
                //inner thin lines
                DrawThinLine();
            }
            canvas.drawLine(cellsize * col, 0, cellsize * col,
                    getWidth(),boardColorPaint);
        }
        //rows of board
        for (int row = 0; row < 10; row++ ) {
            if (row%3 == 0) {
                //outer thick lines
                DrawThickLine();
            } else {
                //inner thin lines
                DrawThinLine();
            }
            canvas.drawLine(0, cellsize * row,getWidth() ,
                    cellsize * row,boardColorPaint);
        }
    }

    //return the sudoku board
    public board_GamePlay getBoardFill(){

        return this.board_GamePlay;
    }

}
