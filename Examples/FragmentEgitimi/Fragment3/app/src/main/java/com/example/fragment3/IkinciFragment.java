package com.example.fragment3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class IkinciFragment extends Fragment {

    View view;
    private Button button2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_ikinci, container, false);

        tanimla();

        return view;
    }

    public void tanimla()
    {
        button2 = view.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFm();
            }
        });
    }

    public void changeFm()
    {
        ChangeFragment changeFragment = new ChangeFragment(getContext());
        changeFragment.change(new UcuncuFragment());
    }
}