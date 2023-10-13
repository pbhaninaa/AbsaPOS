package com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptions;
import com.example.absaterminalapp.utils.FragmentUtils;

public class PerformCashUp extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_perform_cash_up, container, false);
        LinearLayout CurrentShiftBtn = view.findViewById(R.id.current_shift_btn);
        LinearLayout PreviousShiftBtn = view.findViewById(R.id.previous_shift_btn);

        View.OnClickListener shiftBtnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Your action to perform when either button is clicked
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.perform_cash_up_container, new ReportingOptions());
            }
        };

        CurrentShiftBtn.setOnClickListener(shiftBtnClickListener);
        PreviousShiftBtn.setOnClickListener(shiftBtnClickListener);

        return view;
    }
}