package com.example.absaterminalapp.fragments.settingsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.ReInstallTerminal;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.ReconfigureComms;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.UserSetup;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.WiFi;
import com.example.absaterminalapp.usermanagement.SignIn;
import com.example.absaterminalapp.utils.FragmentUtils;


public class TerminalOptions extends Fragment {

private LinearLayout ResInstallTerminal, UserSetup,ReconfigureComms,EnableBYOIWifi,ExitApp;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        SignIn signInFragment = new SignIn();
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_terminal_options, container, false);

        ReconfigureComms = view.findViewById(R.id.reconfigure_comms_layout_btn);
        ReconfigureComms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               ReconfigureComms reconfigureComms = new ReconfigureComms();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.terminal_options_container, reconfigureComms);
            }
        });
        ResInstallTerminal = view.findViewById(R.id.re_install_terminal_layout_btn);
        ResInstallTerminal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReInstallTerminal reInstallTerminal = new ReInstallTerminal();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.terminal_options_container, reInstallTerminal);
            }
        });
        UserSetup = view.findViewById(R.id.user_setup_layout_btn);
        UserSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSetup userSetup = new UserSetup();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.terminal_options_container, userSetup);
            }
        });

        EnableBYOIWifi = view.findViewById(R.id.enable_byoi_wifi_layout_btn);
        EnableBYOIWifi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WiFi wiFi = new WiFi();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.terminal_options_container, wiFi);
            }
        });
        ExitApp = view.findViewById(R.id.exit_app_layout_btn);
        ExitApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the string resource value
                String selectedOption = getResources().getString(R.string.exit);
                String requiredUser = getResources().getString(R.string.technician)+getResources().getString(R.string.log_in_required);
                // Put the string in the Bundle
                Bundle bundle = new Bundle();
                bundle.putString("SelectedOption", selectedOption);
                bundle.putString("RequiredUser", requiredUser);
                signInFragment.setArguments(bundle);
                // Replace the current fragment with the SignIn fragment
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.container, signInFragment);
            }
        });

        return view;
    }
}