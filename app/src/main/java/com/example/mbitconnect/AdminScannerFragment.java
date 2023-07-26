package com.example.mbitconnect;

import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class AdminScannerFragment extends Fragment {

    CardView cardView;
    View view;
  static ImageView imageView;
     TextView textView;

   static   String name;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_admin_scanner, container, false);
        cardView=(CardView) view.findViewById(R.id.scan);
        imageView=(ImageView)view.findViewById(R.id.check);
        textView=(TextView)view.findViewById(R.id.grantby);


        imageView.setVisibility(View.GONE);

        Bundle args = getArguments();

        if (args != null) {
            String username = args.getString("username");
            name=username;
            // Display the profile data in the UI (TextViews, ImageViews, etc.
            textView.setText(name);
        }

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),ScaneerCemara.class));
            }
        });
        return view;
    }

    public void setViewModel(garantbyprofile dataViewModel) {
    }
}