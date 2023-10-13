package com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.userSetUpSubFragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptionsSubFragments.UserSetup;
import com.example.absaterminalapp.utils.FragmentUtils;

public class DeleteUser extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_delete_user, container, false);

        // Find the "Delete" button by its ID
        Button deleteButton = view.findViewById(R.id.delete_button);
        Button cancelButton = view.findViewById(R.id.cancel_button);

        // Find the EditText for "User Number" by its ID
        final EditText userNumberEditText = view.findViewById(R.id.user_number_to_be_deleted);

        // Set a click listener for the "Delete" button
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the text from the EditText
                String userNumber = userNumberEditText.getText().toString().trim();

                if (userNumber.isEmpty()) {
                    // If the EditText is empty, show an alert saying "Which user you want to delete"
                   Alerts.showAlertDialog(getActivity(),"Unknown User!!");
                    UserSetup userSetup = new UserSetup();
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.delete_user_container, userSetup);
                } else {
                    // If the EditText is not empty, show a success message "User deleted!!!"
                    Alerts.showAlertDialog(getActivity(),"User deleted!!!");
                    UserSetup userSetup = new UserSetup();
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.delete_user_container, userSetup);
                    // Clear the EditText
                    userNumberEditText.getText().clear();
                }
            }
        });
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    UserSetup userSetup = new UserSetup();
                    FragmentUtils.replaceFragment(getFragmentManager(), R.id.delete_user_container, userSetup);
            }
        });

        return view;
    }

}
