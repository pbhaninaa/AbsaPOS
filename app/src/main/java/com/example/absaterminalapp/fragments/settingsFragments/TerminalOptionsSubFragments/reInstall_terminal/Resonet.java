package com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.reInstall_terminal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.utils.FragmentUtils;

public class Resonet extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sim_setup, container, false);

        TextView SecondButton = view.findViewById(R.id.second_button_in_Sim_set_up);
        SecondButton.setVisibility(view.GONE);


        Bundle bundle = getArguments();
        if (bundle != null) {
            String FirstLabelText = bundle.getString("FirstLabel");
            String   SecondLabelText = bundle.getString("SecondLabel");
            String    FirstButtonText = bundle.getString("FirstButtonText");


            // Now you can use these values as needed
            TextView FirstLabel = view.findViewById(R.id.first_label_in_Sim_set_up);
            FirstLabel.setText(FirstLabelText);
            TextView SecondLabel = view.findViewById(R.id.second_label_in_Sim_set_up);
            SecondLabel.setText(SecondLabelText);

            TextView FirstButton = view.findViewById(R.id.first_button_in_Sim_set_up);
            FirstButton.setText(FirstButtonText);

            FirstButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    SelectNetwork selectNetwork = new SelectNetwork();
                    bundle.putString("FirstLabel", "Setup Wizard");
                    bundle.putString("SecondLabel", SecondLabelText);
                    bundle.putString("FirstButtonText", "MTN");
                    bundle.putString("SecondButtonText", "Vodacom");
                    selectNetwork.setArguments(bundle);
                    // Replace the current fragment with the Resonet fragment
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.sim_set_up_container, selectNetwork);
                }
            });

        }
        return view;
    }
}