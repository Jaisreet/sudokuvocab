package view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

import com.example.sudokuapp.R;

public class setting_page extends AppCompatActivity {
    public String timerState;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch simpleSwitch;
    private int selectedDifficulty;

    private int selectedGrid;
    private Boolean result;
    private Boolean isFirstTime;
    private int selectedLanguage;

    Boolean isChecked;

    private TextView howtoplay;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page2);

        timerState = "true";

        //selectedDifficulty = 1;

        selectedGrid = 9;

        selectedLanguage = 1;

        simpleSwitch = findViewById(R.id.timer);

        RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        RadioButton easyButton = findViewById(R.id.easyButton);
        RadioButton mediumButton = findViewById(R.id.mediumButton);
        RadioButton hardButton = findViewById(R.id.hardButton);

        RadioGroup GridRadioGroup = findViewById(R.id.GridRadioGroup);
        RadioButton fourbyfour = findViewById(R.id.fourbyfour);
        RadioButton sixbysix = findViewById(R.id.sixbysix);
        RadioButton ninebynine = findViewById(R.id.ninebynine);
        RadioButton twelvebytwelve = findViewById(R.id.twelvebytwelve);

        RadioGroup languageRadioGroup = findViewById(R.id.languageRadioGroup);
        RadioButton english = findViewById(R.id.english);
        RadioButton french = findViewById(R.id.French);

        CheckBox check = findViewById(R.id.checkBox);

        howtoplay = findViewById(R.id.howtoplay);
        if(howtoplay != null){
            howtoplay.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    play();
                }
            });
        }



        SharedPreferences sharedPreferences = getSharedPreferences("switchResult", MODE_PRIVATE);
        result = sharedPreferences.getBoolean("result", false);
        simpleSwitch.setChecked(result);
        // Set switch listener
        simpleSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                result = true;
                SharedPreferences sharedPref = getSharedPreferences("switchResult",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("result", true);
                editor.apply();
            }
            else{
                result = false;
                SharedPreferences sharedPref = getSharedPreferences("switchResult",MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putBoolean("result", false);
                editor.apply();
            }

        });


        SharedPreferences sharedPreferencesDiff = getSharedPreferences("settings", MODE_PRIVATE);
        selectedDifficulty = sharedPreferencesDiff.getInt("difficulty", 1);

        SharedPreferences sharedPreferencesLang = getSharedPreferences("settings", MODE_PRIVATE);
        selectedLanguage = sharedPreferencesLang.getInt("language", 2);

        SharedPreferences sharedPreferencesGrid = getSharedPreferences("settings", MODE_PRIVATE);
        selectedGrid = sharedPreferencesGrid.getInt("grid_size", 9);

        SharedPreferences sharedPreferencesListen = getSharedPreferences("settings", MODE_PRIVATE);
        isChecked = sharedPreferencesListen.getBoolean("Listen", false);
        check.setChecked(isChecked);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isChecked = check.isChecked();
                SharedPreferences sharedPreferencesListen = getSharedPreferences("settings", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferencesListen.edit();
                editor.putBoolean("Listen", check.isChecked());
                editor.apply();
            }
        });


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
            SharedPreferences sharedPreferencesDiff1 = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesDiff1.edit();
            editor.putInt("difficulty", selectedDifficulty);
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
            SharedPreferences sharedPreferencesGrid1 = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesGrid1.edit();
            editor.putInt("grid_size", selectedGrid);
            editor.apply();
        });



        Button save = findViewById(R.id.save);
        save.setOnClickListener(view -> save());

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
            SharedPreferences sharedPreferencesLang1 = getSharedPreferences("settings", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferencesLang1.edit();
            editor.putInt("language", selectedLanguage);
            editor.apply();

        });


    }

    private void play() {
        Intent intent = new Intent(this, activity_how_to_play.class);
        this.startActivity(intent);
    }


    @Override
    protected void onNewIntent(final Intent intent) {
        super.onNewIntent(intent);
        this.setIntent(intent);
    }

    //go back to the last activity from where setting button was clicked
    public void backToMain(View view) {
        finish();
    }


    public void save() {

        // Save the selected difficulty level
        SharedPreferences.Editor editor = getSharedPreferences("settings", MODE_PRIVATE).edit();
        editor.putInt("difficulty", selectedDifficulty);
        editor.putInt("grid_size", selectedGrid); // add this line to save the selected grid size
        editor.putInt("language", selectedLanguage);
        editor.putBoolean("timer_enabled", simpleSwitch.isChecked());
        editor.putBoolean("Listen",isChecked);
        editor.apply();

        // Start the main activity with the selected difficulty level and grid size as intent extras
        Intent intent = new Intent(setting_page.this, MainActivity.class);
        intent.putExtra("difficulty", selectedDifficulty);
        intent.putExtra("grid_size", selectedGrid); // add this line to pass the selected grid size
        intent.putExtra("language", selectedLanguage);
        intent.putExtra("from_setting", true);
        intent.putExtra("Listen", isChecked);
        startActivity(intent);


    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

}
