package com.example.absaterminalapp.fragments.shared;

import android.content.Intent;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.activities.MainActivity;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.tabs.PurchaseFragment;
import com.example.absaterminalapp.utils.FragmentUtils;

public class CardPayment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_card_payment, container, false);
        Button ManualCardEntryBtn = view.findViewById(R.id.manual_card_entry_btn);
        Button Cancel = view.findViewById(R.id.cancel_payment_btn);
        Bundle bundle = getArguments();
        if (bundle != null) {
            String TotalAmount = bundle.getString("Amount");
            // Check if TotalAmount is not empty
            if (TotalAmount != null && !TotalAmount.isEmpty()) {
                TextView label = view.findViewById(R.id.amount_to_pay);
                label.setText("Total amount: R" + TotalAmount);
            }
        }
        ManualCardEntryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ManualCardEntry manualCardEntryBtn = new ManualCardEntry();
                manualCardEntryBtn.setArguments(bundle);
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.card_payment_container, manualCardEntryBtn);
            }
        }); Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create an Intent to start the MainActivity
              FragmentUtils.restartApp(getContext());
            }
        });
        //================================================================================
       FragmentUtils.TextFlickerAnimation(view,getContext());
        return view;
    }
}