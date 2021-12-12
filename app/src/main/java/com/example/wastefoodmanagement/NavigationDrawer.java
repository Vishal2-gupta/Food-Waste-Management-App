package com.example.wastefoodmanagement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class NavigationDrawer extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);
        drawerLayout=findViewById(R.id.d1);
        navigationView=findViewById(R.id.n1);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.h1:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame,new FoodFragment()).commit();
                        Toast.makeText(getApplicationContext(),"HomePage",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.f1:
                        Intent i=new Intent(NavigationDrawer.this,AddDonationInfo.class);
                        startActivity(i);
                        break;
                    case R.id.l2:
                        Intent i3=new Intent(NavigationDrawer.this,MainActivity.class);
                        startActivity(i3);
                        break;
                    case R.id.l1:
                        Intent i1=new Intent(NavigationDrawer.this,RateUs.class);
                        startActivity(i1);
                        break;
                    case R.id.r1:
                        Toast.makeText(getApplicationContext(),"Page is refresh",Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.s1:
                        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                        sharingIntent.setType("text/plain");
                        String shareBody = "Your body here";
                        String shareSub = "Your subject here";
                        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
                        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                        startActivity(Intent.createChooser(sharingIntent, "Share using"));
                        break;
                    case R.id.s3:
                        Intent intent = new Intent(Intent.ACTION_DIAL);
                        intent.setData(Uri.parse("tel:3434 455555"));
                        startActivity(intent);
                        Toast.makeText(NavigationDrawer.this, " Helpline Number", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.s4:
                        Intent i5=new Intent(NavigationDrawer.this,LoginPage.class);
                        startActivity(i5);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        drawerToggle=new ActionBarDrawerToggle(this, drawerLayout, R.string.drawer_open, R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        if(savedInstanceState==null){
            getSupportFragmentManager().beginTransaction().replace(R.id.frame,new FoodFragment()).commit();
            navigationView.setCheckedItem(R.id.n1);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}