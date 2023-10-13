package com.example.absaterminalapp.fragments.tabs;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.utils.FragmentUtils;
public class AuthOptionsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_auth_options, container, false);
        // Find the buttons
        Button authOnlyButton = view.findViewById(R.id.authOnlyButton);
        Button incrementalAuthButton = view.findViewById(R.id.incrementalAuthButton);
        Button authCancelButton = view.findViewById(R.id.authCancelButton);
        Button authOverrideButton = view.findViewById(R.id.authOverrideButton);
        authOnlyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showToast(getContext(),"Auth only button clicked!!");
                Bundle bundle = new Bundle();
                bundle.putString("label", "Auth only amount");
                bundle.putString("checkbox", "false");
                PaymentFragment paymentFragment = new PaymentFragment();
                paymentFragment.setArguments(bundle);
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.auth_options_container,paymentFragment);
            }
        });

        incrementalAuthButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("label", "Incremental amount");
                bundle.putString("checkbox", "false");
                PaymentFragment paymentFragment = new PaymentFragment();
                paymentFragment.setArguments(bundle);
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.auth_options_container,paymentFragment);
            }
        });

        authCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("label", "Auth cancel amount");
                bundle.putString("checkbox", "true");
                PaymentFragment paymentFragment = new PaymentFragment();
                paymentFragment.setArguments(bundle);
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.auth_options_container,paymentFragment);
            }
        });

        authOverrideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("label", "Auth Override amount");
                bundle.putString("checkbox", "false");
                PaymentFragment paymentFragment = new PaymentFragment();
                paymentFragment.setArguments(bundle);
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.auth_options_container,paymentFragment);
            }
        });

        return view;
    }

}
