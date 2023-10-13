package com.example.absaterminalapp.fragments.tabs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.absaterminalapp.R;

import com.example.absaterminalapp.fragments.shared.CardPayment;

import com.example.absaterminalapp.usermanagement.SignIn;
import com.example.absaterminalapp.utils.FragmentUtils;

public class CancelEnquiryFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cancel_enquiry, container, false);
        Button cancelButton = view.findViewById(R.id.continue_button_in_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String TransactionNumber ="0";
                Bundle bundle = new Bundle();
                String empty = getString(R.string.empty);
                bundle.putString("Amount", empty);
                bundle.putString("Transaction",TransactionNumber);
                bundle.putString("SelectedOption","CANCEL");
                String requiredUser = getString(R.string.supervisor)+getString(R.string.log_in_required);
                bundle.putString("RequiredUser",requiredUser);
                bundle.putString("FragmentToLoad","CardPayment");
                SignIn signIn = new SignIn();
                signIn.setArguments(bundle);
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.cancel_container, signIn);
            }});

        return view;
    }
}
