package com.example.sudokuapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;

import android.view.View;

import android.widget.Button;
import android.widget.LinearLayout;


import androidx.appcompat.app.AppCompatDialogFragment;

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
