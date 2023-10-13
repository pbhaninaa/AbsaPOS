package com.example.absaterminalapp.adapters;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.absaterminalapp.fragments.tabs.*;


public class MyPagerAdapter extends FragmentPagerAdapter {
    private static final int NUM_TABS = 11;

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new PurchaseFragment();
            case 1:
                return new Rapid_PaymentFragment();
            case 2:
                return new RefundFragment();
            case 3:
                return new PaymentReversalFragment();
            case 4:
                return new CancelEnquiryFragment();
            case 5:
                return new AuthOptionsFragment();
            case 6:
                return new DebitCheckFragment();
            case 7:
                return new BalanceEnquiryFragment();
            case 8:
                return new PaymentFragment();
            case 9:
                return new PurchaseAndCashBack();
            case 10:
                return new CashWitdrawal();
            default:
                return null;
        }
    }


    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Purchase";
            case 1:
                return "Rapid Payment";
            case 2:
                return "Refund";
            case 3:
                return "Payment Reversal";
            case 4:
                return "Cancel";
            case 5:
                return "Auth Options";
            case 6:
                return "Debit Check";
            case 7:
                return "Balance Enquiry";
            case 8:
                return "Payment";
            case 9:
                return "Purchase And CashBack";
            case 10:
                return "Cash withdrawal";
            default:
                return "Purchase";
        }
    }
}
