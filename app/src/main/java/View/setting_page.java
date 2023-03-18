package View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.example.sudokuapp.R;

public class setting_page extends AppCompatActivity {
    public String timerState;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private Switch simpleSwitch;
    private int selectedDifficulty;

    private int selectedGrid;
    Boolean result;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page2);

        timerState = "true";

        selectedDifficulty = 1;

        simpleSwitch = findViewById(R.id.timer);
        //simpleSwitch.setChecked(Boolean.valueOf(timerState));
        RadioGroup difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        RadioButton easyButton = findViewById(R.id.easyButton);
        RadioButton mediumButton = findViewById(R.id.mediumButton);
        RadioButton hardButton = findViewById(R.id.hardButton);

        RadioGroup GridRadioGroup = findViewById(R.id.GridRadioGroup);
        RadioButton fourbyfour = findViewById(R.id.fourbyfour);
        RadioButton sixbysix = findViewById(R.id.sixbysix);
        RadioButton ninebynine = findViewById(R.id.ninebynine);
        RadioButton twelvebytwelve = findViewById(R.id.twelvebytwelve);


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
        int lastSelectedDifficulty = sharedPreferencesDiff.getInt("difficulty", 1);
        switch (lastSelectedDifficulty) {
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
        });

        /*
        SharedPreferences sharedPreferencesGrid = getSharedPreferences("settings", MODE_PRIVATE);
        int lastSelectedGrid = sharedPreferencesGrid.getInt("grid_size", 9);
        switch (lastSelectedDifficulty) {
            case 1:
                fourbyfour.setChecked(true);
                break;
            case 2:
                sixbysix.setChecked(true);
                break;
            case 3:
                ninebynine.setChecked(true);
                break;
            case 4:
                twelvebytwelve.setChecked(true);
                break;
        }

        GridRadioGroup.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.fourbyfour:
                    selectedGrid = 4;
                    break;
                case R.id.sixbysix:
                    selectedGrid = 6;
                    break;
                case R.id.ninebynine:
                    selectedGrid = 9;
                    break;
                case R.id.twelvebytwelve:
                    selectedGrid = 12;
            }
        });


         */
        Button save = findViewById(R.id.save);
        save.setOnClickListener(view -> save());

        RadioGroup languageRadioGroup = findViewById(R.id.languageRadioGroup);
        languageRadioGroup.setOnCheckedChangeListener((radioGroup, checkedId) -> {
            RadioButton radioButton = findViewById(checkedId);

        });

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
        //editor.putInt("grid_size", selectedGrid); // add this line to save the selected grid size
        editor.putBoolean("timer_enabled", simpleSwitch.isChecked());
        editor.apply();

        // Start the main activity with the selected difficulty level and grid size as intent extras
        Intent intent = new Intent(setting_page.this, MainActivity.class);
        intent.putExtra("difficulty", selectedDifficulty);
        //intent.putExtra("grid_size", selectedGrid); // add this line to pass the selected grid size
        startActivity(intent);


    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

    }

}
