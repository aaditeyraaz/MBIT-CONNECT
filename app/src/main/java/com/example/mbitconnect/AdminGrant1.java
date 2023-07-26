package com.example.mbitconnect;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.FrameLayout;

import com.google.android.material.tabs.TabLayout;

public class AdminGrant1 extends AppCompatActivity {
    Toolbar toolbar2;
    ViewPager viewPager;
    AdminAdpator myAdapter;
    TabLayout tabLayout;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_grant1);

        toolbar2 = (Toolbar) findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar2);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        if (getSupportActionBar() != null) {

            getSupportActionBar().setTitle("GATE PASS");
        }

        //GARNT NAME

            tabLayout = (TabLayout) findViewById(R.id.tablayout);
            frameLayout = (FrameLayout) findViewById(R.id.framelayout);

            TabLayout.Tab firstTab = tabLayout.newTab();
            firstTab.setText("Scanner");
            tabLayout.addTab(firstTab);

            TabLayout.Tab Secondtab = tabLayout.newTab();
            Secondtab.setText("Grant By");
            tabLayout.addTab(Secondtab);

            AdminScannerFragment fragment = new AdminScannerFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.add(R.id.framelayout, fragment);
            ft.commit();

        // Receive data from the Intent

        Bundle bundle = getIntent().getExtras();

      if (bundle != null) {
            String pname = bundle.getString("name");

          //   Create a fragment instance and pass the data as arguments
            AdminScannerFragment profileFragment = new AdminScannerFragment();
            Bundle fragmentArgs = new Bundle();
            fragmentArgs.putString("username", pname);
            profileFragment.setArguments(fragmentArgs);

            // Perform fragment transaction to show the fragment
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.framelayout, profileFragment)
                    .commit();


        }

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                @Override
                public void onTabSelected(TabLayout.Tab tab) {


                    switch (tab.getPosition()) {
                        case 0:
                            String pname = bundle.getString("name");
                            AdminScannerFragment fragment = new AdminScannerFragment();
                            FragmentManager fm = getSupportFragmentManager();
                            FragmentTransaction ft = fm.beginTransaction();
                            Bundle fragmentArgs = new Bundle();
                            fragmentArgs.putString("username", pname);
                            fragment.setArguments(fragmentArgs);
                            ft.replace(R.id.framelayout, fragment);
                            ft.commit();
                            break;

                        case 1:
                            AdminDataFragment fragment1 = new AdminDataFragment();
                            FragmentManager fm1 = getSupportFragmentManager();
                            FragmentTransaction ft1 = fm1.beginTransaction();
                            ft1.replace(R.id.framelayout, fragment1);
                            ft1.commit();
                            break;
                    }
                }

                @Override
                public void onTabUnselected(TabLayout.Tab tab) {

                }

                @Override
                public void onTabReselected(TabLayout.Tab tab) {

                }
            });

        }

        @Override
        public boolean onSupportNavigateUp () {
            onBackPressed();
            return super.onSupportNavigateUp();
        }
    }

