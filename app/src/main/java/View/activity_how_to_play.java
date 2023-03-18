package View;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sudokuapp.R;

public class activity_how_to_play extends AppCompatActivity {

    private Button okay;
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.how_to_play_activity);

        okay = findViewById(R.id.instructions_okay);
        okay.setOnClickListener(view -> okayListener());

        text = findViewById(R.id.howtoplay);

    }

    private void okayListener() {
        finish();
    }
}
