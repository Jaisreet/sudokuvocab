package View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;

import com.example.sudokuapp.R;

public class setting_page extends AppCompatActivity {

    private RadioGroup timer;
    private RadioButton onOff;
    private Button save;

    public Boolean timerState;

    private Switch simpleSwitch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page2);

        timerState = true;
        simpleSwitch = (Switch) findViewById(R.id.timer);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(view -> save());
    }

    //go back to the last activity from where setting button was clicked
    public void backToMain(View view) {
        finish();
    }


    public void save() {
        timerState = simpleSwitch.isChecked();
        finish();
    }
    public boolean getTimerState() {
        return timerState;
    }
}