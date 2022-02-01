package com.example.fragment3;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

public class ChangeFragment {

    private Context mContex;

    public ChangeFragment(Context mContex) {
        this.mContex = mContex;
    }

    public void change(Fragment fragment)
    {
        ((FragmentActivity) mContex).getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_tutucu, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}
