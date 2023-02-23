package com.example.sudokuapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
<<<<<<< HEAD
import android.view.View;
=======
import android.widget.Button;
import android.widget.LinearLayout;
>>>>>>> 0de12f89aa470d79f3266e7a9f265b4b2b6b4cf2

import androidx.appcompat.app.AppCompatDialogFragment;

public class settingsDialog extends AppCompatDialogFragment {

    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // Get the layout inflater
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        builder.setView(inflater.inflate(R.layout.settings_dialog, null));

        return builder.create();
    }


<<<<<<< HEAD

=======
>>>>>>> 0de12f89aa470d79f3266e7a9f265b4b2b6b4cf2
}
