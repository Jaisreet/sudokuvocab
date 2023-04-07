package view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

import java.util.HashMap;
import java.util.Map;

import Model.Board_Generation;
import Model.board_GamePlay;

public class hintDialog extends AppCompatDialogFragment {

    board_GamePlay gamePlay;
    Board_Generation input;
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Bundle args = getArguments();
        int value = args.getInt("value");

        HashMap<Integer, String[]>gameWords = gamePlay.getWordMap();

        //hint dialog box for when hint button is pressed
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Hint");
        StringBuilder messageBuilder = new StringBuilder();
        messageBuilder.append("The translations are:");

        int counter = 0;
        for (Map.Entry<Integer, String[]> entry : gameWords.entrySet()) {
            if(counter >= value){
                break;
            }
            int wordNumber = entry.getKey();
            String[] translation = entry.getValue();

            messageBuilder.append("\n")
                    .append(wordNumber)
                    .append(": ")
                    .append(translation[0])
                    .append(" is ")
                    .append(translation[1]);

            counter++;
        }
        builder.setMessage(messageBuilder.toString());

        builder.setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
