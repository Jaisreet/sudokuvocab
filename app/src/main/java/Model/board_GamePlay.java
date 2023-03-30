package Model;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class board_GamePlay {

    int[][] board;
    Board_Generation input; //= new Board_Generation();
    int N;// = input.return_n();
    int SQRT;// = input.return_sqrt();
    public ArrayList<ArrayList<Object>> emptyBoxIndex;
    int selected_row;
    public int selected_column;
    int [][] flag;
    int[][] solutionBoard;
    int removeNum;


    public board_GamePlay(int difficulty, int size){
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
        // algorithm to move generated board set up into main board



        // for every row
        for(int r=0; r<N; r++) {
            // for every colomn
            for(int c=0;c<N;c++) {
                board[r][c] = input.getArr_gameBoard()[r][c];
                solutionBoard[r][c] = input.getArr_gameBoard()[r][c];
                // if the board at that spot is not empty, set the flag to one
                if(board[r][c] != 0){
                    flag[r][c] = 1;
                }
                else{
                    // if this square is empty, set the flag to zero
                    flag[r][c]=0;
                }
            }
        }

        emptyBoxIndex = new ArrayList<>();
        getEmptyBoxIndexs();
    }

    public board_GamePlay(int[][] input, int[][] flag_input, int[][] solution_input, int size){
        setBoardSize(size);
        // when the user has not selected a square yet, set selected col and row to -1
        selected_column = -1;
        selected_row = -1;
        board = new int[N][N];  // main working board
        flag = flag_input;  // flag to keep track of pre-filled squares
        solutionBoard = solution_input;
        // algorithm to move generated board set up into main board

        // for every row
        for(int r=0; r < N; r++) {
            // for every colomn
            for(int c=0;c < N;c++) {
                board[r][c] = input[r][c];
            }
        }

        emptyBoxIndex = new ArrayList<>();
        getEmptyBoxIndexs();

    }

    public void setBoardSize(int size) {
        N = size;
        SQRT = (int) Math.sqrt(N);
        if (size == 12)
            SQRT = 3;
    }

    //getting indexes of boxes with 0 (empty boxes)
    public void getEmptyBoxIndexs(){
        for(int r=0; r<N; r++){
            for(int c= 0; c<N; c++){
                if(this.flag[r][c]==0){
                    this.emptyBoxIndex.add(new ArrayList<>());
                    this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(r);
                    this.emptyBoxIndex.get(this.emptyBoxIndex.size()-1).add(c);
                }
            }
        }
    }

    //set the value of selected column to given value (num)
    public void setNumberPos(int num){
        if(this.selected_row != -1 && this.selected_column != -1){
            if(this.board[this.selected_row-1][this.selected_column-1]== 0 && this.flag[this.selected_row-1][this.selected_column-1] == 0){
                this.board[this.selected_row - 1][this.selected_column - 1] = num;

            }
        }

    }
    //set the value of selected column to 0 which is equal to erase
    public void eraseNumber() {
        if(this.selected_row != -1 && this.selected_column != -1){
            if(this.board[this.selected_row-1][this.selected_column-1]!= 0 && this.flag[this.selected_row-1][this.selected_column-1] == 0){
                this.board[this.selected_row-1][this.selected_column-1] = 0;
            }
        }
    }
    //return value of selected cell
    public int getNum(){
        return this.board[this.selected_row-1][this.selected_column-1];
    }

    //return the game board
    public int[][] getBoard(){
        return this.board;
    }

    //return the solution board
    public int[][] getSolutionBoard(){return this.solutionBoard;}

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
