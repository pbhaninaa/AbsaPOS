package com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.utils.FragmentUtils;

public class CardParameters extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_card_parameters, container, false);
        Button confirmBtn = view.findViewById(R.id.bin_btn);
        EditText BinNumber = view.findViewById(R.id.entered_bin);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String binNumberText = BinNumber.getText().toString().trim(); // Get the text from BinNumber EditText and trim any leading/trailing spaces
                if (!binNumberText.isEmpty()) {
                    Alerts.showAlertDialog(getActivity(), "About to print slip for Bin number " + binNumberText);
                    BinNumber.setText(R.string.empty);
                }
            }
        });

        return view;
    }
}