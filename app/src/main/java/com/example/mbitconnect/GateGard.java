package com.example.mbitconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class GateGard extends AppCompatActivity {
    Toolbar toolbar2;
    AppCompatButton button;
    EditText phone,pass;
    TextView error;
    ProgressDialog dialog;
    DatabaseReference reference;
    boolean passwordVisible;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate_gard);

        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;
        button=(AppCompatButton) findViewById(R.id.submitBtn) ;

        phone=(EditText) findViewById(R.id.phoneBox);
        pass=(EditText) findViewById(R.id.passwordBoxad);
        error=(TextView) findViewById(R.id.error);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Logging in...");

        //password Seen
        pass.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int Right=2;
                if(event.getAction()==MotionEvent.ACTION_UP){
                    if(event.getRawX()>=pass.getRight()-pass.getCompoundDrawables()[Right].getBounds().width()){
                        int selection=pass.getSelectionEnd();
                        if(passwordVisible){
                            pass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_off_24,0);
                            pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                            passwordVisible=false;
                        }else {
                            pass.setCompoundDrawablesRelativeWithIntrinsicBounds(0,0,R.drawable.ic_baseline_visibility_24,0);
                            pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                            passwordVisible=true;

                        }

                        pass.setSelection(selection);
                        return  true;
                    }
                }
                return false;
            }
        });


        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("GATE PASS");
        }

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ValidatePhone()|!Validatepass())
                {
                    phone.requestFocus();
                    pass.requestFocus();
                }else {
                    dialog.show();;
                    checkUser();
                }
            }
        });

    }

    public void checkUser()
    {
        String ph=phone.getText().toString().trim();
        String ps=pass.getText().toString().trim();

        reference= FirebaseDatabase.getInstance().getReference("GateAdminStaf");
        Query checkphone=reference.orderByChild("number").equalTo(ph);

        checkphone.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    phone.setError(null);
                    String passdb=snapshot.child(ph).child("password").getValue(String.class);
                    if(passdb.equals(ps)){
                        phone.setError(null);
                        name=snapshot.child(ph).child("Name").getValue(String.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("name", name);
                        Intent intent=new Intent(getApplicationContext(),GateAdminSeenData.class);
                        intent.putExtras(bundle);
                        startActivity(intent);
                        error.setText("");
                        dialog.dismiss();
                    }else {
                        pass.setError("Invalide Password!");
                        error.setText("Invalide Password!");
                        pass.requestFocus();
                        dialog.dismiss();

                    }
                }else {
                    phone.setError("User Don't Exist..");
                    error.setText("User Don't Exist..");
                    dialog.dismiss();
                    phone.requestFocus();
                    pass.requestFocus();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private boolean Validatepass() {
        String ps=pass.getText().toString();
        if(ps.isEmpty()){
            pass.setError("Password cannot be Empty ");
            return false;
        }else{
            pass.setError(null);
            return true;
        }
    }

    private boolean ValidatePhone() {
        String ph=phone.getText().toString();
        if(ph.isEmpty()){
            phone.setError("phoneNumber cannot be Empty ");
            return false;
        }else{
            phone.setError(null);
            return true;
        }
    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}