package com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.userSetUpSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.UserSetup;
import com.example.absaterminalapp.utils.FragmentUtils;

public class ViewAllUsers extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_view_all_users, container, false);
        Button CloseButton = view.findViewById(R.id.closeBtn);
        CloseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserSetup userSetup = new UserSetup();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.view_all_users_container, userSetup);
            }
        });
        return view;
    }
}