package com.example.fragment5;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class IkinciFragment extends Fragment {

    View view;
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ikinci, container, false);

        if (getArguments() != null) {
            String veri = getArguments().getString("bilgi").toString();

            textView = view.findViewById(R.id.textView);
            textView.setText(veri);

        }

        return view;
    }
}