package com.example.fragment5;

import android.content.Context;
import android.os.Bundle;

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
                .replace(R.id.frameLayout, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void change(Fragment fragment, String isim)
    {

        Bundle bundle = new Bundle();
        bundle.putString("isim",isim);
        fragment.setArguments(bundle);

        ((FragmentActivity) mContex).getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void ikincifragmentigoster(Fragment fragment)
    {
        ((FragmentActivity) mContex).getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout2, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

    public void VeriGonder(Fragment fragment,String bilgi)
    {
        Bundle bundle = new Bundle();
        bundle.putString("bilgi",bilgi);
        fragment.setArguments(bundle);

        ((FragmentActivity) mContex).getSupportFragmentManager().beginTransaction()
                .replace(R.id.frameLayout2, fragment, "fragment")
                .setTransitionStyle(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .commit();
    }

}
