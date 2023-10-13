package com.example.absaterminalapp.utils;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.absaterminalapp.R;
import com.example.absaterminalapp.activities.MainActivity;
import com.example.absaterminalapp.alerts.Alerts;
import com.example.absaterminalapp.fragments.settingsFragments.MerchantOptions;
import com.example.absaterminalapp.fragments.settingsFragments.MoreAppsOptions;
import com.example.absaterminalapp.fragments.settingsFragments.ReportingOptions;
import com.example.absaterminalapp.fragments.settingsFragments.TerminalOptions;
import com.example.absaterminalapp.fragments.shared.CardPayment;
import com.example.absaterminalapp.fragments.shared.InvoiceNumber;
import com.example.absaterminalapp.fragments.tabs.PurchaseFragment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentUtils {
    private TextView flickerTextView;
    private static Animation flickerAnimation;
    // Replace the current fragment with a new fragment
    public static void replaceFragment(FragmentManager fragmentManager, int containerId, Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.addToBackStack(null); // Optional: Add the transaction to the back stack
        transaction.commit();
    }
    public static void restartApp(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        // If this method is called from an activity, you may also want to finish the current activity
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
    public static void TextFlickerAnimation(View view, Context context) {
        TextView flickerTextView = view.findViewById(R.id.flicker_textview);
        Animation flickerAnimation = AnimationUtils.loadAnimation(context, R.anim.flicker_animation);

        // Start the initial flicker animation
        flickerTextView.startAnimation(flickerAnimation);

        // Create a handler to restart the animation after it finishes
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the animation again after it finishes
                flickerTextView.startAnimation(flickerAnimation);
                handler.postDelayed(this, flickerAnimation.getDuration());
            }
        }, flickerAnimation.getDuration());

        // Set the text color using a color resource
        int color = ContextCompat.getColor(context, R.color.red); // Assuming "red" is a valid color resource
        flickerTextView.setTextColor(color);
    }
    public static void ImageFlickerAnimation(View view, Context context) {
        ImageView flickerTextView = view.findViewById(R.id.terminalIcon);
        Animation flickerAnimation = AnimationUtils.loadAnimation(context, R.anim.flicker_animation);

        // Start the initial flicker animation
        flickerTextView.startAnimation(flickerAnimation);

        // Create a handler to restart the animation after it finishes
        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // Start the animation again after it finishes
                flickerTextView.startAnimation(flickerAnimation);
                handler.postDelayed(this, flickerAnimation.getDuration());
            }
        }, flickerAnimation.getDuration());

        // Set the text color using a color resource
       // int color = ContextCompat.getColor(context, R.color.red); // Assuming "red" is a valid color resource
        //flickerTextView.setTextColor(color);
    }
    public static boolean isValidCardNumber(Activity activity,String cardNumber, String cvv) {
        // Remove any whitespace or non-digit characters from the card number
        cardNumber = cardNumber.replaceAll("[^\\d]", "");
        cvv = cvv.replaceAll("[^\\d]", "");
        // Check if the cleaned card number has exactly 16 digits and cvv is exactly 3 digits
        if (cardNumber.length() == 16 && cvv.length() ==3) {
            return true; // Valid card number and cvv
        } else {
            Alerts.showAlertDialog(activity,"Invalid card information");
            return false; // Invalid card number and cvv
        }
    }
    public static Fragment FragmentFactory(String FragmentToLoad) {
        Fragment fragment = null;

        if (FragmentToLoad != null) {
            switch (FragmentToLoad) {
                case "CardPayment":
                    fragment = new CardPayment();
                    break;
                case "InvoiceNumber":
                    fragment = new InvoiceNumber();
                    break;
                case "MerchantOptions":
                    fragment = new MerchantOptions();
                    break;
                case "ReportingOptions":
                    fragment = new ReportingOptions();
                    break;
                case "MoreApps":
                    fragment = new MoreAppsOptions();
                    break;
                case "TerminalOptions":
                    fragment = new TerminalOptions();
                    break;
                case "ExitApp":
                    fragment = new ExitApp();
                    break;
                default:
                    fragment =  null;
                    break;
            }
        }

        return fragment;
    }

    public static String extractFirstWord(String input) {
        Pattern pattern = Pattern.compile("^\\S+");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            return matcher.group();
        } else {
            // Handle the case where there's no word before the first space
            return "";
        }
    }


}
