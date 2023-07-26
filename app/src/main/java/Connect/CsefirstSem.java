package Connect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.TextView;

import com.example.mbitconnect.R;

public class CsefirstSem extends AppCompatActivity {
AppCompatButton chem,math1,pps,workshop,engilish;
TextView csefirst,csefirst1,csefirst2,csefirst3,csefirst4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csefirst_sem);

        chem=(AppCompatButton) findViewById(R.id.chem);
        math1=(AppCompatButton) findViewById(R.id.math1);

        pps=(AppCompatButton) findViewById(R.id.pps);
        workshop=(AppCompatButton) findViewById(R.id.workshop);
        engilish=(AppCompatButton) findViewById(R.id.engilish);







        csefirst=(TextView) findViewById(R.id.csefirst);
        csefirst1=(TextView) findViewById(R.id.csefirst1);
        csefirst2=(TextView) findViewById(R.id.csefirst2);
        csefirst3=(TextView) findViewById(R.id.csefirst3);
        csefirst4=(TextView) findViewById(R.id.csefirst4);



        csefirst.setVisibility(View.GONE);
        csefirst1.setVisibility(View.GONE);
        csefirst2.setVisibility(View.GONE);
        csefirst3.setVisibility(View.GONE);;
        csefirst4.setVisibility(View.GONE);


        chem.setOnClickListener(new View.OnClickListener() {

            boolean aBoolean;
            @Override
            public void onClick(View v) {

                aBoolean=!aBoolean;

                csefirst.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });
        math1.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                csefirst1.setVisibility(aBoolean? View.VISIBLE:View.GONE);

            }
        });
        pps.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;
                csefirst2.setVisibility(aBoolean? View.VISIBLE:View.GONE);

            }
        });
        workshop.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;
                csefirst3.setVisibility(aBoolean? View.VISIBLE:View.GONE);

            }
        });
        engilish.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;
                csefirst4.setVisibility(aBoolean? View.VISIBLE:View.GONE);

            }
        });

    }
}