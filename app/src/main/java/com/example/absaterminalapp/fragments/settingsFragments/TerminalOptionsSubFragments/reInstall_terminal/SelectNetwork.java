package com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.reInstall_terminal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptions;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.ReconfigureComms;
import com.example.absaterminalapp.utils.FragmentUtils;


public class SelectNetwork extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sim_setup, container, false);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String FirstLabelText = bundle.getString("FirstLabel");
            String   SecondLabelText = bundle.getString("SecondLabel");
            String    FirstButtonText = bundle.getString("FirstButtonText");
            String    SecondButtonText = bundle.getString("SecondButtonText");

            // Now you can use these values as needed
            TextView FirstLabel = view.findViewById(R.id.first_label_in_Sim_set_up);
            FirstLabel.setText(FirstLabelText);
            TextView SecondLabel = view.findViewById(R.id.second_label_in_Sim_set_up);
            SecondLabel.setText(SecondLabelText);

            Button MTN = view.findViewById(R.id.first_button_in_Sim_set_up);
            MTN.setText(FirstButtonText);
            Button Vodacom = view.findViewById(R.id.second_button_in_Sim_set_up);
            Vodacom.setText(SecondButtonText);
            MTN.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Alerts.showAlertDialog(getActivity(),"MTN is selected!!!");
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.re_install_terminal_container, new ReconfigureComms());
                }
            });
            Vodacom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Alerts.showAlertDialog(getActivity(),"Vodacom is selected!!!");
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.re_install_terminal_container, new ReconfigureComms());
                }
            });


        }
        return view;
    }
}