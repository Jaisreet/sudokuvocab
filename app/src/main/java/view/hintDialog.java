package view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatDialogFragment;

public class hintDialog extends AppCompatDialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        //hint dialog box for when hint button is pressed
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Hint")
                .setMessage("The translation is:" +
                        "\n Un is 1 " +
                        "\n Deux is 2 " +
                        "\n Trois is Three " +
                        "\n Quatre is 4 " +
                        "\n Cinq is 5" +
                        "\n Six is 6" +
                        "\n Sept is 7" +
                        "\n Huit is 8" +
                        "\n Neuf is 9" )
                .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
        return builder.create();
    }
}
