package com.example.absaterminalapp.fragments.tabs;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.shared.CardPayment;
import com.example.absaterminalapp.fragments.shared.InvoiceNumber;
import com.example.absaterminalapp.usermanagement.SignIn;
import com.example.absaterminalapp.utils.CurrencyFormatterUtil;
import com.example.absaterminalapp.utils.FragmentUtils;


public class RefundFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_refund, container, false);
        TextView paymentLabel = view.findViewById(R.id.refund_label);
        paymentLabel.setText("Refund amount");
        EditText Value = view.findViewById(R.id.refund_value);
        CurrencyFormatterUtil.formatCurrencyInput(Value);
        Button button = view.findViewById(R.id.refund_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = Value.getText().toString().trim();
                if (!inputValue.isEmpty()) {
                    String requiredUser = getString(R.string.supervisor)+getString(R.string.log_in_required);
                    Bundle bundle = new Bundle();
                    bundle.putString("Amount",inputValue);
                    bundle.putString("SelectedOption","REFUND");
                    bundle.putString("RequiredUser",requiredUser);
                    bundle.putString("FragmentToLoad","CardPayment");
                    SignIn signIn = new SignIn();
                    signIn.setArguments(bundle);
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.refund_container, signIn);
                } else {
                    // Display an alert when the EditText is empty
                    Alerts.showAlertDialog(getActivity(), "Enter amount");
                }
            }
        });

        return view;
    }
    }
