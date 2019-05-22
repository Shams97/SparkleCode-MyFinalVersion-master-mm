package com.example.shms.trying;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class Nav extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
private DrawerLayout drawer;
Button pyth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nav);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        pyth=(Button)findViewById(R.id.pyth);

        drawer = findViewById(R.id.drawer_layout);
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,new home_fragment());


        NavigationView navigationView =findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

pyth.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new level_fragment()).commit();
    }
});
//        if (savedInstanceState == null) {
//            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
//                    new home_fragment()).commit();
//                  navigationView.setCheckedItem(R.id.nav_home);
//        }
    }
    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_home:
               startActivity(new Intent(this,Nav.class));
                break;
            case R.id.nav_levels:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new level_fragment()).commit();
                break;
            case R.id.nav_about:
//                startActivity(new Intent(Nav.this,AboutScrollingActivity.class));
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new aboutFragment()).commit();
                break;
            case R.id.nav_help:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new help_fragment()).commit();
                break;
            case R.id.nav_logOut:
                AlertDialog alertDialog = new AlertDialog.Builder(Nav.this).create();
                alertDialog.setTitle("Contact");
                alertDialog.setMessage("Are you sure you want to logOut?");
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "logOut", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        logOut();
                    }
                });
                alertDialog.show();
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void logOut() {
        FirebaseAuth.getInstance().signOut();
        Intent i=new Intent(getApplicationContext(),first.class);
        startActivity(i);

    }
}
