package Controller;

import java.io.Serializable;

public class CurrentBoard implements Serializable {
    private int[][] currentBoard;
    private int[][] solutionBoard;

    public CurrentBoard(int[][] currentBoard, int[][] solutionBoard) {
        this.currentBoard = currentBoard;
        this.solutionBoard = solutionBoard;
    }

    public int[][] getCurrentBoard() {
        return currentBoard;
    }

    public void setCurrentBoard(int[][] currentBoard) {
        this.currentBoard = currentBoard;
    }

    public int[][] getSolutionBoard() {
        return solutionBoard;
    }

    public void setSolutionBoard(int[][] solutionBoard) {
        this.solutionBoard = solutionBoard;
    }
}
