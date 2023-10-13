package com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.reInstall_terminal;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.ReInstallTerminal;
import com.example.absaterminalapp.utils.FragmentUtils;

public class MerchantSetup extends Fragment {

    private EditText agentIdEditText;
    private EditText merchantNumberEditText;
    private EditText terminalNumberEditText;
    private EditText confirmPinEditText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_merchant_setup, container, false);

        // Initialize EditText fields
        agentIdEditText = view.findViewById(R.id.agent_id_name_edit_text);
        merchantNumberEditText = view.findViewById(R.id.merchant_number_edit_text);
        terminalNumberEditText = view.findViewById(R.id.terminal_number_edit_text);
        confirmPinEditText = view.findViewById(R.id.confirm_pin_edit_text);

        Button continueButton = view.findViewById(R.id.merchant_setup_button);
        Button configureCommsButton = view.findViewById(R.id.reconfigure_button);

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateFields()) {
                    // All fields are filled, show "Merchant saved!!!" alert
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.merchant_setup_container, new ReInstallTerminal());
                } else {
                    // At least one field is empty, show "Fill all the fields" alert
                    Alerts.showAlertDialog(getActivity(),"Fill all the fields");
                }
            }
        });

        configureCommsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReInstallTerminal reInstallTerminal = new ReInstallTerminal();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.merchant_setup_container, reInstallTerminal);
            }
        });

        return view;
    }

    private boolean validateFields() {
        String agentId = agentIdEditText.getText().toString().trim();
        String merchantNumber = merchantNumberEditText.getText().toString().trim();
        String terminalNumber = terminalNumberEditText.getText().toString().trim();
        String confirmPin = confirmPinEditText.getText().toString().trim();

        // Check if any of the fields is empty
        return !agentId.isEmpty() && !merchantNumber.isEmpty() && !terminalNumber.isEmpty() && !confirmPin.isEmpty();
    }


}
