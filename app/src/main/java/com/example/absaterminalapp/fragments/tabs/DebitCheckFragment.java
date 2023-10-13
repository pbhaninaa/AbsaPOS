package com.example.absaterminalapp.fragments.tabs;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.absaterminalapp.R;
import com.example.absaterminalapp.activities.MainActivity;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.tabs.debitCheckSubFragments.Contract;
import com.example.absaterminalapp.fragments.tabs.debitCheckSubFragments.Identification;
import com.example.absaterminalapp.utils.FragmentUtils;

public class DebitCheckFragment extends Fragment {

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


        // Set an OnClickListener for the "Continue" button
        continueButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                // Get the text from the EditText fields
                String referenceNumber = referenceNumberEditText.getText().toString().trim();
                String instalmentAmount = instalmentAmountEditText.getText().toString().trim();

                if (!referenceNumber.isEmpty() && !instalmentAmount.isEmpty()) {
                    bundle.putString("Amount",instalmentAmount);
                    bundle.putString("referenceNumber",referenceNumber);
                    bundle.putString("installmentAmount",instalmentAmount);
                    Identification identification = new Identification();
                    identification.setArguments(bundle);
                    FragmentUtils.replaceFragment(getChildFragmentManager(),R.id.debit_check_container,identification);
                   // To Identification =======================================================================================
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
             FragmentUtils.Refresh(getActivity());
            }
        });
       return view;
    }
}
