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
import com.example.absaterminalapp.utils.FragmentUtils;
public class PurchaseFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_payment, container, false);
        TextView paymentLabel = view.findViewById(R.id.payment_label);
        paymentLabel.setText("Purchase amount");
        LinearLayout terminalInformation = view.findViewById(R.id.terminal_information);
        // Set its visibility to visible
        terminalInformation.setVisibility(View.VISIBLE);
        EditText Value = view.findViewById(R.id.payment_value);
        Button button = view.findViewById(R.id.payment_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputValue = Value.getText().toString().trim();
                if (!inputValue.isEmpty()) {
                    // Input is not empty, navigate to CardPayment fragment
                    Bundle bundle = new Bundle();
                    bundle.putString("Amount",inputValue);
                    CardPayment cardPayment = new CardPayment();
                    cardPayment.setArguments(bundle);
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.payment_container, cardPayment);
                } else {
                    // Display an alert when the EditText is empty
                    Alerts.showAlertDialog(getActivity(), "Enter amount");
                }
            }
        });

        return view;
    }
}

//public class PurchaseFragment extends Fragment {
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//  View view = inflater.inflate(R.layout.fragment_payment, container, false);
//        TextView paymentLabel = view.findViewById(R.id.payment_label);
//        paymentLabel.setText("Purchase amount");
//        // Find the LinearLayout view by its id
//        LinearLayout terminalInformation = view.findViewById(R.id.terminal_information);
//        // Set its visibility to visible
//        terminalInformation.setVisibility(View.VISIBLE);
//        EditText Value = view.findViewById(R.id.payment_value);
//        Button button = view.findViewById(R.id.payment_button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if (!Value.getText().toString().isEmpty()) {
//                    View mainView = inflater.inflate(R.layout.activity_main, container, false);
//                    TableLayout tabLayout = mainView.findViewById(R.id.tabLayout);
//                     tabLayout.setVisibility(View.GONE);
//                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.p,new CardPayment());
//
//                } else {
//                    // Display a Toast message when the EditText is empty
//                    Alerts.showAlertDialog(getActivity(),"Enter amount");
//                }
//            }
//        });
//
//        return  view;
//    }
//}