package view;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.sudokuapp.R;

public class First_page extends AppCompatActivity {

    private int selectedDifficulty;

    private int selectedGrid;
    private int selectedLanguage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        Button newGame = findViewById(R.id.button12);
        newGame.setOnClickListener(View-> openNewGameDialogBox());

    }

    private void openNewGameDialogBox() {
        final Dialog dialog = new Dialog(First_page.this);
        // Include dialog.xml file
        dialog.setContentView(R.layout.newgame_dialog);
        // Set dialog title
        dialog.setTitle("New Game");
        dialog.show();

        Button game = dialog.findViewById(R.id.startGame);
        game.setOnClickListener(view -> newGame());

        selectedGrid = 9;
        selectedLanguage = 1;

        RadioGroup difficultyRadioGroup = dialog.findViewById(R.id.difficultyRadioGroup);
        RadioButton easyButton = dialog.findViewById(R.id.easyButton);
        RadioButton mediumButton = dialog.findViewById(R.id.mediumButton);
        RadioButton hardButton = dialog.findViewById(R.id.hardButton);

        RadioGroup GridRadioGroup = dialog.findViewById(R.id.GridRadioGroup);
        RadioButton fourbyfour = dialog.findViewById(R.id.fourbyfour);
        RadioButton sixbysix = dialog.findViewById(R.id.sixbysix);
        RadioButton ninebynine = dialog.findViewById(R.id.ninebynine);
        RadioButton twelvebytwelve = dialog.findViewById(R.id.twelvebytwelve);

        RadioGroup languageRadioGroup = dialog.findViewById(R.id.languageRadioGroup);
        RadioButton english = dialog.findViewById(R.id.english);
        RadioButton french = dialog.findViewById(R.id.French);



        SharedPreferences sharedPreferencesDiff = getSharedPreferences("newGame", MODE_PRIVATE);
        selectedDifficulty = sharedPreferencesDiff.getInt("ndifficulty", 1);

        SharedPreferences sharedPreferencesLang = getSharedPreferences("newGame", MODE_PRIVATE);
        selectedLanguage = sharedPreferencesLang.getInt("nlanguage", 2);

        SharedPreferences sharedPreferencesGrid = getSharedPreferences("newGame", MODE_PRIVATE);
        selectedGrid = sharedPreferencesGrid.getInt("ngrid_size", 9);




        switch (selectedDifficulty) {
            case 1:
                easyButton.setChecked(true);
                break;
            case 2:
                mediumButton.setChecked(true);
                break;
            case 3:
                hardButton.setChecked(true);
                break;
        }

        difficultyRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.easyButton:
                    selectedDifficulty = 1;
                    break;
                case R.id.mediumButton:
                    selectedDifficulty = 2;
                    break;
                case R.id.hardButton:
                    selectedDifficulty = 3;
                    break;
            }
            SharedPreferences sharedPreferencesDiff1 = getSharedPreferences("newGame", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesDiff1.edit();
            editor.putInt("ndifficulty", selectedDifficulty);
            editor.apply();
        });



        switch (selectedGrid) {
            case 4:
                fourbyfour.setChecked(true);
                break;
            case 6:
                sixbysix.setChecked(true);
                break;
            case 9:
                ninebynine.setChecked(true);
                break;
            case 12:
                twelvebytwelve.setChecked(true);
                break;
            default:
                ninebynine.setChecked(true); // set the default value to 9 if none of the cases match
                break;
        }

        GridRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.ninebynine:
                    selectedGrid = 9;
                    break;
                case R.id.fourbyfour:
                    selectedGrid = 4;
                    break;
                case R.id.sixbysix:
                    selectedGrid = 6;
                    break;
                case R.id.twelvebytwelve:
                    selectedGrid = 12;
                    break;
                default:
                    selectedGrid = 9;
                    ninebynine.setChecked(true); // set the default value to 9 and check the corresponding radio button
                    break;
            }
            SharedPreferences sharedPreferencesGrid1 = getSharedPreferences("newGame", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesGrid1.edit();
            editor.putInt("ngrid_size", selectedGrid);
            editor.apply();
        });


        switch (selectedLanguage) {
            case 1:
                english.setChecked(true);
                break;
            case 2:
                french.setChecked(true);
                break;
            default:
                selectedLanguage = 2;
                french.setChecked(true); // set the default value to french if none of the cases match
                break;
        }
        languageRadioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            switch (checkedId){
                case R.id.english:
                    selectedLanguage = 1;
                    break;

                case R.id.French:
                    selectedLanguage = 2;
                    break;
            }
            SharedPreferences sharedPreferencesLang1 = getSharedPreferences("newGame", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesLang1.edit();
            editor.putInt("nlanguage", selectedLanguage);
            editor.apply();

        });


    }


    //going to mainAcitivity when New Game button is pressed
    public void newGame() {
        // Save the selected difficulty level
        SharedPreferences.Editor editor = getSharedPreferences("newGame", MODE_PRIVATE).edit();
        editor.putInt("ndifficulty", selectedDifficulty);
        editor.putInt("ngrid_size", selectedGrid); // add this line to save the selected grid size
        editor.putInt("nlanguage", selectedLanguage);
        editor.apply();

        // Start the main activity with the selected difficulty level and grid size as intent extras
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ndifficulty", selectedDifficulty);
        intent.putExtra("ngrid_size", selectedGrid); // add this line to pass the selected grid size
        intent.putExtra("nlanguage", selectedLanguage);
        intent.putExtra("from_new_game", true);
        startActivity(intent);

    }
    //going to setting page when setting button is pressed
    public void settingPage(View view) {
        Intent intent = new Intent(this, setting_page.class);
        this.startActivity(intent);

    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
