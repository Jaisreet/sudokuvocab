package Controller;

import java.io.Serializable;

import Model.Board_Generation;
import Model.board_GamePlay;

public class CurrentBoard implements Serializable {
    private int[][] currentBoard;
    private int[][] solutionBoard;
    public static Board_Generation boardGeneration;
    public board_GamePlay gameBoardGamePlay;

    public CurrentBoard(int n, int k) {
        //boardGeneration = new Board_Generation();
        int[][]board = boardGeneration.getArr_gameBoard();
        int[][]solution = boardGeneration.getArr_solutionBoard();
        //gameBoardGamePlay = new board_GamePlay(board,solution, n);

    }

    public board_GamePlay getBoardFill(){

        return gameBoardGamePlay;
    }

    public static Board_Generation getboardGeneration(){
        return boardGeneration;
    }
    public int[][] getCurrentBoard() {
        return currentBoard;
    }

    /*

    public void setCurrentBoard(int[][] currentBoard) {
        this.currentBoard = currentBoard;
    }

    public int[][] getSolutionBoard() {
        return solutionBoard;
    }

    public void setSolutionBoard(int[][] solutionBoard) {
        this.solutionBoard = solutionBoard;
    }

    public void getEmptyBoxIndexs(){
        gameBoardGamePlay.getEmptyBoxIndexs();
    }

    public void setNumberPos(int num){
        gameBoardGamePlay.setNumberPos(num);
    }

     */
}
