package com.example.absaterminalapp.fragments.tabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.usermanagement.SignIn;
import com.example.absaterminalapp.utils.FragmentUtils;


public class BalanceEnquiryFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_balance_enquiry, container, false);
        // Inflate the layout for this fragment
        Button cancelButton = view.findViewById(R.id.continue_button_in_balance);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new instance of the SignIn fragment
                Bundle bundle = new Bundle();
                bundle.putString("SelectedOption","BALANCE");
                String requiredUser = getString(R.string.supervisor)+getString(R.string.log_in_required);
                bundle.putString("RequiredUser",requiredUser);
                bundle.putString("FragmentToLoad","CardPayment");
                SignIn signIn = new SignIn();
                signIn.setArguments(bundle);
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.balance_container, signIn);
            }
        });
        return view;
    }
}