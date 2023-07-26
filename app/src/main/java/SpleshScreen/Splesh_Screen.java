package SpleshScreen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.mbitconnect.R;

import Connect.LogInActivity;
import de.hdodenhof.circleimageview.CircleImageView;

public class Splesh_Screen extends AppCompatActivity {
        CircleImageView imageView;

        TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splesh_screen);

        imageView=(CircleImageView) findViewById(R.id.mbitimage);
        textView=(TextView) findViewById(R.id.text_bounce);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        if(getSupportActionBar()!=null)
        {
            getSupportActionBar().hide();
        }


        Animation animation= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce_anim);
        imageView.startAnimation(animation);

        Animation animation1=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce_text);
        textView.startAnimation(animation1);

        Thread thread=new Thread()
        {
            @Override
            public void run() {
                try{
                    sleep(4000);

                    Intent intent=new Intent(getApplicationContext(), LogInActivity.class);
                    startActivity(intent);

                    finish();

                }
                catch (Exception e)
                {

                }
            }
        };
        thread.start();

    }
}