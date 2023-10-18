package com.example.absaterminalapp.utils;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
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

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FragmentUtils {
    private TextView flickerTextView;
    private static Animation flickerAnimation;
    public static void replaceFragment(FragmentManager fragmentManager, int containerId, Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerId, fragment);
        transaction.addToBackStack(null); 
        transaction.commit();
    }
    public static void restartApp(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        if (context instanceof Activity) {
            ((Activity) context).finish();
        }
    }
    public static void TextFlickerAnimation(View view, Context context) {
        TextView flickerTextView = view.findViewById(R.id.flicker_textview);
        Animation flickerAnimation = AnimationUtils.loadAnimation(context, R.anim.flicker_animation);
        flickerTextView.startAnimation(flickerAnimation);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                flickerTextView.startAnimation(flickerAnimation);
                handler.postDelayed(this, flickerAnimation.getDuration());
            }
        }, flickerAnimation.getDuration());

        int color = ContextCompat.getColor(context, R.color.red); 
        flickerTextView.setTextColor(color);
    }
    public static void ImageFlickerAnimation(View view, Context context) {
        ImageView flickerTextView = view.findViewById(R.id.terminalIcon);
        Animation flickerAnimation = AnimationUtils.loadAnimation(context, R.anim.flicker_animation);

        flickerTextView.startAnimation(flickerAnimation);

        final Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                flickerTextView.startAnimation(flickerAnimation);
                handler.postDelayed(this, flickerAnimation.getDuration());
            }
        }, flickerAnimation.getDuration());
    }
    public static boolean isValidCardNumber(Activity activity,String cardNumber, String cvv) {
        cardNumber = cardNumber.replaceAll("[^\\d]", "");
        cvv = cvv.replaceAll("[^\\d]", "");
        if (cardNumber.length() == 16 && cvv.length() ==3) {
            return true; 
        } else {
            Alerts.showAlertDialog(activity,"Invalid card information");
            return false
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
            return "";
        }
    }
    public static void Refresh(Activity activity){
     Intent intent = new Intent(activity, MainActivity.class);
     activity.startActivity(intent);
    activity.finish();
 }
    public static void cardNumber(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {
            private String card = "";

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {

                String newText = editable.toString();
                if (!newText.equals(card)) {
                    String cleanString = newText.replaceAll("[^\\d ]", "");
                    if (cleanString.length() > 16) {
                        cleanString = cleanString.substring(0, 16);
                    }
                    try {
                        StringBuilder formattedText = new StringBuilder(cleanString);


                        card = formattedText.toString();
                        editText.setText(card);
                        editText.setSelection(card.length());
                    } catch (NumberFormatException e) {
                    }
                }
            }
        });
    }
    public static void cvv(EditText editText){

    editText.addTextChangedListener(new TextWatcher() {
        private String cvv = "";

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {

            String newText = editable.toString();
            if (!newText.equals(cvv)) {
                String cleanString = newText.replaceAll("[^\\d.]", "");
                if (cleanString.length() > 3) {
                    cleanString = cleanString.substring(0, 3);
                }
                try {
                    StringBuilder formattedText = new StringBuilder(cleanString);


                    cvv = formattedText.toString();
                    editText.setText(cvv);
                    editText.setSelection(cvv.length());
                } catch (NumberFormatException e) {
                }
            }
        }
    });


}
}
