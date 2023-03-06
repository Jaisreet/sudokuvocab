package View;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sudokuapp.R;

import java.util.ArrayList;
import java.util.Locale;

import Controller.drawBoard;
import Model.board_GamePlay;

public class MainActivity extends AppCompatActivity {

    private drawBoard gameBoard;
    private board_GamePlay gameBoardGamePlay;
    private setting_page settingsPageClass;

    // Number of seconds displayed
    // on the stopwatch.
    private int seconds = 0;

    // Is the stopwatch running?
    private boolean running;

    private boolean wasRunning;

    public TextView timeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gameBoard = findViewById(R.id.sudokuBoard);
        gameBoardGamePlay = gameBoard.getBoardFill();
        gameBoardGamePlay.getEmptyBoxIndexs();

        //Open the hint dialog box
        Button hint = findViewById(R.id.hint);
        hint.setOnClickListener(view -> openDialog());

        //calls the eraseText() function when erase button is clicked
        Button erase = findViewById(R.id.erase);
        erase.setOnClickListener(view -> eraseText());

        //calls reset() function when reset button is clicked
        ImageView reset = findViewById(R.id.resetbtn);
        reset.setOnClickListener(view -> reset());
        //calls check() function when check button is clicked
        Button check = findViewById(R.id.checkBtn);
        check.setOnClickListener(v -> check());
        //opens the setting dialog box when the setting button is clicked
        ImageView settingsDialog = findViewById(R.id.settingsDialog);
        settingsDialog.setOnClickListener(view -> openSettingDialog());

            
        timeView = (TextView)findViewById(R.id.timeView);

        if (savedInstanceState != null) {

                // Get the previous state of the stopwatch
                // if the activity has been
                // destroyed and recreated.
                seconds
                        = savedInstanceState
                        .getInt("seconds");
                running
                        = savedInstanceState
                        .getBoolean("running");
                wasRunning
                        = savedInstanceState
                        .getBoolean("wasRunning");

        }

        running = true;
        runTimer();


    }

    // Save the state of the stopwatch
    // if it's about to be destroyed.
     @Override
    public void onSaveInstanceState(
            Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState
                .putInt("seconds", seconds);
        savedInstanceState
                .putBoolean("running", running);
        savedInstanceState
                .putBoolean("wasRunning", wasRunning);
    }

    // If the activity is paused,
    // stop the stopwatch.
    @Override
    protected void onPause()
    {
        super.onPause();
        wasRunning = running;
        running = false;
    }

    // If the activity is resumed,
    // start the stopwatch
    // again if it was running previously.
    @Override
    protected void onResume()
    {
        super.onResume();
        if (wasRunning) {
            running = true;
        }
    }

    public void timerOn() {
        running = true;
    }

    public void timerOff() {
        running = false;
        seconds = 0;

    }

    public void timerStatus() {
        Boolean state = settingsPageClass.getTimerState();
        if(state) {
            running = true;
        }
        else {
            running = false;
            seconds = 0;
            timeView.setText("Timer off");
        }
    }
    public void onClickReset()
    {
        seconds = 0;
        running = true;
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
                if (running) {
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
        gameBoardGamePlay.setNumberPos(1);
        gameBoard.invalidate();
    }

    //set the value of selected column to 2 when the button two is pressed that is "duex"
    public void BTNTwoPress(View view) {
        gameBoardGamePlay.setNumberPos(2);
        gameBoard.invalidate();
    }

    //set the value of selected column to 3 when button three is pressed that is "trois"
    public void BTNThreePress(View view) {
        gameBoardGamePlay.setNumberPos(3);
        gameBoard.invalidate();
    }

    //set the value of selected column to 4 when button four is pressed that is "quatre"
    public void BTNFourPress(View view) {
        gameBoardGamePlay.setNumberPos(4);
        gameBoard.invalidate();
    }

    //set the value of selected column to 5 when button five is pressed that is "cinq"
    public void BTNFivePress(View view) {
        gameBoardGamePlay.setNumberPos(5);
        gameBoard.invalidate();
    }

    //set the value of selected column to 6 when button six is pressed that is "six"
    public void BTNSixPress(View view) {
        gameBoardGamePlay.setNumberPos(6);
        gameBoard.invalidate();
    }

    //set the value of selected column to 7 when button seven is pressed that is "sept"
    public void BTNSevenPress(View view) {
        gameBoardGamePlay.setNumberPos(7);
        gameBoard.invalidate();
    }

    //set the value of selected column to 8 when button eight is pressed that is "huit"
    public void BTNEightPress(View view) {
        gameBoardGamePlay.setNumberPos(8);
        gameBoard.invalidate();
    }

    //set the value of selected column to 9 when button nine is pressed that is "neuf"
    public void BTNNinePress(View view) {
        gameBoardGamePlay.setNumberPos(9);
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
        onClickReset();
    }

    //check the user input in emptyboxindex with the solutionBoard
    //if solution is correct it stays if wrong the value in that cell is set to 0
    public void check(){
        for(ArrayList<Object> letter : gameBoardGamePlay.getEmptyBoxIndex()) {

            int r = (int) letter.get(0);
            int c = (int) letter.get(1);
            if (gameBoardGamePlay.getBoard()[r][c] != gameBoardGamePlay.getSolutionBoard()[r][c]) {
                gameBoardGamePlay.getBoard()[r][c] = 0;
            }
        }
    }
    //opens the hint dialog box
    public void openDialog() {
        hintDialog hint = new hintDialog();
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
        // if decline button is clicked, close the custom dialog
        resume.setOnClickListener(v -> {
            // Close dialog
            timerOn();
            dialog.dismiss();
        });

        newGame.setOnClickListener(v -> {
            //starts the new game by calling startNewGame()
            onClickReset();
            startNewGame();
            dialog.dismiss();
        });

        //open quit dialog box by calling quit function
        quitGame.setOnClickListener(v -> {
            onClickReset();
            dialog.dismiss();
            quit();
        });

        //open the setting page
        settings.setOnClickListener(v -> {
            dialog.dismiss();
            settingPage();

        });

    }

    //starts the new games by starting a new instance of main activity
    public void startNewGame(){
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
        onClickReset();
    }

    //opens the setting page activity
    public void settingPage() {
        Intent intent = new Intent(this, setting_page.class);
        this.startActivity(intent);
    }

    //open the quit dialog box
    public void quit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Are you sure you want to quit?")
                //if yes front page is opened
                .setPositiveButton("Yes", (dialog, id) -> backToMain())
                //if no it goes back to the setting dialog box
                .setNegativeButton("No", (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }


}