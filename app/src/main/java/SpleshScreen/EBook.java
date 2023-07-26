package SpleshScreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mbitconnect.R;
import com.example.mbitconnect.databinding.ActivityEbookBinding;
import com.example.mbitconnect.databinding.ActivityFacultiesBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class EBook extends AppCompatActivity {
    Toolbar toolbar2;
     ActivityEbookBinding binding;
     EBookAdapter adapter;
     ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityEbookBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dialog = new ProgressDialog(EBook.this);
        dialog.setCancelable(false);
        dialog.setMessage("Please Wait");
        dialog.show();

        binding.rvebook.setLayoutManager(new LinearLayoutManager(this));


        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;
        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("e-BOOK");
        }


        binding.UploadIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),UploadEbook.class);
                startActivity(intent);
            }
        });

        FirebaseRecyclerOptions<FileInfoModel> options=
                new FirebaseRecyclerOptions.Builder<FileInfoModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Ebook"),FileInfoModel.class)
                        .build();
     dialog.dismiss();

        adapter=new EBookAdapter(options);
        binding.rvebook.setAdapter(adapter);

    }


    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}