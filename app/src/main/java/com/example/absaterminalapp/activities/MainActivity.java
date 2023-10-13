package com.example.absaterminalapp.activities;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.adapters.MyPagerAdapter;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.settingsFragments.MerchantOptions;
import com.example.absaterminalapp.fragments.settingsFragments.MoreAppsOptions;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptions;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptions;
import com.example.absaterminalapp.usermanagement.SignIn;
import com.example.absaterminalapp.utils.FragmentUtils;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View contentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find views
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        contentLayout = findViewById(R.id.contentLayoutContainer);
// ===================================== Tab related =======================================


        // Create an instance of your custom PagerAdapter (you'll need to create this class)
        FragmentManager fragmentManager = getSupportFragmentManager();
        MyPagerAdapter pagerAdapter = new MyPagerAdapter(fragmentManager);

        // Set the adapter to the ViewPager
        viewPager.setAdapter(pagerAdapter);
        SignIn signInFragment = new SignIn();
        // Link the TabLayout and ViewPager together
        tabLayout.setupWithViewPager(viewPager);

        // Set the first tab as selected by default
        TabLayout.Tab firstTab = tabLayout.getTabAt(0);
        if (tabLayout != null && viewPager != null) {
            tabLayout.setupWithViewPager(viewPager);
        }
// =================================== Toggling between Tabs and setting ===================================
        // Set click listeners for toolbar buttons
        ImageButton leftButton = findViewById(R.id.leftButton);
        Button rightButton = findViewById(R.id.rightButton);

        View.OnClickListener toggleClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Toggle visibility of the TabLayout and content layout
                if (contentLayout.getVisibility() == View.VISIBLE) {
                    contentLayout.setVisibility(View.GONE);
                    tabLayout.setVisibility(View.VISIBLE);
                    viewPager.setVisibility(view.VISIBLE);
                    // Change the text of rightButton to "Back" when contentLayout is visible
                    rightButton.setText(R.string.settings);
// ===============================Code for restarting the app =================================================
                  if (contentLayout.getVisibility() == View.GONE) {
                      // Restart the application by recreating the main activity
                      FragmentUtils.restartApp(getApplicationContext()); // Finish the current instance of the activity
                  }
// ===============================================================================================================
                } else {
                    contentLayout.setVisibility(View.VISIBLE);
                    tabLayout.setVisibility(View.GONE);
                    viewPager.setVisibility(view.GONE);
                    // Change the text of rightButton to "Settings" when contentLayout is not visible
                    rightButton.setText(R.string.back);
                }
            }
        };
        leftButton.setOnClickListener(toggleClickListener);
        rightButton.setOnClickListener(toggleClickListener);
// ======================================== Setting related ===============================================
               //   Finding terminal.settings buttons
        LinearLayout terminalOptionsLayout = contentLayout.findViewById(R.id.terminal_options_layout);
        LinearLayout moreAppsOptionsLayout = contentLayout.findViewById(R.id.more_apps_options_layout);
        LinearLayout reportingOptionsLayout = contentLayout.findViewById(R.id.reporting_options_layout);
        LinearLayout merchantOptionsLayout = contentLayout.findViewById(R.id.merchant_options_layout);
//================================================== Code for Login ============================================================================
        View.OnClickListener commonClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedOption = ""; // Initialize the selectedOption variable
                String requiredUser=""; // Initialize the requiredUser variable
                String fragment ="";


                // Determine the fragmentToLoad based on the clicked layout's ID
                if (v.getId() == R.id.terminal_options_layout) {
//                    fragmentToLoad = new TerminalOptions(); // Create your TerminalOptionsFragment
                    selectedOption = "Terminal Options";
                    requiredUser = getString(R.string.manager) + " " + getString(R.string.log_in_required);
                    fragment ="TerminalOptions";
                } else if (v.getId() == R.id.more_apps_options_layout) {
//                    fragmentToLoad = new MoreAppsOptions(); // Create your MoreAppsOptionsFragment
                    selectedOption = "More Apps Options";
                    requiredUser = getString(R.string.supervisor) + " " + getString(R.string.log_in_required);
                    fragment ="MoreApps";
                } else if (v.getId() == R.id.reporting_options_layout) {
//                    fragmentToLoad = new ReportingOptions(); // Create your ReportingOptionsFragment
                    selectedOption = "Reporting Options";
                    requiredUser = getString(R.string.supervisor) + " " + getString(R.string.log_in_required);
                    fragment ="ReportingOptions";
                } else if (v.getId() == R.id.merchant_options_layout) {
//                    fragmentToLoad = new MerchantOptions(); // Create your MerchantOptionsFragment
                    selectedOption = "Operator Options";
                    requiredUser = getString(R.string.supervisor) + " " + getString(R.string.log_in_required);
                    fragment ="MerchantOptions";
                }
                // Create and set the bundle

                Bundle bundle = new Bundle();
//                bundle.putParcelable("FragmentToLoad", fragmentToLoad); // Use putParcelable to pass a fragment
                bundle.putString("SelectedOption", selectedOption);
                bundle.putString("RequiredUser", requiredUser);
                bundle.putString("FragmentToLoad",fragment);
                signInFragment.setArguments(bundle);
                // Replace the current fragment with the SignIn fragment
                FragmentUtils.replaceFragment(getSupportFragmentManager(), R.id.container, signInFragment);
            }
        };

// Set the commonClickListener to all the layouts
        terminalOptionsLayout.setOnClickListener(commonClickListener);
        moreAppsOptionsLayout.setOnClickListener(commonClickListener);
        reportingOptionsLayout.setOnClickListener(commonClickListener);
        merchantOptionsLayout.setOnClickListener(commonClickListener);
    }
}
