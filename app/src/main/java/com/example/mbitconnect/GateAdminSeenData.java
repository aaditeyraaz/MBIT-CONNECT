package com.example.mbitconnect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GateAdminSeenData extends AppCompatActivity {
    Toolbar toolbar2;
    private RecyclerView recyclerView;
    private  GateStafAdaptor adapter;
    // private List<GrantByaAdminModel> list = new ArrayList<>();
    private ProgressDialog dialog;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gate_admin_seen_data);



        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;

        dialog = new ProgressDialog(this);
        dialog.setCancelable(false);
        dialog.setMessage("Fetching data...");
        dialog.show();

        recyclerView=(RecyclerView) findViewById(R.id.recycle_view);
        setRecyclerView();
        recyclerView.setNestedScrollingEnabled(false);

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("GATE PASS");
        }


    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter= new GateStafAdaptor(getApplicationContext(),getlist());
        recyclerView.setAdapter(adapter);
    }

    private List<GatepassStafModel> getlist() {
        List<GatepassStafModel> list=new ArrayList<>();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("GatePass1");
//        list.add(new GrantByaAdminModel("12","Rahul","Home"));
//        list.add(new GrantByaAdminModel("13","Abhishek","Home"));
//        list.add(new GrantByaAdminModel("14","Vishnu","Home"));
//        list.add(new GrantByaAdminModel("15","Vikash","Home"));
//        list.add(new GrantByaAdminModel("16","Neeraj","Home"));
//        list.add(new GrantByaAdminModel("17","Ujjwal","Home"));
//        list.add(new GrantByaAdminModel("18","Arjun","Home"));

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot: snapshot.getChildren())
                {
                    GatepassStafModel db=dataSnapshot.getValue(GatepassStafModel.class);
                    list.add(db);
                    dialog.dismiss();
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        return list;

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}