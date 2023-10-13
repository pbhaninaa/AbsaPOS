package com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.reInstall_terminal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.utils.FragmentUtils;


public class SimSetup extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View view =inflater.inflate(R.layout.fragment_sim_setup, container, false);
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

            Button FirstButton = view.findViewById(R.id.first_button_in_Sim_set_up);
            FirstButton.setText(FirstButtonText);
            Button SecondButton = view.findViewById(R.id.second_button_in_Sim_set_up);
            SecondButton.setText(SecondButtonText);

            View.OnClickListener buttonClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    Resonet resonet = new Resonet();
                    bundle.putString("FirstLabel", "Setup Wizard");

                    // Get the text of the clicked button
                    String buttonText = ((Button) v).getText().toString();
                    bundle.putString("SecondLabel", buttonText);

                    bundle.putString("FirstButtonText", "Resonet");
                    resonet.setArguments(bundle);
                    // Replace the current fragment with the Resonet fragment
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.re_install_terminal_container, resonet);
                }
            };

            FirstButton.setOnClickListener(buttonClickListener);
            SecondButton.setOnClickListener(buttonClickListener);


        }

        return view;
    }
}