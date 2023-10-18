package com.example.absaterminalapp.fragments.tabs.debitCheckSubFragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.activities.MainActivity;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.utils.FragmentUtils;

public class Identification extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_debit_check, container, false);

        // Find the "Back" button by its ID
        Button backButton = view.findViewById(R.id.debit_check_back_button);
        // Find the "Continue" button by its ID
        Button continueButton = view.findViewById(R.id.debit_check_continue_button);

        // Find the EditText fields by their IDs
        EditText referenceNumberEditText = view.findViewById(R.id.debit_check_reference_number);
        EditText instalmentAmountEditText = view.findViewById(R.id.debit_check_instalment_amount);
        referenceNumberEditText.setHint("0000000000000");
        instalmentAmountEditText.setHint("1401524086");
        TextView firstLabel = view.findViewById(R.id.debit_check_first_label);
        TextView secondLabel = view.findViewById(R.id.debit_check_second_label);
        firstLabel.setText("Identification Number");
          secondLabel.setText("Account Number");

        // Set an OnClickListener for the "Continue" button
        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                // Get the text from the EditText fields
                String referenceNumber = referenceNumberEditText.getText().toString().trim();
                String instalmentAmount = instalmentAmountEditText.getText().toString().trim();


                if (!referenceNumber.isEmpty() && !instalmentAmount.isEmpty()) {
                    Bundle bundle = getArguments();
                    if (bundle != null) {
                        bundle.putString("identificationNumber", referenceNumber);
                        bundle.putString("accountNumber", instalmentAmount);
                        Contract contract = new Contract();
                        contract.setArguments(bundle);
                        FragmentUtils.replaceFragment(getChildFragmentManager(),R.id.debit_check_container,contract);
                        // To Contract ==========================================================================================================================
                    }
                } else {
                    // Not all fields are populated, display "Fill all the fields" alert
                    Alerts.showAlertDialog(getActivity(), "Fill all the fields");
                }
            }
        });
        // Set an OnClickListener for the "Back" button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the MainActivity
                Intent intent = new Intent(getActivity(), MainActivity.class);

                // Add any flags or extras as needed

                // Start the MainActivity
                startActivity(intent);

                // Finish the current activity (optional)
                getActivity().finish();
            }
        });
        return view;
    }
}
