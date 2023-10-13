package com.example.absaterminalapp.usermanagement;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.utils.FragmentUtils;


public class SignIn extends Fragment {

    private String selectedOption;
    private String requiredUser;
    private String fragmentToLoad;
    private EditText UserId, UserPin;
    private Bundle bundle;
    private Fragment targetFragment; // To hold the reference to the PurchaseFragment

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sign_in, container, false);
        Button loginButton = view.findViewById(R.id.login_button);
        UserId = view.findViewById(R.id.user_id);
        UserPin = view.findViewById(R.id.user_pin);

        // Retrieve the values from the Bundle
         bundle = getArguments();
        if (bundle != null) {
            selectedOption = bundle.getString("SelectedOption");
            requiredUser = bundle.getString("RequiredUser");
            fragmentToLoad = bundle.getString("FragmentToLoad");

            // Now you can use these values as needed
            TextView selectedOptionTextView = view.findViewById(R.id.selected_option);
            selectedOptionTextView.setText(selectedOption);
            TextView requiredUserTextView = view.findViewById(R.id.required_user);
            requiredUserTextView.setText(requiredUser);
            // Set TextView values here if needed
        }
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String supervisor = getString(R.string.supervisor);
                String manager = getString(R.string.manager);
                String technician = getString(R.string.technician);


                if (FragmentUtils.extractFirstWord(requiredUser).equals(supervisor)) {
                    if (UserId.getText().toString().equals("1") && UserPin.getText().toString().equals("12345")) {
                        Fragment newFragment = FragmentUtils.FragmentFactory(fragmentToLoad);
                        newFragment.setArguments(bundle);
                        FragmentUtils.replaceFragment(getFragmentManager(),R.id.sign_in_container,newFragment);
                    } else {
                        Alerts.showAlertDialog(getActivity(), "Login Failed!!!");
                    }
                } else if (FragmentUtils.extractFirstWord(requiredUser).equals(manager)) {
                    if (UserId.getText().toString().equals("2") && UserPin.getText().toString().equals("12345")) {
                        Fragment newFragment = FragmentUtils.FragmentFactory(fragmentToLoad);
                        newFragment.setArguments(bundle);
                        FragmentUtils.replaceFragment(getFragmentManager(),R.id.sign_in_container,newFragment);
                    } else {
                        Alerts.showAlertDialog(getActivity(), "Login Failed!!!");
                    }
                }
                else if (FragmentUtils.extractFirstWord(requiredUser).equals(technician)) {
                    if (UserId.getText().toString().equals("3") && UserPin.getText().toString().equals("12345")) {
                        Fragment newFragment = FragmentUtils.FragmentFactory(fragmentToLoad);
                        newFragment.setArguments(bundle);
                        FragmentUtils.replaceFragment(getFragmentManager(),R.id.sign_in_container,newFragment);

                    } else {
                        Alerts.showAlertDialog(getActivity(), "Login Failed!!!");
                    }
                }else {
                    Alerts.showAlertDialog(getActivity(), "Unknown user");
                }
            }
        });
        return view;
    }
}