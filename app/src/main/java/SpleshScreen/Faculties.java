package SpleshScreen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.mbitconnect.R;
import com.example.mbitconnect.databinding.ActivityFacultiesBinding;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class Faculties extends AppCompatActivity {
  //  Toolbar toolbar2;
   ActivityFacultiesBinding binding;
    FacaltyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityFacultiesBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.rv.setLayoutManager(new LinearLayoutManager(this));


      //  toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;
        setSupportActionBar(binding.toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("COLLEGE MEMBERS");
        }

        FirebaseRecyclerOptions<FacultiyModel> options=
                new FirebaseRecyclerOptions.Builder<FacultiyModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Faculties"),FacultiyModel.class)
                        .build();


        adapter=new FacaltyAdapter(options);
        binding.rv.setAdapter(adapter);


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