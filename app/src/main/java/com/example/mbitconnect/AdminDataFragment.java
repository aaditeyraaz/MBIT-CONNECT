package com.example.mbitconnect;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import SpleshScreen.FacaltyAdapter;
import SpleshScreen.FacultiyModel;

public class AdminDataFragment extends Fragment {

    private Button button;
    private View view;
    private RecyclerView recyclerView;
    private  AdminAdpator adapter;
   // private List<GrantByaAdminModel> list = new ArrayList<>();
    private ProgressDialog dialog;
    private DatabaseReference databaseReference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_admin_data, container, false);
        dialog = new ProgressDialog(getContext());
        dialog.setCancelable(false);
        dialog.setMessage("Fetching data...");
        dialog.show();

        recyclerView=(RecyclerView) view.findViewById(R.id.recycle_view);
        setRecyclerView();
        recyclerView.setNestedScrollingEnabled(false);


        return view;


    }

    private void setRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter=new AdminAdpator(getContext(),getlist());
        recyclerView.setAdapter(adapter);
    }

    private List<GrantByaAdminModel> getlist() {

        List<GrantByaAdminModel> list=new ArrayList<>();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("GatePass1");
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
                    GrantByaAdminModel db=dataSnapshot.getValue(GrantByaAdminModel.class);
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


}
