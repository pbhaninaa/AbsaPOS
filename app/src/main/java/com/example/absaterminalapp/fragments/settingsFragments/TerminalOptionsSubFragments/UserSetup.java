package com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptions;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.userSetUpSubFragments.DeleteUser;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.userSetUpSubFragments.ViewAllUsers;
import com.example.absaterminalapp.utils.FragmentUtils;


public class UserSetup extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_usersetup, container, false);
        UserPermissionSinner(view);

        // Find the "Save" button by its ID
        Button saveButton = view.findViewById(R.id.save_button);
        Button deleteButton = view.findViewById(R.id.delete_user_button);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteUser deleteUser = new DeleteUser();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.user_set_up_container, deleteUser);
            }
        });
        Button viewAllUsersButton = view.findViewById(R.id.view_all_users_button);
        viewAllUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewAllUsers viewAllUsers = new ViewAllUsers();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.user_set_up_container, viewAllUsers);
            }
        });
        Button finishButton = view.findViewById(R.id.finish_button);
        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TerminalOptions terminalOptions = new TerminalOptions();
                FragmentUtils.replaceFragment(getFragmentManager(), R.id.user_set_up_container, terminalOptions);
            }
        });
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the values from EditText fields
                EditText userNameEditText = view.findViewById(R.id.user_name_edit_text);
                EditText userNumberEditText = view.findViewById(R.id.user_number_edit_text);
                EditText pinEditText = view.findViewById(R.id.pin_edit_text);
                EditText confirmPinEditText = view.findViewById(R.id.confirm_pin_edit_text);

                // Get the selected item from the Spinner
                Spinner userRankSpinner = view.findViewById(R.id.user_rank_spinner);
                String selectedUserRank = userRankSpinner.getSelectedItem().toString();

                // Check if any of the fields are empty or Spinner has the default value
                if (TextUtils.isEmpty(userNameEditText.getText())
                        || TextUtils.isEmpty(userNumberEditText.getText())
                        || TextUtils.isEmpty(pinEditText.getText())
                        || TextUtils.isEmpty(confirmPinEditText.getText())
                        || selectedUserRank.equals("Select User Permission")) {
                    // Show an alert telling the user to fill all fields
                    Alerts.showAlertDialog(getActivity(),"Please fill all fields.");
                } else {
                    // All fields are filled, show a success message
                    Alerts.showAlertDialog(getActivity(),"User saved.");
                }
            }
        });

        return view;
    }



    public void UserPermissionSinner(View view){
        Spinner userRankSpinner = view.findViewById(R.id.user_rank_spinner);
// Create an ArrayAdapter and set it as the adapter for the Spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(), R.array.user_ranks, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        userRankSpinner.setAdapter(adapter);

// Set the default selection to "Select User Permission"
        userRankSpinner.setSelection(0);
    }
}