package com.example.mbitconnect;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mbitconnect.databinding.ActivityProfileBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import Connect.Dashboard;
import SpleshScreen.User;

public class Profile extends AppCompatActivity {

    ActivityProfileBinding binding;
    String name,email,regno;
    FirebaseAuth auth;
    FirebaseFirestore firestore;
    String userId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

      auth=FirebaseAuth.getInstance();
      firestore=FirebaseFirestore.getInstance();
      userId=auth.getCurrentUser().getUid();



        binding.backpress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(), Dashboard.class);
                startActivity(intent);
            }
        });


        DocumentReference reference=firestore.collection("users").document(userId);
        reference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot value, @Nullable FirebaseFirestoreException error) {

               // String name=getText(Integer.parseInt(value.getString("name"))).toString();
                //binding.proname.setText(name);
                binding.proname.setText(value.getString("name"));
                binding.uemail.setText(value.getString("email"));
                binding.uname.setText(value.getString("name"));
                binding.uregis.setText(value.getString("regno"));
            }
        });





    }
}