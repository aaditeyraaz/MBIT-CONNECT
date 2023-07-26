package Connect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.mbitconnect.R;

public class Btech extends AppCompatActivity {
    Toolbar toolbar2;
    ImageView cse,civil,me,ee,ece,it;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btech);
        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;

        cse=(ImageView)findViewById(R.id.cse);
        civil=(ImageView)findViewById(R.id.civil);
        me=(ImageView)findViewById(R.id.me);
        ee=(ImageView)findViewById(R.id.ee);
        ece=(ImageView)findViewById(R.id.ece);
        it=(ImageView)findViewById(R.id.it);


        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("  ");
        }


        //CSE
        cse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Cse.class);
                startActivity(intent);
            }
        });

        //civil
        civil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Civil.class);
                startActivity(intent);
            }
        });


        //ME
        me.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Mechenical.class);
                startActivity(intent);
            }
        });


        //EE

        ee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),electrical2.class);
                startActivity(intent);
            }
        });

        //ECE
        ece.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Electronic.class);
                startActivity(intent);
            }
        });

        //it

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

}