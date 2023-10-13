package com.example.absaterminalapp.fragments.settingsFragments.merchantOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;

public class EnableCash extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_enable_cash, container, false);
        LinearLayout enableBtn = view.findViewById(R.id.enable_cash_enable_btn);
        LinearLayout disableBtn = view.findViewById(R.id.enable_cash_disable_btn);
        enableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Enabling!!!");
            }
        });
        disableBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Disable!!!");
            }
        });
        return view;
    }
}