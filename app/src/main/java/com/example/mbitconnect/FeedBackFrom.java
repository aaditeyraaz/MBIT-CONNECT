package com.example.mbitconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.TextView;


import com.example.mbitconnect.databinding.ActivityFeedBackFromBinding;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class FeedBackFrom extends AppCompatActivity {
    Toolbar toolbar2;
    ActivityFeedBackFromBinding binding;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityFeedBackFromBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;
        textView=(TextView)findViewById(R.id.emailform);
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle(" ");
        }


        binding.fromsubmit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                final String username="mbitconnect458@gmail.com";
                final String password="lnkntgvrzokdvrxx";

                String messageTosend=binding.messageform.getText().toString();
                Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");

                Session session= Session.getInstance(props,
                        new javax.mail.Authenticator(){
                            @Override
                            protected PasswordAuthentication getPasswordAuthentication() {
                                return new PasswordAuthentication(username,password);
                            }
                        });

                try{
                   /* Message message=new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipient(Message.RecipientType.TO,InternetAddress.parse(textView.getText().toString()));
                    message.setSubject(binding.nameform.getText().toString());
                    message.setText(messageTosend);
                    Transport.send(message);*/


                 Message msg = new MimeMessage(session);
                msg.setFrom(new InternetAddress(binding.emailform.getText().toString()));
                msg.addRecipient(Message.RecipientType.TO, new InternetAddress("mbitconnect458@gmail.com"));
                msg.setSubject(binding.nameform.getText().toString()+"\n"+binding.emailform.getText().toString());
                msg.setText(messageTosend);
                Transport.send(msg);

                     String tost="Thanks for Your Feedback";
                     binding.formtext.setText(tost);
                     binding.formtext.setTextColor(Color.BLUE);
                     binding.nameform.setText("");
                     binding.emailform.setText("");
                     binding.messageform.setText("");
                }catch (MessagingException e)
                {
                    String s="Kindly Provide Valid Email";
                    binding.formtext.setText(s);
                    binding.formtext.setTextColor(Color.RED);

                }


            }
        });

        StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);


    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}