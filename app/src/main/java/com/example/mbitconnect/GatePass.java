package com.example.mbitconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mbitconnect.databinding.ActivityFeedBackFromBinding;
import com.example.mbitconnect.databinding.ActivityGatePassBinding;

public class GatePass extends AppCompatActivity {
    Toolbar toolbar2;
    ActivityGatePassBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding= ActivityGatePassBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("GATE PASS");
        }

     binding.studentcard.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent=new Intent(getApplicationContext(),QR_CODE_Ganrate.class);
             startActivity(intent);
         }
     });

        binding.AdminCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),AdminGrant.class);
                startActivity(intent);
            }
        });

        binding.AdminStaft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),GateGard.class);
                startActivity(intent);
            }
        });

    }



    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}