package com.example.absaterminalapp.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class DateFormatterUtil {

    public static void formatDateInput(EditText editText) {

        editText.addTextChangedListener(new TextWatcher() {
            private String date = "";

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // This method is called before the text changes.
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                // This method is called when the text changes.
            }

            @Override
            public void afterTextChanged(Editable editable) {
                // This method is called after the text changes.

                String newText = editable.toString();
                if (!newText.equals(date)) {
                    // Allow only digits and a single slash (/)
                    String cleanString = newText.replaceAll("[^\\d/]", "");
                    // Limit the maximum length to 5 characters (MM/YY)
                    if (cleanString.length() > 5) {
                        cleanString = cleanString.substring(0, 5);
                    }
                    try {
                        // Format the input in the "MM/YY" pattern
                        StringBuilder formattedText = new StringBuilder(cleanString);
                        if (cleanString.length() == 2) {
                            formattedText.insert(2, "/");
                        }

                        date = formattedText.toString();
                        editText.setText(date);
                        editText.setSelection(date.length());
                    } catch (NumberFormatException e) {
                        // Handle invalid input (not a valid date)
                    }
                }
            }
        });
    }
}
