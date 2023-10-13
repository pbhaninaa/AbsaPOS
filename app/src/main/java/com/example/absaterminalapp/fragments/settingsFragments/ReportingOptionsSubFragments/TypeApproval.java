package com.example.absaterminalapp.fragments.settingsFragments.ReportingOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptions;
import com.example.absaterminalapp.utils.FragmentUtils;
public class TypeApproval extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_type_approval, container, false);
        Button close = view.findViewById(R.id.type_approval_close_btn);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.type_approval_container,new ReportingOptions());
            }
        });
        return view;
    }
}