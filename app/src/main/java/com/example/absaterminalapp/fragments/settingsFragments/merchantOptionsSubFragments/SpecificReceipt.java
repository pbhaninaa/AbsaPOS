package com.example.absaterminalapp.fragments.settingsFragments.merchantOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;


public class SpecificReceipt extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_specific_receipt, container, false);
        Button button = view.findViewById(R.id.specific_receipt_button);
        EditText value = view.findViewById(R.id.specific_receipt_value);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredValue = value.getText().toString().trim();

                if (!enteredValue.isEmpty()) {
                    String message = "Printing receipt number " + enteredValue ;
                    Alerts.showAlertDialog(getActivity(), message);
                } else {
                    Alerts.showAlertDialog(getActivity(), "Enter receipt number");
                }
            }
        });

        return view;
    }
}