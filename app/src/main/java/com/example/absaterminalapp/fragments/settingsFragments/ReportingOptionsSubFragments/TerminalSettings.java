package com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;

public class TerminalSettings extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_terminal_settings, container, false);
        LinearLayout ParametersBtn = view.findViewById(R.id.terminal_settings_parameters_btn);
        LinearLayout CommsBtn = view.findViewById(R.id.terminal_settings_comms_btn);
        ParametersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Printing parameters");
            }
        });
        CommsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Printing Comms parameters");
            }
        });
        return view;
    }
}