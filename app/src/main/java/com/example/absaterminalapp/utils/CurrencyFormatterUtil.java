package com.example.absaterminalapp.utils;
import java.text.DecimalFormat;

public class CurrencyFormatterUtil {
    private static DecimalFormat currencyFormat = new DecimalFormat("#,##0.00");

    public static String formatCurrency(String input) {
        try {
            double parsed = Double.parseDouble(input);
            return currencyFormat.format(parsed);
        } catch (NumberFormatException e) {
            // Handle the case where input is not a valid number
            return input; // or provide an error message
        }
    }
}
