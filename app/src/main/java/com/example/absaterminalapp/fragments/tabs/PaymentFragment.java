package com.example.absaterminalapp.fragments.tabs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.shared.CardPayment;
import com.example.absaterminalapp.fragments.tabs.authOptionsSubFragments.IncrementalAuth;
import com.example.absaterminalapp.usermanagement.SignIn;
import com.example.absaterminalapp.utils.FragmentUtils;

public class PaymentFragment extends Fragment {

    private String label = "";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        TextView paymentLabel = view.findViewById(R.id.payment_label);
        paymentLabel.setText("Purchase amount");
        EditText valueEditText = view.findViewById(R.id.payment_value);

        Bundle bundle = getArguments();
        if (bundle != null) {
            label = bundle.getString("label");
            String checkboxValue = bundle.getString("checkbox");
            String editTextHint = bundle.getString("hint");
            paymentLabel.setText(label);
            valueEditText.setHint(editTextHint);
            CheckBox checkBox = view.findViewById(R.id.payment_checkbox);
            LinearLayout RRNLayout = view.findViewById(R.id.original_rrn_layout);
            if ("true".equals(checkboxValue)) {
                checkBox.setVisibility(View.VISIBLE);
                checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked) {
                            RRNLayout.setVisibility(View.VISIBLE);
                        } else {
                            RRNLayout.setVisibility(View.GONE);
                        }
                    }
                });
            } else {
                checkBox.setVisibility(View.GONE);
            }
        }

        Button button = view.findViewById(R.id.payment_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = valueEditText.getText().toString().trim();
                if (!inputValue.isEmpty()) {
                    // Input is not empty, navigate to the appropriate fragment
                    if (label.equals("Incremental amount")|| label.equals("Auth Override amount")) {
                        FragmentUtils.replaceFragment(getFragmentManager(), R.id.payment_container, new IncrementalAuth());
                    } else {
                        Bundle bundle = new Bundle();
                        bundle.putString("Amount",inputValue);
                        bundle.putString("SelectedOption","PAYMENT");
                        String requiredUser = getString(R.string.supervisor)+getString(R.string.log_in_required);
                        bundle.putString("RequiredUser",requiredUser);
                        bundle.putString("FragmentToLoad","CardPayment");
                        SignIn signIn = new SignIn();
                        signIn.setArguments(bundle);
                        FragmentUtils.replaceFragment(getFragmentManager(), R.id.payment_container, signIn);
                    }
                } else {
                    // Display an alert when the EditText is empty
                    Alerts.showAlertDialog(getActivity(), "Enter amount");
                }
            }
        });

        return view;
    }
}
