package com.example.absaterminalapp.fragments.settingsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments.BatchReports;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments.CardParameters;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments.EmvParameters;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments.PerformCashUp;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments.TerminalSettings;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments.TypeApproval;
import com.example.absaterminalapp.fragments.settingsFragments.merchantOptionsSubFragments.UpdateParameters;
import com.example.absaterminalapp.utils.FragmentUtils;

public class ReportingOptions extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_reporting_options, container, false);
        LinearLayout BatchReportsBtn = view.findViewById(R.id.batch_reports_layout_btn);
        LinearLayout TerminalSettingsBtn = view.findViewById(R.id.terminal_settings_layout_btn);
        LinearLayout EmvParametersBtn = view.findViewById(R.id.emv_parameters_layout_btn);
        LinearLayout CardParametersBtn = view.findViewById(R.id.card_parameters_layout_btn);
        LinearLayout TypeApprovalBtn = view.findViewById(R.id.type_approval_layout_btn);
        LinearLayout PerformCashUpBtn = view.findViewById(R.id.perform_cash_up_layout_btn);
        BatchReportsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.reporting_options_container,new BatchReports());
            }
        });
        TerminalSettingsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.reporting_options_container,new TerminalSettings());
            }
        });
        EmvParametersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.reporting_options_container,new EmvParameters());
            }
        });
        CardParametersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.reporting_options_container,new CardParameters());
            }
        });
        TypeApprovalBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.reporting_options_container,new TypeApproval());
            }
        });
        PerformCashUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.reporting_options_container,new PerformCashUp());
            }
        });

        return view;
    }
}