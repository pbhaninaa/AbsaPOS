package com.example.absaterminalapp.alerts;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
import com.example.absaterminalapp.R;
import com.example.absaterminalapp.activities.MainActivity;

public class Alerts {
    public static void showConfirmAlert(Activity activity, String message, EditText input) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);

        if (TextUtils.isEmpty(input.getText())) {

            showAlertDialog(activity, "Text field cannot be empty");
        } else {
            builder.setTitle(R.string.absa)
                    .setMessage(message)
                    .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            Intent intent = new Intent(activity, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                            activity.startActivity(intent);
                            Alerts.showToast(activity, "Thank you!");
                        }
                    })
                    .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                            input.setText(R.string.empty);
                        }
                    })
                    .show();
        }
    }

    public static void showAlertDialog(Activity activity, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle(R.string.absa)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {


                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
