package com.example.mbitconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mbitconnect.databinding.ActivityDevloperBinding;

import Connect.Dashboard;

public class Devloper extends AppCompatActivity {
    Toolbar toolbar2;
    ActivityDevloperBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityDevloperBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("  ");
            
        }


        ///Rahul Section
          binding.rabout.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  startActivity(new Intent(Devloper.this,RahulAbout.class));
              }
          });

        binding.rlinkedln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Devloper.this, "Linkedin", Toast.LENGTH_LONG).show();
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rahul-kumar-06223a203"));
                startActivity(intent2);
            }
        });
        binding.rfacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Devloper.this, "Facebook", Toast.LENGTH_LONG).show();
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/rahulraj.r.rahulraj.37?mibextid=ZbWKwL"));
                startActivity(intent2);
            }
        });

        binding.rinsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Devloper.this, "Instagram", Toast.LENGTH_LONG).show();
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/mr_lifelearing?igshid=YmMyMTA2M2Y="));
                startActivity(intent2);
            }
        });

        binding.rweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Devloper.this, "Website", Toast.LENGTH_LONG).show();
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://aaditeyraaz.github.io/Portfolio.github.io/"));
                startActivity(intent2);
            }
        });

        binding.rgamil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Devloper.this, "Gmail", Toast.LENGTH_LONG).show();
              try{
                  Intent intent=new Intent(Intent.ACTION_SENDTO);
                  intent.setData(Uri.parse("mailto:"));
                 // String mail="raazaaditey@gmail.com";
                  intent.putExtra(Intent.EXTRA_EMAIL,"raazaaditey@gmail.com");
                  intent .putExtra(Intent.EXTRA_SUBJECT,"Subject");
                  intent.putExtra(Intent.EXTRA_TEXT,"This is text");
                  startActivity(Intent.createChooser(intent,"Send Email"));

              }catch (Exception e){
                  e.printStackTrace();
              }
            }
        });




        //Abhi section


        binding.aabout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Devloper.this,AbhishekAbout.class));
            }
        });

        binding.alinkedln.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Devloper.this, "Linkedin", Toast.LENGTH_LONG).show();
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.linkedin.com/in/rahul-kumar-06223a203"));
                startActivity(intent2);
            }
        });
        binding.afacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Devloper.this, "Facebook", Toast.LENGTH_LONG).show();
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/rahulraj.r.rahulraj.37?mibextid=ZbWKwL"));
                startActivity(intent2);
            }
        });

        binding.ainsta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Devloper.this, "Instagram", Toast.LENGTH_LONG).show();
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/mr_lifelearing?igshid=YmMyMTA2M2Y="));
                startActivity(intent2);
            }
        });

        binding.aweb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Devloper.this, "Website", Toast.LENGTH_LONG).show();
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://aaditeyraaz.github.io/Portfolio.github.io/"));
                startActivity(intent2);
            }
        });

        binding.agamil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Devloper.this, "Gmail", Toast.LENGTH_LONG).show();
                try{
                    Intent intent=new Intent(Intent.ACTION_SENDTO);
                    intent.setData(Uri.parse("mailto:"));
                    // String mail="raazaaditey@gmail.com";
                    intent.putExtra(Intent.EXTRA_EMAIL,"raazaaditey@gmail.com");
                    startActivity(Intent.createChooser(intent,"Send Email"));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });


    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}