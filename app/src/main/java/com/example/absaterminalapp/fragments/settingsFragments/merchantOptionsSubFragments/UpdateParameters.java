package com.example.absaterminalapp.fragments.settingsFragments.merchantOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.tabs.PaymentFragment;
import com.example.absaterminalapp.utils.FragmentUtils;


public class UpdateParameters extends Fragment {

    private LinearLayout Reload, Partial;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_update_parameters, container, false);
        // Retrieve the values from the Bundle
        Bundle bundle = getArguments();
       LinearLayout reloadBtn = view.findViewById(R.id.update_parameters_first_layout_btn);
       LinearLayout partialBtn = view.findViewById(R.id.update_parameters_second_layout_btn);
        reloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Reload Button Clicked!!!");
            }
        });
        partialBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Partial Button clicked!!!");
            }
        });
        return view;
    }
}