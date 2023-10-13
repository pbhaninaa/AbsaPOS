package com.example.absaterminalapp.fragments.shared;

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
import com.example.absaterminalapp.utils.FragmentUtils;


public class InvoiceNumber extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        TextView paymentLabel = view.findViewById(R.id.payment_label);
        paymentLabel.setText("Invoice Number");
        // Find the LinearLayout view by its id
        LinearLayout terminalInformation = view.findViewById(R.id.terminal_information);

        EditText Value = view.findViewById(R.id.payment_value);
        Value.setHint(R.string.empty);
        Button button = view.findViewById(R.id.payment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!Value.getText().toString().isEmpty()) {
                    // Perform an action when the EditText is not empty
                     Bundle bundle = getArguments();
                    if (bundle != null) {
                        String Continue = bundle.getString("continue?");
                        boolean itsTheEnd = Boolean.parseBoolean(Continue);
                        if(!itsTheEnd){
                           // The bundle contains the rapid payment amount to be used here
                           Alerts.showAlertDialog(getActivity(),"Rapid payment");
                        }else{
                        String inputValue = Value.getText().toString().trim();
                        bundle.putString("Invoice Number",inputValue);
                        CardPayment cardPayment = new CardPayment();
                        cardPayment.setArguments(bundle);
                        FragmentUtils.replaceFragment(getFragmentManager(), R.id.payment_container,cardPayment);}
                    }


                } else {
                    // Display a Toast message when the EditText is empty
                    Alerts .showAlertDialog(getActivity(),"Enter invoice number");
                }
            }
        });



        return  view;
    }
}