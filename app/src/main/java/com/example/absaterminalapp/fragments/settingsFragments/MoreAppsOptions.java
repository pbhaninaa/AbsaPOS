package com.example.absaterminalapp.fragments.settingsFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;


public class MoreAppsOptions extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_more_apps_options, container, false);
        ImageButton MoreOptions = view.findViewById(R.id.more_apps_options_btn);

        MoreOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create and show an alert dialog
                Alerts.showAlertDialog(getActivity(),"Button Clicked!!!");
                Toast.makeText(getActivity(), "Toast message after AlertDialog", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}