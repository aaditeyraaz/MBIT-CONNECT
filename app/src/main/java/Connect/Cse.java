package Connect;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mbitconnect.R;

public class Cse extends AppCompatActivity {
    Toolbar toolbar2;
    CardView firstsem,secondsem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);

        toolbar2=(Toolbar) findViewById(R.id.toolbar2) ;
        firstsem=(CardView) findViewById(R.id.firstsem);
        secondsem=(CardView) findViewById(R.id.secondsem);

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if(getSupportActionBar()!=null){

            getSupportActionBar().setTitle("  ");
        }



        firstsem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),CsefirstSem.class);
                startActivity(intent);
            }
        });
        secondsem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1=new Intent(getApplicationContext(),Cse_Second_Sem.class);
                startActivity(intent1);
            }
        });

    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }
}