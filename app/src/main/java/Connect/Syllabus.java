package Connect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mbitconnect.R;

public class Syllabus extends AppCompatActivity {
    Toolbar toolbar2;
    ImageView btech,bca,bcom,bba;
    @SuppressLint("RestrictedApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_syllabus);
        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;

        //Btech
        btech=(ImageView) findViewById(R.id.btech);
        bca=(ImageView) findViewById(R.id.bca);
        bcom=(ImageView) findViewById(R.id.bcom);
        bba=(ImageView) findViewById(R.id.bba);




        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportActionBar().setTitle("  ");



//        setSupportActionBar();
        if(getSupportActionBar()!=null){


        }

            //btech
        btech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Btech.class);
                startActivity(intent);
            }
        });

        //bca
        bca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),bca.class);
                startActivity(intent);
            }
        });

        //bcom
        bcom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),bcom.class);
                startActivity(intent);
            }
        });

        //baa
        bba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),bba.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}