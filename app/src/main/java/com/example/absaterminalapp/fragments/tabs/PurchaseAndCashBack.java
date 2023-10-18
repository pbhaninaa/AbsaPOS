package com.example.absaterminalapp.fragments.tabs;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.shared.CardPayment;
import com.example.absaterminalapp.fragments.shared.InvoiceNumber;
import com.example.absaterminalapp.utils.CurrencyFormatterUtil;
import com.example.absaterminalapp.utils.FragmentUtils;


public class PurchaseAndCashBack extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_paymentand_cash, container, false);
        TextView paymentLabel = view.findViewById(R.id.payment_and_cash_label);
        paymentLabel.setText("Payment reversal amount");
        EditText Value = view.findViewById(R.id.payment_and_cash_value);
        CurrencyFormatterUtil.formatCurrencyInput(Value);
        Button button = view.findViewById(R.id.payment_and_cash_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = Value.getText().toString().trim();
                if (!inputValue.isEmpty()) {
                    // Input is not empty, navigate to CardPayment fragment
                    Bundle bundle = new Bundle();
                    bundle.putString("Amount",inputValue);
                    CardPayment cardPayment = new CardPayment();
                    cardPayment.setArguments(bundle);
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.payment_and_cash_container, cardPayment);
                } else {
                    // Display an alert when the EditText is empty
                    Alerts.showAlertDialog(getActivity(), "Enter amount");
                }
            }
        });

        return view;
    }
}