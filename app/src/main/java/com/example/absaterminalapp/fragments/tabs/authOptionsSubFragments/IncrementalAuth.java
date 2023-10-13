package com.example.absaterminalapp.fragments.tabs.authOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;

public class IncrementalAuth extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_incrementsl_auth, container, false);
        EditText amountTxt = view.findViewById(R.id.incremental_auth_amount);
        EditText codeTxt = view.findViewById(R.id.incremental_auth_code);
        codeTxt.setHint("0.00");
        EditText dateTxt = view.findViewById(R.id.incremental_auth_date);
        Button button = view.findViewById(R.id.incremental_auth_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the EditText fields
                String amount = amountTxt.getText().toString().trim();
                String code = codeTxt.getText().toString().trim();
                String date = dateTxt.getText().toString().trim();

                // Check if any of the fields are empty
                if (amount.isEmpty() || code.isEmpty() || date.isEmpty()) {
                    // Show an alert for invalid input
                    Alerts.showAlertDialog(getActivity(), "Invalid auth Code!");
                } else {
                    // Show a completion alert
                    Alerts.showAlertDialog(getActivity(), "Completed!");
                }
            }
        });

        return view;
    }
}