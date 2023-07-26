package com.example.mbitconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mbitconnect.databinding.ActivityQrCodeGanrateBinding;

public class QR_CODE_Ganrate extends AppCompatActivity {
    Toolbar toolbar2;
    AppCompatButton button;
   static TextView reg;
    ActivityQrCodeGanrateBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityQrCodeGanrateBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());

        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;
        button=(AppCompatButton) findViewById(R.id.fromsubmit);
        reg=(TextView)findViewById(R.id.Registration_No);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name=binding.nameform.getText().toString().trim();
                String Reg=binding.RegistrationNo.getText().toString().trim();
                String purpose=binding.purposeForm.getText().toString().trim();
                if(TextUtils.isEmpty((name))){
                    Toast.makeText(QR_CODE_Ganrate.this, "Please Enter Your Full Name", Toast.LENGTH_SHORT).show();
                    binding.nameform.setError("Full Name is required");
                    binding.nameform.requestFocus();
                }else if(TextUtils.isEmpty(Reg)) {
                    Toast.makeText(QR_CODE_Ganrate.this, "Please Enter Your  Registration_No", Toast.LENGTH_SHORT).show();
                    binding.RegistrationNo.setError("Registration_No is required");
                    binding.RegistrationNo.requestFocus();

                }

                else if(TextUtils.isEmpty(purpose)){
                    Toast.makeText(QR_CODE_Ganrate.this, "Please Enter Your  Purpose", Toast.LENGTH_SHORT).show();
                    binding.purposeForm.setError("purpose is required");
                    binding.purposeForm.requestFocus();
                }

                if(!TextUtils.isEmpty(name)&& !TextUtils.isEmpty(Reg) && !TextUtils.isEmpty(purpose)) {
                    Intent intent = new Intent(getApplicationContext(), QR_code_Ganretor_1.class);
                    intent.putExtra("NAME",name);
                    intent.putExtra("REGNO",Reg);
                    intent.putExtra("PURPOSE",purpose);
                    startActivity(intent);

                }
            }
        });

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("GATE PASS");



        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}