package com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.reInstall_terminal.MerchantSetup;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.reInstall_terminal.SimSetup;
import com.example.absaterminalapp.utils.FragmentUtils;

public class ReInstallTerminal extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_re_install_terminal, container, false);
        Button ProductionBtn = view.findViewById(R.id.production_btn);
        Button UATBtn = view.findViewById(R.id.uat_btn);

        View.OnClickListener buttonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                SimSetup simSetup = new SimSetup();
                bundle.putString("FirstLabel", "Setup Wizard");
                bundle.putString("SecondLabel", "Configure Comms");
                bundle.putString("FirstButtonText", "Sim1");
                bundle.putString("SecondButtonText", "Sim2");
                simSetup.setArguments(bundle);
                // Replace the current fragment with the SimSetup fragment
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.re_install_terminal_container, simSetup);
            }
        };

        ProductionBtn.setOnClickListener(buttonClickListener);
        UATBtn.setOnClickListener(buttonClickListener);


         Button QueryKeysBtn = view.findViewById(R.id.query_keys_btn);
         QueryKeysBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Printing Query Keys");
            }
        });
         Button FinishBtn = view.findViewById(R.id.re_install_terminal_finish_btn);
        FinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MerchantSetup merchantSetup = new MerchantSetup();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.re_install_terminal_container, merchantSetup);
            }
        });

        return view;

    }
}