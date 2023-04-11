package view;


import static android.os.Build.VERSION_CODES.N;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.sudokuapp.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import Controller.drawBoard;
import Controller.wordList;
import Model.board_GamePlay;

public class MainActivity extends AppCompatActivity {

    private drawBoard gameBoard;
    private board_GamePlay gameBoardGamePlay;

    private First_page firstPage;

    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;
    public TextView timeView;
    public String timer;
    private boolean goneSwitchState;
    boolean switchResult;
    int difficultyLevel;
    int gridSize;
    int language;

    TextToSpeech t1;

    boolean listenCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean fromNewGame = getIntent().getBooleanExtra("from_new_game", false);
        boolean fromSettingPage = getIntent().getBooleanExtra("from_setting", false);

        if(fromSettingPage){
            // Get the selected difficulty level from the settingPage activity
            difficultyLevel = getIntent().getIntExtra("difficulty", 1); // default difficulty is 1 (easy)
            gridSize = getIntent().getIntExtra("grid_size", 9); // 9 is the default value
            language = getIntent().getIntExtra("language", 2);
            listenCheck = getIntent().getBooleanExtra("Listen", false);

            SharedPreferences sharedPreferences = getSharedPreferences("settings", MODE_PRIVATE);
            switchResult = sharedPreferences.getBoolean("timer_enabled", true);

            SharedPreferences sharedPreferences1 = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences1.edit();
            editor.putInt("difficulty", difficultyLevel);
            editor.putInt("language", language);
            editor.putInt("grid_size", gridSize);
            editor.putBoolean("Listen", listenCheck);
            editor.apply();
        } else if (fromNewGame) {
            difficultyLevel = getIntent().getIntExtra("ndifficulty", 1); // default difficulty is 1 (easy)
            gridSize = getIntent().getIntExtra("ngrid_size", 9); // 9 is the default value
            language = getIntent().getIntExtra("nlanguage", 2);
            listenCheck = getIntent().getBooleanExtra("nListen", false);
            SharedPreferences sharedPreferences1 = getSharedPreferences("newGame", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences1.edit();
            editor.putInt("ndifficulty", difficultyLevel);
            editor.putInt("nlanguage", language);
            editor.putInt("ngrid_size", gridSize);
            editor.putBoolean("nListen", listenCheck);
            editor.apply();
        }

        t1 = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR)
                    
                    if (language == 1) {
                        t1.setLanguage(Locale.ENGLISH);
                    } else {
                        t1.setLanguage(Locale.FRENCH);
                    }
            }
        });

        gameBoard = findViewById(R.id.sudokuBoard);
        gameBoard.setBoardSize(gridSize);

        timeView = findViewById(R.id.timeView);
        timer = getIntent().getStringExtra("timerStr");


        if (savedInstanceState != null) {
            difficultyLevel = savedInstanceState.getInt("difficulty");
            gridSize = savedInstanceState.getInt("grid");
            // Retrieve the stored data from the bundle and restore the state of the drawBoard view
            int[][] board = (int[][]) savedInstanceState.getSerializable("board");
            int[][] flag = (int[][]) savedInstanceState.getSerializable("flag_state");
            int[][] solution = (int[][]) savedInstanceState.getSerializable("solution_state");
            String[][] wordBoard = (String[][])savedInstanceState.getSerializable("word_board");
            String[][] wordBoardSolution = (String[][])savedInstanceState.getSerializable("word_solution_state");
            HashMap<Integer, String[]> gameWord = (HashMap<Integer, String[]>)savedInstanceState.getSerializable("wordList");
            listenCheck = savedInstanceState.getBoolean("listenCheck");
            gameBoardGamePlay = new board_GamePlay(board, flag, solution, gridSize,wordBoard,wordBoardSolution, gameWord, listenCheck);
            gameBoard.setBoardFill(gameBoardGamePlay);
            gameBoardGamePlay.getEmptyBoxIndexs();
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
            runTimer();
            if(running){
                timeView.setVisibility(View.VISIBLE);
            }
            else{
                goneSwitchState = true;
                timeView.setVisibility(View.GONE);
            }
        }
        else{
            System.out.println(listenCheck+" hello");
            gameBoardGamePlay = new board_GamePlay(difficultyLevel, gridSize, language, listenCheck);
            gameBoard.setBoardFill(gameBoardGamePlay);
            gameBoardGamePlay.getEmptyBoxIndexs();
            if(switchResult){
                running = true;
                runTimer();
                timeView.setVisibility(View.VISIBLE);
            }
            else{
                running = false;
                goneSwitchState = true;
                runTimer();
                timeView.setVisibility(View.GONE);
            }

        }

        //Open the hint dialog box
        Button hint =findViewById(R.id.hint);
        hint.setOnClickListener(view -> openDialog());

        //calls the eraseText() function when erase button is clicked
        Button erase = findViewById(R.id.erase);
        erase.setOnClickListener(view -> eraseText());

        //calls reset() function when reset button is clicked
        ImageView reset = findViewById(R.id.resetbtn);
        reset.setOnClickListener(view -> reset());
        //calls check() function when check button is clicked
        Button check =findViewById(R.id.checkBtn);
        check.setOnClickListener(v -> check());
        //opens the setting dialog box when the setting button is clicked
        ImageView settingsDialog = findViewById(R.id.settingsDialog);
        settingsDialog.setOnClickListener(view -> openSettingDialog());

        Button Listen = findViewById(R.id.ListeningComprehension);
        if (listenCheck == false) {
            Listen.setVisibility(View.GONE);

        }

        Listen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String word =  gameBoardGamePlay.readOutLoud_text(language);

                t1.speak(word, TextToSpeech.QUEUE_FLUSH,null);
            }
        });

        Button ButtonOne = (Button) findViewById(R.id.button);
        Button ButtonTwo = (Button) findViewById(R.id.button2);
        Button ButtonThree = (Button) findViewById(R.id.button3);
        Button ButtonFour = (Button) findViewById(R.id.button4);
        Button ButtonFive = (Button) findViewById(R.id.button5);
        Button ButtonSix = (Button) findViewById(R.id.button6);
        Button ButtonSeven = (Button) findViewById(R.id.button7);
        Button ButtonEight = (Button) findViewById(R.id.button8);
        Button ButtonNine = (Button) findViewById(R.id.button9);
        Button ButtonTen = (Button) findViewById(R.id.button10);
        Button ButtonEleven = (Button) findViewById(R.id.button11);
        Button ButtonTwelve = (Button) findViewById(R.id.button12);


        HashMap<Integer, String[]> gameWords = board_GamePlay.getWordMap();

        if(gridSize == 4){
            ButtonFive.setVisibility(View.GONE);
            ButtonSix.setVisibility(View.GONE);
            ButtonSeven.setVisibility(View.GONE);
            ButtonEight.setVisibility(View.GONE);
            ButtonNine.setVisibility(View.GONE);
            ButtonTen.setVisibility(View.GONE);
            ButtonEleven.setVisibility(View.GONE);
            ButtonTwelve.setVisibility(View.GONE);
        } else if (gridSize == 6 ) {
            ButtonSeven.setVisibility(View.GONE);
            ButtonEight.setVisibility(View.GONE);
            ButtonNine.setVisibility(View.GONE);
            ButtonTen.setVisibility(View.GONE);
            ButtonEleven.setVisibility(View.GONE);
            ButtonTwelve.setVisibility(View.GONE);
        } else if (gridSize == 9) {
            ButtonTen.setVisibility(View.GONE);
            ButtonEleven.setVisibility(View.GONE);
            ButtonTwelve.setVisibility(View.GONE);
        }

        if(language == 1){
            ButtonOne.setText(gameWords.get(1)[0]);
            ButtonTwo.setText(gameWords.get(2)[0]);
            ButtonThree.setText(gameWords.get(3)[0]);
            ButtonFour.setText(gameWords.get(4)[0]);
            ButtonFive.setText(gameWords.get(5)[0]);
            ButtonSix.setText(gameWords.get(6)[0]);
            ButtonSeven.setText(gameWords.get(7)[0]);
            ButtonEight.setText(gameWords.get(8)[0]);
            ButtonNine.setText(gameWords.get(9)[0]);
            ButtonTen.setText(gameWords.get(10)[0]);
            ButtonEleven.setText(gameWords.get(11)[0]);
            ButtonTwelve.setText(gameWords.get(12)[0]);
        }
        else{
            ButtonOne.setText(gameWords.get(1)[1]);
            ButtonTwo.setText(gameWords.get(2)[1]);
            ButtonThree.setText(gameWords.get(3)[1]);
            ButtonFour.setText(gameWords.get(4)[1]);
            ButtonFive.setText(gameWords.get(5)[1]);
            ButtonSix.setText(gameWords.get(6)[1]);
            ButtonSeven.setText(gameWords.get(7)[1]);
            ButtonEight.setText(gameWords.get(8)[1]);
            ButtonNine.setText(gameWords.get(9)[1]);
            ButtonTen.setText(gameWords.get(10)[1]);
            ButtonEleven.setText(gameWords.get(11)[1]);
            ButtonTwelve.setText(gameWords.get(12)[1]);
        }


    }



    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
    }

    // If the activity is paused,
    // stop the stopwatch.
    @Override
    protected void onPause() {
        super.onPause();
        wasRunning = running;
        running = false;
        goneSwitchState = false;
    }


    public void onClickReset()
    {
        seconds = 0;
        running = false;
    }
    // If the activity is resumed,
    // start the stopwatch
    // again if it was running previously.
    @Override
    protected void onResume()
    {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences("switchResult", MODE_PRIVATE);
        boolean switchResult = sharedPreferences.getBoolean("result",false);
        int difficultyLevel = sharedPreferences.getInt("difficulty", 1);
        int gridSize = sharedPreferences.getInt("grid_size", 9);

        if(switchResult){
            running = true;
            timeView.setVisibility(View.VISIBLE);
        }
        else{
            running = false;
            goneSwitchState = true;
            timeView.setVisibility(View.GONE);
        }


    }

    public void timerOff() {
        running = false;
    }

    public void timerStatus(Boolean state) {
        if(state) {
            running = true;
        }
        else {
            running = false;
            seconds = 0;
            timeView.setText("Timer off");
        }
    }
    private void runTimer()
    {

        // Creates a new Handler
        final Handler handler
                = new Handler();

        // Call the post() method,
        // passing in a new Runnable.
        // The post() method processes
        // code without a delay,
        // so the code in the Runnable
        // will run almost immediately.
        handler.post(new Runnable() {
            @Override

            public void run()
            {
                int hours = seconds / 3600;
                int minutes = (seconds % 3600) / 60;
                int secs = seconds % 60;

                // Format the seconds into hours, minutes,
                // and seconds.
                String time
                        = String
                        .format(Locale.getDefault(),
                                "%d:%02d:%02d", hours,
                                minutes, secs);

                // Set the text view text.
                timeView.setText(time);

                // If running is true, increment the
                // seconds variable.
                if (running|| goneSwitchState) {
                    seconds++;
                }
                // Post the code again
                // with a delay of 1 second.
                handler.postDelayed(this, 1000);
            }
        });
    }


    //go back to first page
    public void backToMain(){
        Intent intent = new Intent(this, First_page.class);
        this.startActivity(intent);
    }


    //set the value of selected column to 1 when button one is pressed that is "un"
    public void BTNOnePress(View view) {
        gameBoardGamePlay.setNumberPos(1, language);
        gameBoard.invalidate();
    }

    //set the value of selected column to 2 when the button two is pressed that is "duex"
    public void BTNTwoPress(View view) {
        gameBoardGamePlay.setNumberPos(2, language);
        gameBoard.invalidate();
    }

    //set the value of selected column to 3 when button three is pressed that is "trois"
    public void BTNThreePress(View view) {
        gameBoardGamePlay.setNumberPos(3, language);
        gameBoard.invalidate();
    }

    //set the value of selected column to 4 when button four is pressed that is "quatre"
    public void BTNFourPress(View view) {
        gameBoardGamePlay.setNumberPos(4, language);
        gameBoard.invalidate();
    }

    //set the value of selected column to 5 when button five is pressed that is "cinq"
    public void BTNFivePress(View view) {
        gameBoardGamePlay.setNumberPos(5, language);
        gameBoard.invalidate();
    }

    //set the value of selected column to 6 when button six is pressed that is "six"
    public void BTNSixPress(View view) {
        gameBoardGamePlay.setNumberPos(6, language);
        gameBoard.invalidate();
    }

    //set the value of selected column to 7 when button seven is pressed that is "sept"
    public void BTNSevenPress(View view) {
        gameBoardGamePlay.setNumberPos(7, language);
        gameBoard.invalidate();
    }

    //set the value of selected column to 8 when button eight is pressed that is "huit"
    public void BTNEightPress(View view) {
        gameBoardGamePlay.setNumberPos(8, language);
        gameBoard.invalidate();
    }

    //set the value of selected column to 9 when button nine is pressed that is "neuf"
    public void BTNNinePress(View view) {
        gameBoardGamePlay.setNumberPos(9, language);
        gameBoard.invalidate();
    }

    public void BTNTenPress(View view) {
        gameBoardGamePlay.setNumberPos(10, language);
        gameBoard.invalidate();
    }

    public void BTNElevenPress(View view) {
        gameBoardGamePlay.setNumberPos(11, language);
        gameBoard.invalidate();
    }

    public void BTNTwelvePress(View view) {
        gameBoardGamePlay.setNumberPos(12, language);
        gameBoard.invalidate();
    }


    //calls eraseNumber function which set the value to given cell to 0
    public void eraseText() {
        gameBoardGamePlay.eraseNumber();
    }

    //reset the game by setting all the values in emptyboxindex array to zero
    public void reset() {
        for(ArrayList<Object> letter : gameBoardGamePlay.getEmptyBoxIndex()) {

            int r = (int) letter.get(0);
            int c = (int) letter.get(1);
            if (gameBoardGamePlay.getBoard()[r][c] != 0) {
                gameBoardGamePlay.getBoard()[r][c] = 0;
            }
        }
    }

    //check the user input in empty box index with the solutionBoard
    //if solution is correct it stays if wrong the value in that cell is set to 0
    public void check(){

        int hours = seconds / 3600;
        int minutes = (seconds % 3600) / 60;
        int secs = seconds % 60;

        // Format the seconds into hours, minutes,
        // and seconds.
        String time
                = String
                .format(Locale.getDefault(),
                        "%d:%02d:%02d", hours,
                        minutes, secs);

        for(ArrayList<Object> letter : gameBoardGamePlay.getEmptyBoxIndex()) {
            int r = (int) letter.get(0);
            int c = (int) letter.get(1);
            if (gameBoardGamePlay.getBoard()[r][c] != gameBoardGamePlay.getSolutionBoard()[r][c]) {
                gameBoardGamePlay.getBoard()[r][c] = 0;
            }
        }

        if(Arrays.deepEquals(gameBoardGamePlay.getBoard(),gameBoardGamePlay.getSolutionBoard())){
            System.out.print("\n");
            onPause();
            AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);

            alert.setTitle("Game Complete");
            alert.setMessage("Congratulations!! You finished the game successfully in " + time
            + "\n Do you want to start a new game?");
            alert.setPositiveButton("Okay",
                    (dialog, which) -> {
                        backToMain();
                        dialog.cancel();
                    });

            alert.show();
        }
   }

    //opens the hint dialog box
    public void openDialog() {
        hintDialog hint = new hintDialog();
        Bundle args = new Bundle();
        args.putInt("value", gridSize);
        hint.setArguments(args);
        hint.show(getSupportFragmentManager(), "hintDialog");
    }

    //opens the setting dialog box
    public void openSettingDialog() {
        onPause();
        final Dialog dialog = new Dialog(MainActivity.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.settings_dialog);
        // Set dialog title
        dialog.setTitle("Settings");
        // set values for custom dialog components - text, image and button
        Button resume = dialog.findViewById(R.id.resume);
        Button newGame = dialog.findViewById(R.id.newGameBtn);
        Button quitGame = dialog.findViewById(R.id.quitGame);
        Button settings = dialog.findViewById(R.id.settingsPage);

        dialog.show();
        dialog.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        resume.setOnClickListener(v -> {
            onResume();
            // Close dialog
            dialog.dismiss();
        });

        newGame.setOnClickListener(v -> {
            //starts the new game by calling startNewGame()
            backToMain();

        });

        //open quit dialog box by calling quit function
        quitGame.setOnClickListener(v -> quit());

        //open the setting page
        settings.setOnClickListener(v -> settingPage());

    }

    //starts the new games by starting a new instance of main activity
    public void startNewGame(){
        firstPage.openNewGameDialogBox();
    }

    //opens the setting page activity
    public void settingPage() {
        Intent intent = new Intent(getApplicationContext(), setting_page.class);
        intent.putExtra("default_difficulty", 1);
        intent.putExtra("default_grid_size", 9);
        startActivity(intent);
    }




    //open the quit dialog box
    public void quit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        TextView message = new TextView(this );
        message.setTextSize(40);
        message.setText("Are you sure you want to quit?");
        builder.setView(message)
                //if yes front page is opened
                .setPositiveButton("Yes", (dialog, id) -> backToMain())
                //if no it goes back to the setting dialog box
                .setNegativeButton("No", (dialog, id) -> dialog.cancel());

        AlertDialog alert = builder.create();
        alert.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                Button btnPositive = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                btnPositive.setTextSize(30);
                Button btnNegative = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_NEGATIVE);
                btnNegative.setTextSize(30);
            }
        });
        alert.show();
    }


    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Bundle outState = new Bundle();
        onSaveInstanceState(outState);
    }


    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        // Store the data you want to save in the bundle
        outState.putSerializable("board", gameBoard.getBoard());
        outState.putSerializable("word_board", gameBoardGamePlay.getWordBoard());
        outState.putSerializable("flag_state", gameBoardGamePlay.getFlag());
        outState.putSerializable("solution_state", gameBoardGamePlay.getSolutionBoard());
        outState.putSerializable("word_solution_state", gameBoardGamePlay.getSolutionWordBoard());
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning", wasRunning);
        outState.putInt("difficulty", difficultyLevel);
        outState.putInt("grid", gridSize);
        outState.putSerializable("wordList", gameBoardGamePlay.getWordMap());
        outState.putBoolean("listenCheck", listenCheck);
    }


}
