package com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.utils.FragmentUtils;

public class EmvParameters extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_emv_parameters, container, false);
        LinearLayout Contact = view.findViewById(R.id.emv_parameters_parameters_btn);
        LinearLayout Contactless = view.findViewById(R.id.emv_parameters_comms_btn);
        Contact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Printing contact parameters");
            }
        });
        Contactless.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Printing contactless parameters");
            }
        });
        return view;
    }
}