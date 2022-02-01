package com.example.fragment3;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class BirinciFragment extends Fragment {

    View view;
    private Button button1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_birinci, container, false);

        tanimla();

        return view;
    }

    public void tanimla()
    {
        button1 = view.findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeFm();
            }
        });
    }

    public void changeFm() // --> private'de olabilir.
    {
        ChangeFragment changeFragment = new ChangeFragment(getContext());
        changeFragment.change(new IkinciFragment());
    }
}