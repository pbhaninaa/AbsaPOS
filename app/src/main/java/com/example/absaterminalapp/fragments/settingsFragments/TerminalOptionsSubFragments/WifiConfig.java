package com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.utils.FragmentUtils;


public class WifiConfig extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_wifi_config, container, false);
        Button Activate = view.findViewById(R.id.activate_wifi_btn);
        Activate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            FragmentUtils.replaceFragment(getChildFragmentManager(),R.id.wifi_config_container,new WiFi());
            }
        });
        Button DeActivate = view.findViewById(R.id.de_activate_wifi_btn);
        DeActivate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentUtils.replaceFragment(getChildFragmentManager(),R.id.wifi_config_container,new WiFi());
            }
        });
        Button WifiConfig = view.findViewById(R.id.configure_wifi_btn);
        WifiConfig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

        Alerts.showAlertDialog(getActivity(),"This Will take us to phone settings to configure wifi!!!");
            }
        });
        return view;
    }
}