package com.neart.tup.neart;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Tutor_MainActivity extends AppCompatActivity {

    private BottomNavigationView mBottomNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor_main);
        BottomNavigationView bottomNavigationView;
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.tutor_navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_tutor_sched);


        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        Fragment selectedFragment = null;
                        switch (item.getItemId()) {

                            case R.id.navigation_tutor_profile:
                                selectedFragment = Tutee_FragmentProfile.newInstance();
                                break;
                            case R.id.navigation_tutor_message:
                                selectedFragment = Tutee_FragmentMessage.newInstance();
                                break;
                            case R.id.navigation_tutor_sched:
                                selectedFragment = Tutee_FragmentSearch.newInstance();
                                break;
                            case R.id.navigation_tutor_notification:
                                selectedFragment = Tutee_FragmentNotification.newInstance();
                                break;
                            case R.id.navigation_tutor_more:
                                selectedFragment = Tutee_FragmentMore.newInstance();
                                break;


                        }

                        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();
                        return true;


                    }
                });

        //Manually displaying the first fragment - one time only
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_layout, Tutor_FragmentSched.newInstance());
        transaction.commit();

        //Used to select an item programmatically
        //bottomNavigationView.getMenu().getItem(2).setChecked(true);
    }
}

