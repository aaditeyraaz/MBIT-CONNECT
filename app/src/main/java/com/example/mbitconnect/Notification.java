package com.example.mbitconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Notification extends AppCompatActivity {
    Toolbar toolbar2;
    TextView textView,gatepasscome,websitecome,palcementcome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;
        textView=(TextView) findViewById(R.id.marqee);
        gatepasscome=(TextView) findViewById(R.id.gatepsscome);
        palcementcome=(TextView) findViewById(R.id.palcementcome);
        websitecome=(TextView) findViewById(R.id.websitecome);

        Animation animation1= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.noties_text);
        gatepasscome.startAnimation(animation1);
        Animation animation2= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.noties_text);
        palcementcome.startAnimation(animation2);
        Animation animation3= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.noties_text);
        websitecome.startAnimation(animation3);



        textView.setSelected(true);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle(" ");
        }

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}