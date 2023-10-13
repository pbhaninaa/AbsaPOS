package com.example.absaterminalapp.fragments.shared;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;

public class Months extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_months, container, false);
        // in this bundle we have Card information, Invoice Number and amount to be payed!
        Bundle bundle = getArguments();
        LinearLayout _3moths = view.findViewById(R.id._3_months);
        LinearLayout _6moths = view.findViewById(R.id._6_months);
        LinearLayout _12moths = view.findViewById(R.id._12_months);
        LinearLayout _18moths = view.findViewById(R.id._18_months);
        LinearLayout _24moths = view.findViewById(R.id._24_months);
        LinearLayout _36moths = view.findViewById(R.id._36_months);
        LinearLayout _48moths = view.findViewById(R.id._48_months);
        LinearLayout _60moths = view.findViewById(R.id._60_months);
        _3moths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Alerts.showAlertDialog(getActivity(),"To be implemented!!!");
            }
        });

        return view;

    }
}