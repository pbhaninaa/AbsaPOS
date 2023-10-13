package com.example.absaterminalapp.fragments.tabs;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.shared.InvoiceNumber;
import com.example.absaterminalapp.utils.FragmentUtils;

public class Rapid_PaymentFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rapid_payments, container, false);
        TextView paymentLabel = view.findViewById(R.id.rapid_payment_label);
        paymentLabel.setText("Rapid payment amount");
        EditText Value = view.findViewById(R.id.rapid_payment_value);
        Button button = view.findViewById(R.id.rapid_payment_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = Value.getText().toString().trim();
                if (!inputValue.isEmpty()) {
                    Alerts.showAlertDialog(getActivity(),"Rapid payment");
                } else {
                    // Display an alert when the EditText is empty
                    Alerts.showAlertDialog(getActivity(), "Enter amount");
                }
            }
        });

        return view;
    }
}
