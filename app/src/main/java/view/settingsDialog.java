package view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;


import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.sudokuapp.R;

public class settingsDialog extends AppCompatDialogFragment {

    //setting dialog box
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.settings_dialog, null));

        return builder.create();

    }





}
