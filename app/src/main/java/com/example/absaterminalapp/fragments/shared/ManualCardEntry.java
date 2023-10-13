package com.example.absaterminalapp.fragments.shared;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.tabs.PurchaseFragment;
import com.example.absaterminalapp.utils.FragmentUtils;
import com.google.android.material.tabs.TabLayout;

public class ManualCardEntry extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_manual_card_entry, container, false);

        EditText cardNumberEditText = view.findViewById(R.id.card_number);
        EditText cvvEditText = view.findViewById(R.id.cvv);
        EditText expiryDateEditText = view.findViewById(R.id.expiry_date);

        Button confirmButton = view.findViewById(R.id.manual_card_confirm_btn);
        Button cancelButton = view.findViewById(R.id.manual_card_cancel_btn);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get text from the EditText fields
                String cardNumber = cardNumberEditText.getText().toString().trim();
                String cvv = cvvEditText.getText().toString().trim();
                String expiryDate = expiryDateEditText.getText().toString().trim();

                // Check if all fields are filled
                if (FragmentUtils.isValidCardNumber(getActivity(),cardNumber,cvv)) {

                    Bundle bundle = getArguments();
                    // adding the values of this fragment to bundle
                    bundle.putString("Card Number", cardNumber);
                    bundle.putString("CVV", cvv);
                    bundle.putString("Expiry Date", expiryDate);
                    if (bundle.containsKey("Transaction")) {
                        String transactionNumber = bundle.getString("Transaction");
                        if (transactionNumber.equals("0")) {
                            Alerts.showAlertDialog(getActivity(), "No Transaction Found!!");
                            FragmentUtils.replaceFragment(getFragmentManager(), R.id.manual_card_entry_container, new PurchaseFragment());
                        }
                    } else {
                        // getting the entered amount fro the bundle that was populated from the last fragment
                        String Amount = bundle.getString("Amount");
                        double amount = Double.parseDouble(Amount);
                        if (amount > 500) {
                            PaymentType paymentType = new PaymentType();
                            paymentType.setArguments(bundle);
                            FragmentUtils.replaceFragment(getFragmentManager(), R.id.manual_card_entry_container, paymentType);
                        } else {
                            Alerts.showAlertDialog(getActivity(), "Payment Continues!!!");
                        }
                    }
                }
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.manual_card_entry_container, new PurchaseFragment());
            }
        });

        return view;
    }
}
