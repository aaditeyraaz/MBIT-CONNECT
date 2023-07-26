package Connect;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.Toast;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.mbitconnect.AboutApp;
import com.example.mbitconnect.Calender;
import com.example.mbitconnect.Devloper;
import com.example.mbitconnect.FeedBackFrom;
import com.example.mbitconnect.Formula;
import com.example.mbitconnect.GatePass;
import com.example.mbitconnect.Holiday;
import com.example.mbitconnect.Notification;
import com.example.mbitconnect.Placement;
import com.example.mbitconnect.Profile;
import com.example.mbitconnect.R;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

import SpleshScreen.EBook;
import SpleshScreen.Faculties;

public class Dashboard extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;
    ImageSlider imageSlider;
    CardView faculties,ebook,formula,gatepass,place;

    ImageView website,questionPaper,result,nptel,syallbus,location;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        imageSlider=(ImageSlider) findViewById(R.id.imageslider);

        drawerLayout =(DrawerLayout) findViewById(R.id.drablelayout);
        navigationView=(NavigationView) findViewById(R.id.nav_view);
        toolbar=(Toolbar) findViewById(R.id.toolbar1) ;
        website=(ImageView) findViewById(R.id.website);
        location=(ImageView) findViewById(R.id.location);
        questionPaper=(ImageView) findViewById(R.id.questionPaper);
        result=(ImageView) findViewById(R.id.result);
        nptel=(ImageView) findViewById(R.id.nptel);
        syallbus=(ImageView)findViewById(R.id.syallbus);
        faculties=(CardView) findViewById(R.id.faculties);
        ebook=(CardView) findViewById(R.id.ebook);
        formula=(CardView) findViewById(R.id.formula);
        gatepass=(CardView) findViewById(R.id.gatepass);
        place=(CardView) findViewById(R.id.place);



        setSupportActionBar(toolbar);



//        setSupportActionBar();

        if(getSupportActionBar()!=null)
        {
           getSupportActionBar().setTitle(" ");
        }





        //now we will create a list for image
        ArrayList<SlideModel> slideModels=new ArrayList<>();
        slideModels.add(new SlideModel("https://www.edufever.com/wp-content/uploads/2016/08/MBIT-Forbesganj.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQc2DCNyBHMu684aYTRv9zlttuZykZcqL06sc5eEmGWnCwlGfpJobOye186Q5q7afn0fcw&usqp=CAU", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTr2sZ59EzRIOiiqkngpbjm5jDyxhtCnFBMKi9rHa7PD4U7K37lv4pJdrxMDgEzEDD8fg8&usqp=CAU", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://onlinecs.baylor.edu/sites/default/files/field/image/Future%20of%20Software_Engineering%20%281%29.jpg", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSG9_zVer1g-5LmoH85NA8DOZ2BMciNAt8at3LRSlGygPpGreRieEFMCT6KRDF6ORx00xA&usqp=CAU", ScaleTypes.FIT));
        slideModels.add(new SlideModel("https://lsuonline-static.s3.amazonaws.com/media/images/2019/05/11/LIN_MSCivilEngineering_PPage.jpg", ScaleTypes.FIT));

        imageSlider.setImageList(slideModels,ScaleTypes.FIT);

        //I have same imageurl which will use in this slider.



        toggle  =new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.profile:

                        Toast.makeText(Dashboard.this, "Profile", Toast.LENGTH_SHORT).show();
                        Intent intent1=new Intent(Dashboard.this, Profile.class);
                        startActivity(intent1);
                        finish();
                        break;

                    case R.id.logout:
                        AlertDialog.Builder builder=new AlertDialog.Builder(Dashboard.this);
                        builder.setTitle("Logout");
                        builder.setMessage("Are you sure you went to Logout...");
                        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                FirebaseAuth .getInstance().signOut();
                                startActivity(new Intent(Dashboard.this,LogInActivity.class));
                                finish();
                            }
                        });
                        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        builder.show();

                        break;

                    case R.id.developer:
                        Toast.makeText(Dashboard.this, "Developer", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), Devloper.class));
                        break;

                    case R.id.holiday:
                        Toast.makeText(Dashboard.this, "Holiday", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), Holiday.class));
                        break;


                    case R.id.calender:
                        Toast.makeText(Dashboard.this, "Calender", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), Calender.class));
                        break;

                    case R.id.help:
                        Toast.makeText(Dashboard.this, "Help and Feedback", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), FeedBackFrom.class));
                        break;

                    case R.id.about:
                        Toast.makeText(Dashboard.this, "About App", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), AboutApp.class));
                        break;

                    case R.id.notifiaction:
                        Toast.makeText(Dashboard.this, "Notification", Toast.LENGTH_LONG).show();
                        startActivity(new Intent(getApplicationContext(), Notification.class));
                        break;


                }


                return true;
            }
        });

        //Website Code
        website.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Collage Website ", Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),Website.class);
                startActivity(intent);
               // overridePendingTransition(R.anim.left_to_rigth,R.anim.right_to_left);
            }
        });


        //questionPaper

        questionPaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Question Paper ", Toast.LENGTH_LONG).show();
                Intent intent2=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.akubihar.com/"));
                startActivity(intent2);
            }
        });

        //Result

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Result", Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(Intent.ACTION_VIEW, Uri.parse("https://results.akuexam.net/"));
                startActivity(intent1);
            }
        });



        //nptel
        nptel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "NPTEL", Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(Intent.ACTION_VIEW, Uri.parse("https://swayam.gov.in/"));
                startActivity(intent1);
            }
        });


        //syallbus
        syallbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Syallbus", Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(getApplicationContext(),Syllabus.class);
                startActivity(intent1);
            }
        });

        //faculties
        faculties.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Faculties", Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(getApplicationContext(), Faculties.class);
                startActivity(intent1);
            }
        });


        //E-Book
        ebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "E-Books", Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(getApplicationContext(), EBook.class);
                startActivity(intent1);
            }
        });

        //Formula
        formula.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Formula", Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(getApplicationContext(), Formula.class);
                startActivity(intent1);
            }
        });

        //Gate pass

        gatepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Gate Pass", Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(getApplicationContext(), GatePass.class);
                startActivity(intent1);
            }
        });


        //Placement
        place.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "Placement", Toast.LENGTH_LONG).show();
                Intent intent1=new Intent(getApplicationContext(), Placement.class);
                startActivity(intent1);
            }
        });

        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Dashboard.this, "MBIT Location", Toast.LENGTH_LONG).show();
                Intent intent5=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/maps/place/%E0%A4%8F%E0%A4%AE%E0%A4%AC%E0%A4%BF%E0%A4%9F/@26.3136504,87.2402647,17z/data=!4m6!3m5!1s0x39ef9f385f859d4f:0x274a5790bc1216fa!8m2!3d26.3136504!4d87.2428396!16s%2Fm%2F0wy504c?entry=ttu"));
                startActivity(intent5);
            }
        });


    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
       new AlertDialog.Builder(this)
               .setTitle(R.string.app_name)
               .setMessage("Do you want to exit the app ?")
               .setCancelable(false)
               .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                   @Override
                   public void onClick(DialogInterface dialog, int which) {
                       finish();
                   }
               })
               .setNegativeButton("No",null)
               .show();
    }
}