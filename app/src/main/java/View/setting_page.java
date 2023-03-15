package View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.sudokuapp.R;

public class setting_page extends AppCompatActivity {

    private Button save;
    private Switch simpleSwitch;
    private Boolean timerState;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page2);
        timerState = true;

        simpleSwitch = (Switch) findViewById(R.id.timer);
        simpleSwitch.setChecked(timerState);
        // Set switch listener
        simpleSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                timerState = isChecked;
            }
        });


        save = findViewById(R.id.save);
        save.setOnClickListener(view -> save());

    }



    //go back to the last activity from where setting button was clicked
    public void backToMain(View view) {
        finish();
    }

    public void save() {
        timerState = simpleSwitch.isChecked();
    }
    public boolean getTimerState() {
        return timerState;
    }


    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

}
