package com.example.android.vip_care;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawyerLayout);

        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        setSupportActionBar(mToolbar);

        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);

        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        mToolbar = (Toolbar) findViewById(R.id.nav_action);
        if (mToolbar != null) {

            setSupportActionBar(mToolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void animation_active(View v){

//        float deg = button.getRotation() + 180F;
        Animation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(1000);
        v.startAnimation(animation);
    }


    public void send_message(View v){
        String number = "12346556";  // The number on which you want to send SMS
        startActivity(new Intent(Intent.ACTION_VIEW, Uri.fromParts("sms", number, null)));

    }

    public void call(View v){
        String number = "+18032616288";  // The number on which you want to send SMS

        startActivity(new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", number, null)));
    }

    public void open_map(View v){

        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:47.6, -122.3"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    public void openInformation(View v){
            Intent intent = new Intent(this, Information.class);
            String message = "Hello Open the Information Page";
            intent.putExtra(EXTRA_MESSAGE, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }

}
