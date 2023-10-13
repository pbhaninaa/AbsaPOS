package com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;

public class BatchReports extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_batch_reports, container, false);
        LinearLayout CurrentBatchBtn = view.findViewById(R.id.current_batch_btn);
        LinearLayout SpecificBatchBtn = view.findViewById(R.id.specific_batch_btn);

        CurrentBatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Current Batch Button Clicked!!!");
            }
        });
        SpecificBatchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Specific Butch Button Clicked!!!");
            }
        });

        return view;
    }
}