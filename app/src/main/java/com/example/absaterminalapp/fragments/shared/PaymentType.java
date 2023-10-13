package com.example.absaterminalapp.fragments.shared;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.utils.FragmentUtils;


public class PaymentType extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_payment_type, container, false);
        LinearLayout StraightPaymentBtn = view.findViewById(R.id.straight_payment_type_btn);
        Bundle bundle = getArguments();
        StraightPaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerts.showAlertDialog(getActivity(), "Payment Continues!!!");
            }
        });
        LinearLayout BudgetPaymentBtn = view.findViewById(R.id.budget_payment_type_btn);
        BudgetPaymentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Months months = new Months();
                months.setArguments(bundle);
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.manual_card_entry_container, months);
            }
        });
        return view;

    }
}