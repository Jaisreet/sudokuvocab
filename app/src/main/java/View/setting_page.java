package View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

    public String timerState;
    public static String timerStr;

    private Switch simpleSwitch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_page2);

        simpleSwitch = (Switch) findViewById(R.id.timer);
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(view -> save());
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
        timerState = String.valueOf(simpleSwitch.isChecked());
        System.out.println("timer: " + timerState);
        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.putExtra("timerStr", timerState);
        startActivity(intent);
    }
}