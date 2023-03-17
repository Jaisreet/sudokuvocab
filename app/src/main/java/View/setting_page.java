package View;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.example.sudokuapp.R;

public class setting_page extends AppCompatActivity {
    private Button save;
    public String timerState;
    private Switch simpleSwitch;
    private RadioButton easyButton;
    private RadioButton mediumButton;
    private RadioButton hardButton;
    private RadioGroup difficultyRadioGroup;

    private String selectedDifficulty;

    Boolean result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page2);

        timerState = "true";

        selectedDifficulty = "easy";

        simpleSwitch = (Switch) findViewById(R.id.timer);
        //simpleSwitch.setChecked(Boolean.valueOf(timerState));
        difficultyRadioGroup = findViewById(R.id.difficultyRadioGroup);
        easyButton = findViewById(R.id.easyButton);
        mediumButton = findViewById(R.id.mediumButton);
        hardButton = findViewById(R.id.hardButton);

        SharedPreferences sharedPreferences = getSharedPreferences("switchResult", MODE_PRIVATE);
        result = sharedPreferences.getBoolean("result", false);
        simpleSwitch.setChecked(result);
        // Set switch listener
        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    result = true;
                    SharedPreferences sharedPref = getSharedPreferences("switchResult",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("result", isChecked);
                    editor.apply();
                }
                else{
                    result = false;
                    SharedPreferences sharedPref = getSharedPreferences("switchResult",MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPref.edit();
                    editor.putBoolean("result", isChecked);
                    editor.apply();
                }

            }
        });

        // Set radio group listener
        difficultyRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.easyButton:
                        selectedDifficulty = "easy";
                        break;
                    case R.id.mediumButton:
                        selectedDifficulty = "medium";
                        break;
                    case R.id.hardButton:
                        selectedDifficulty = "hard";
                        break;
                }
            }
        });
        save = findViewById(R.id.save);
        save.setOnClickListener(view -> save());

        RadioGroup languageRadioGroup = findViewById(R.id.languageRadioGroup);
        languageRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                RadioButton radioButton = findViewById(checkedId);

            }
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


    public String getSelectedDifficulty() {
        return selectedDifficulty;
    }

    public void save() {
        timerState = String.valueOf(simpleSwitch.isChecked());
        System.out.println("timer: " + timerState);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("timerStr", timerState);
        startActivity(intent);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
