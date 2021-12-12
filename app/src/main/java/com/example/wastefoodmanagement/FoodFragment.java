package com.example.wastefoodmanagement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;


public class FoodFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_food, container, false);
        ImageButton btnopen=(ImageButton) view.findViewById(R.id.b1);
        ImageButton retro=(ImageButton) view.findViewById(R.id.b2);
        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),AddDonationInfo.class);
                startActivity(i);
            }
        });
        retro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getActivity(),MainActivity.class);
                startActivity(i);
            }
        });
        return view;
    }
}