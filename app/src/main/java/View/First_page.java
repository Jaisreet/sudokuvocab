package View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.sudokuapp.R;

public class First_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);
    }

    //going to mainAcitivity when New Game button is pressed
    public void newGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        this.startActivity(intent);
    }
    //going to setting page when setting button is pressed
    public void settingPage(View view) {
        Intent intent = new Intent(this, setting_page.class);
        this.startActivity(intent);

    }

}
