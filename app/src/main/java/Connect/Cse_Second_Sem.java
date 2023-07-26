package Connect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.mbitconnect.R;

public class Cse_Second_Sem extends AppCompatActivity {
    AppCompatButton bee,math2,egd,phy;
    TextView csesecond,csesecond1,csesecond2,csesecond3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse_second_sem);

        bee=(AppCompatButton) findViewById(R.id.bee);
        math2=(AppCompatButton) findViewById(R.id.math2);

        egd=(AppCompatButton) findViewById(R.id.egd);
        phy=(AppCompatButton) findViewById(R.id.phy);
     //   engilish=(AppCompatButton) findViewById(R.id.engilish);







        csesecond=(TextView) findViewById(R.id.csesecond);
        csesecond1=(TextView) findViewById(R.id.csesecond1);
        csesecond2=(TextView) findViewById(R.id.csesecond2);
        csesecond3=(TextView) findViewById(R.id.csesecond3);



        csesecond.setVisibility(View.GONE);
        csesecond1.setVisibility(View.GONE);
        csesecond2.setVisibility(View.GONE);
        csesecond3.setVisibility(View.GONE);;


        bee.setOnClickListener(new View.OnClickListener() {

            boolean aBoolean;
            @Override
            public void onClick(View v) {

                aBoolean=!aBoolean;

                csesecond.setVisibility(aBoolean? View.VISIBLE:View.GONE);
            }
        });
        math2.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;

                csesecond1.setVisibility(aBoolean? View.VISIBLE:View.GONE);

            }
        });
        egd.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;
                csesecond2.setVisibility(aBoolean? View.VISIBLE:View.GONE);

            }
        });
        phy.setOnClickListener(new View.OnClickListener() {
            boolean aBoolean;
            @Override
            public void onClick(View v) {
                aBoolean=!aBoolean;
                csesecond3.setVisibility(aBoolean? View.VISIBLE:View.GONE);

            }
        });

    }

}