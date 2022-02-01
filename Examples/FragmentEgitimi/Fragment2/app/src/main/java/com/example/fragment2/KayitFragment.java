package com.example.fragment2;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class KayitFragment extends Fragment {

    View view;
    EditText k_adi;
    TextView txt_kadi;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_kayit, container, false);

        tanimla();
        action();

        return view;
    }

    public void tanimla()
    {
        k_adi = view.findViewById(R.id.k_adi);
        txt_kadi = view.findViewById(R.id.txt_kadi);
        button = view.findViewById(R.id.button);
    }

    public void action()
    {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txt_kadi.setText(k_adi.getText().toString());
                k_adi.setText("");
            }
        });
    }
}