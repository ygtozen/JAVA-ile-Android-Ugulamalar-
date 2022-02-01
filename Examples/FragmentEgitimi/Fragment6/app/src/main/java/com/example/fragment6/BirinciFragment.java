package com.example.fragment6;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class BirinciFragment extends Fragment {

    View view;
    EditText editText;
    Button button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_birinci, container, false);

        editText = view.findViewById(R.id.editText);
        button = view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity().getApplicationContext(),MainActivity.class);
                intent.putExtra("isim",editText.getText().toString());
                //Kisi.ad = editText.getText().toString(); --> Static değişkenlerle veri gönderme
                getActivity().startActivity(intent);
            }
        });

        return view;
    }
}