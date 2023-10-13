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


public class Receipts extends Fragment {
  private LinearLayout LastReceipt, SpecificReceipt;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view = inflater.inflate(R.layout.fragment_reciepts, container, false);
        // Retrieve the values from the Bundle

        LastReceipt = view.findViewById(R.id.first_layout_btn);
        SpecificReceipt = view.findViewById(R.id.second_layout_btn);
        LastReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Printing last Receipt");
            }
        });
        SpecificReceipt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.receipts_container, new SpecificReceipt());
            }
        });
        return view;
    }
}