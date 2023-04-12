package Model;
import android.speech.tts.TextToSpeech;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import Controller.wordList;

public class board_GamePlay {


    TextToSpeech t1;
    int[][] board;
    String[][] wordBoard;
    int [][] flag;
    int[][] solutionBoard;

    String[][] solutionWordBoard;
    Board_Generation input; //= new Board_Generation();
    wordList wordList;
    int N;// = input.return_n();
    int SQRT;// = input.return_sqrt();
    public ArrayList<ArrayList<Object>> emptyBoxIndex;
    int selected_row;
    public int selected_column;
    public static HashMap<Integer, String[]> gameWords;

    int[][] listenArray;
    int[][] checkArray;

    public static boolean listenCheck;

    public board_GamePlay(int difficulty, int size, int lang, boolean check){
        // when the user has not selected a square yet, set selected col and row to -1
        setBoardSize(size);
        input = new Board_Generation(size, difficulty);
        N = input.return_n();
        SQRT = input.return_sqrt();
        selected_column = -1;
        selected_row = -1;
        board = new int[N][N];  // main working board
        flag = new int[N][N];   // flag to keep track of pre-filled squares
        solutionBoard = new int[N][N];
        listenArray = new int[N][N];
        checkArray = new int[N][N];
        wordBoard = new String [N][N];
        solutionWordBoard = new String[N][N];
        listenCheck = check;
        // algorithm to move generated board set up into main board
        wordList = new wordList();
        gameWords = wordList.gameWords(12);
        for (Map.Entry<Integer, String[]> entry : gameWords.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            String[] values = entry.getValue();
            for (int i = 0; i < values.length; i++) {
                System.out.print(values[i] + " ");
            }
            System.out.println();
        }
        // for every row
        for(int r=0; r<N; r++) {
            // for every colomn
            for(int c=0;c<N;c++) {
                board[r][c] = input.getArr_gameBoard()[r][c];
                checkArray[r][c] = input.getArr_gameBoard()[r][c];

                if(board[r][c] != 0){
                    flag[r][c] = 1;
                    String[] values = gameWords.get(board[r][c]);
                    if(lang == 1){
                        wordBoard[r][c] = values[1];
                    }else{
                        wordBoard[r][c] = values[0];
                    }
                }
                else{
                    // if this square is empty, set the flag to zero
                    flag[r][c]=0;
                    wordBoard[r][c] = null;
                }

                solutionBoard[r][c] = input.getArr_solutionBoard()[r][c];
                if(lang == 1){
                    solutionWordBoard[r][c]= gameWords.get(solutionBoard[r][c])[1];
                }else{
                    solutionWordBoard[r][c]= gameWords.get(solutionBoard[r][c])[0];
                }

                if(listenCheck){
                    listenArray[r][c] = 0;

                }


            }
        }



        emptyBoxIndex = new ArrayList<>();
        getEmptyBoxIndexs();
    }

    public board_GamePlay(int[][] input, int[][] flag_input, int[][] solution_input, int size, String[][] wordBoardInput, String[][] wordSol, HashMap<Integer, String[]> wordList, Boolean listen){
        setBoardSize(size);
        gameWords = wordList;
        listenCheck = listen;
        // when the user has not selected a square yet, set selected col and row to -1
        selected_column = -1;
        selected_row = -1;
        board = new int[N][N];  // main working board
        flag = flag_input;  // flag to keep track of pre-filled squares
        solutionBoard = solution_input;
        wordBoard = new String[N][N];
        solutionWordBoard = wordSol;
        // algorithm to move generated board set up into main board

        // for every row
        for(int r=0; r < N; r++) {
            // for every colomn
            for(int c=0;c < N;c++) {
                board[r][c] = input[r][c];
                wordBoard[r][c] = wordBoardInput[r][c];
            }
        }

        emptyBoxIndex = new ArrayList<>();
        getEmptyBoxIndexs();

    }

    public void setBoardSize(int size) {
        N = size;
        SQRT = (int) Math.sqrt(N);
        if (size == 12) {
            SQRT = 3;
        }

    }

    //getting indexes of boxes with 0 (empty boxes)
    public void getEmptyBoxIndexs(){
        for(int r=0; r<N; r++){
            for(int c= 0; c<N; c++){
                if(listenCheck){
                    if(this.listenArray[r][c]==0){
                        this.emptyBoxIndex.add(new ArrayList<>());
                        this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(r);
                        this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(c);
                    }
                }else {
                    if (this.flag[r][c] == 0) {
                        this.emptyBoxIndex.add(new ArrayList<>());
                        this.emptyBoxIndex.get(this.emptyBoxIndex.size() - 1).add(r);
                        this.emptyBoxIndex.get(this.emptyBoxIndex.size() - 1).add(c);
                    }
                }
            }
        }
    }

    //set the value of selected column to given value (num)
    public void setNumberPos(int num, int lang){
        if(this.selected_row != -1 && this.selected_column != -1){
            if(this.board[this.selected_row-1][this.selected_column-1] == num && listenCheck){
                if (lang == 1) {
                    this.wordBoard[this.selected_row - 1][this.selected_column - 1] = gameWords.get(num)[1];
                } else {
                    this.wordBoard[this.selected_row - 1][this.selected_column - 1] = gameWords.get(num)[0];
                }
                this.listenArray[this.selected_row - 1][this.selected_column - 1] = 1;
                this.board[this.selected_row - 1][this.selected_column - 1] = 0;
            }
            if (this.board[this.selected_row - 1][this.selected_column - 1] == 0 && this.flag[this.selected_row - 1][this.selected_column - 1] == 0) {

                if (lang == 1) {
                    this.wordBoard[this.selected_row - 1][this.selected_column - 1] = gameWords.get(num)[1];
                } else {
                    this.wordBoard[this.selected_row - 1][this.selected_column - 1] = gameWords.get(num)[0];
                }
                if(!listenCheck){
                    this.board[this.selected_row - 1][this.selected_column - 1] = num;
                    this.checkArray[this.selected_row - 1][this.selected_column - 1] = num;
                }
                else {
                    this.board[this.selected_row - 1][this.selected_column - 1] = 0;
                    this.listenArray[this.selected_row - 1][this.selected_column - 1] = 1;
                    this.checkArray[this.selected_row - 1][this.selected_column - 1] = num;
                }
            }
        }

    }



    public String readOutLoud_text(int language) {

        if (this.selected_row != -1 && this.selected_column != -1) {
            if (this.board[this.selected_row - 1][this.selected_column - 1] != 0) {
                if (language == 1) {
                    String text = gameWords.get(this.board[this.selected_row - 1][this.selected_column - 1])[1];
                    return text;
                } else {
                    String text = gameWords.get(this.board[this.selected_row - 1][this.selected_column - 1])[0];
                    return text;
                }
            }
        }
        return null;
    }


    //set the value of selected column to 0 which is equal to erase
    public void eraseNumber() {
        if(this.selected_row != -1 && this.selected_column != -1){
            if(!listenCheck) {
                if (this.board[this.selected_row - 1][this.selected_column - 1] != 0 && this.flag[this.selected_row - 1][this.selected_column - 1] == 0) {
                    this.board[this.selected_row - 1][this.selected_column - 1] = 0;
                    this.wordBoard[this.selected_row - 1][this.selected_column - 1] = null;
                    this.checkArray[this.selected_row - 1][this.selected_column - 1]=0;
                }
            }else{
                if (this.checkArray[this.selected_row - 1][this.selected_column - 1] != 0){
                    this.board[this.selected_row - 1][this.selected_column - 1] = 0;
                    this.checkArray[this.selected_row - 1][this.selected_column - 1]=0;
                    this.wordBoard[this.selected_row - 1][this.selected_column - 1] = null;
                }

            }
        }
    }

    public static boolean getListenCheck(){return listenCheck;}
    public static HashMap<Integer, String[]> getWordMap(){
        return gameWords;
    }
    //return value of selected cell
    public int getNum(){
        return this.board[this.selected_row-1][this.selected_column-1];
    }

    //return the game board
    public int[][] getBoard(){
        return this.board;
    }
    public String[][] getWordBoard(){
        return this.wordBoard;
    }

    public int[][] getListenArray(){
        return this.listenArray;
    }

    public int[][] getCheckArray(){
        return this.checkArray;
    }

    //return the solution board
    public int[][] getSolutionBoard(){return this.solutionBoard;}

    public String[][] getSolutionWordBoard(){return this.solutionWordBoard;}

    //return the array indexes of the board which has value 0, that is equivalent to empty box
    public ArrayList<ArrayList<Object>> getEmptyBoxIndex() {
        return this.emptyBoxIndex;
    }

    public void setEmptyBoxIndex(ArrayList<ArrayList<Object>> emptyBoxIndex1){
        emptyBoxIndex = emptyBoxIndex1;
    }

    //return the selected row
    public int getSelected_row(){
        return selected_row;
    }

    //return the selected column
    public int getSelected_column(){
        return selected_column;
    }

    //set the row to given value r
    public void setSelected_row(int r){
        selected_row = r;
    }

    //set the column to given value c
    public void setSelected_column(int c){
        selected_column = c;
    }

    public void setBoard(int[][] newBoard) {
        board = newBoard;
    }

    public int[][] getFlag(){
        return this.flag;
    }

    public int return_n() {return N;}
    public int return_sqrt() {return SQRT;}





}
