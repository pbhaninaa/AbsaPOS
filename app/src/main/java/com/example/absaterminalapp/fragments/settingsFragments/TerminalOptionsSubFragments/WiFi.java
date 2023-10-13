package com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.utils.FragmentUtils;

public class WiFi extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wi_fi, container, false);
        LinearLayout WifiLayoutBtn = view.findViewById(R.id.wifi_layout_btn);
        WifiLayoutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WifiConfig wifiConfig = new WifiConfig();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.wifi_container, wifiConfig);
            }
        });
        return view;
    }
}