package com.example.mbitconnect;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mbitconnect.databinding.ActivityHolidayBinding;

import Connect.Dashboard;

public class Holiday extends AppCompatActivity {

    ActivityHolidayBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHolidayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        //Jan
        binding.janfac.setVisibility(View.GONE);
        binding.jan.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.janfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //fab

        binding.fabfac.setVisibility(View.GONE);
        binding.fab.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.fabfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //march
        binding.marfac.setVisibility(View.GONE);
        binding.mar.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.marfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //april
        binding.aprfac.setVisibility(View.GONE);
        binding.apr.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.aprfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //may
        binding.mayfac.setVisibility(View.GONE);
        binding.may.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.mayfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //june
        binding.junefac.setVisibility(View.GONE);
        binding.june.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.junefac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //july
        binding.julyfac.setVisibility(View.GONE);
        binding.july.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.julyfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //august
        binding.augfac.setVisibility(View.GONE);
        binding.aug.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.augfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //sep
        binding.sepfac.setVisibility(View.GONE);
        binding.sep.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.sepfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //oct
        binding.octfac.setVisibility(View.GONE);
        binding.oct.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.octfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //nov
        binding.novfac.setVisibility(View.GONE);
        binding.nov.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.novfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //dec
        binding.decfac.setVisibility(View.GONE);
        binding.dec.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                binding.decfac.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });

        //goback
        binding.backpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               onBackPressed();
            }
        });
    }
}