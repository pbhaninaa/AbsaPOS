package com.example.absaterminalapp.fragments.settingsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.settingsFragments.merchantOptionsSubFragments.EnableCash;
import com.example.absaterminalapp.fragments.settingsFragments.merchantOptionsSubFragments.EnableCashUp;
import com.example.absaterminalapp.fragments.settingsFragments.merchantOptionsSubFragments.InvoiceNumbers;
import com.example.absaterminalapp.fragments.settingsFragments.merchantOptionsSubFragments.Receipts;
import com.example.absaterminalapp.fragments.settingsFragments.merchantOptionsSubFragments.UpdateParameters;
import com.example.absaterminalapp.utils.FragmentUtils;

public class MerchantOptions extends Fragment {

private LinearLayout Receipts, UpdateParameters, BatchUpload,SwitchSim,InvoiceNumbers,EnableCash,EnableCashUp;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_merchant_options, container, false);
        Receipts = view.findViewById(R.id.receipts_layout_btn);
        UpdateParameters = view.findViewById(R.id.update_parameters_layout_btn);
        BatchUpload = view.findViewById(R.id.batch_upload_layout_btn);
        SwitchSim = view.findViewById(R.id.switch_sim_layout_btn);
        InvoiceNumbers = view.findViewById(R.id.invoice_numbers_layout_btn);
        EnableCash = view.findViewById(R.id.enable_cash_layout_btn);
        EnableCashUp = view.findViewById(R.id.enable_cash_up_layout_btn);

        Receipts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the LinearLayout is clicked
                // For example, you can show a toast message or perform any other action.
                Receipts receipts = new Receipts();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.merchant_options_container, receipts);
            }
        });
        UpdateParameters.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentUtils.replaceFragment(getFragmentManager(), R.id.merchant_options_container,new UpdateParameters());
            }
        });
        BatchUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Alerts.showAlertDialog(getActivity(),"Upload Batch!!");
            }
        });
        SwitchSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alerts.showAlertDialog(getActivity(),"Switch Sim!!");
            }
        });
        InvoiceNumbers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code to be executed when the LinearLayout is clicked
                // For example, you can show a toast message or perform any other action.
                InvoiceNumbers invoiceNumbers = new InvoiceNumbers();

                FragmentUtils.replaceFragment(getFragmentManager(), R.id.merchant_options_container, invoiceNumbers);
            }
        });
        EnableCashUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnableCashUp enableCashUp = new EnableCashUp();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.merchant_options_container, enableCashUp);
            }
        });
        EnableCash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EnableCash enableCash = new EnableCash();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.merchant_options_container, enableCash);
            }
        });
        return view;
    }


}