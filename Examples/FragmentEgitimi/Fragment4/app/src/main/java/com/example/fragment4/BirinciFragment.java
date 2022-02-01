package com.example.fragment4;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BirinciFragment extends Fragment {


    View view;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_birinci, container, false);

        textView = view.findViewById(R.id.textView);

        if (getArguments() != null)
        {
            String isimDeger = getArguments().getString("isim").toString();
            int yasDeger = getArguments().getInt("yas");
            textView.setText(isimDeger);
        }


        return view;
    }
}