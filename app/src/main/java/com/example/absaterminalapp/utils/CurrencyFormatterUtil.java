package com.example.absaterminalapp.utils;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import java.text.DecimalFormat;

public class CurrencyFormatterUtil {
    public static void formatCurrencyInput(EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {
            private String current = "";

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
                String newText = editable.toString();
                if (!newText.equals(current)) {
                    String cleanString = newText.replaceAll("[^\\d.]", "");
                    // Limit the maximum length to 11 characters
                    if (cleanString.length() > 11) {
                        cleanString = cleanString.substring(0, 11);
                    }
                    try {
                        double amount = Double.parseDouble(cleanString);
                        DecimalFormat df = new DecimalFormat("###,###,###,##");
                        String formattedText = df.format(amount); current = formattedText;
                        editText.setText(formattedText);
                        editText.setSelection(formattedText.length());
                    } catch (NumberFormatException e) {
                        // Handle invalid input (not a valid number)
                    }
                }
            }
        });
    }
}
