package com.example.android.vipcare;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void animation_active(View v){

//        float deg = button.getRotation() + 180F;
        Animation animation = new AlphaAnimation(1.0f, 0.0f);
        animation.setDuration(1000);
        v.startAnimation(animation);
    }

    public void openInformation(View v){
        Intent intent = new Intent(this, Information.class);
        String message = "Hello Open the Information Page";
        intent.putExtra(EXTRA_MESSAGE, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void openReportCalender(View v){
        Intent intent = new Intent(this, Report.class);
        String message = "Hello Open the Report Page";
        intent.putExtra(EXTRA_MESSAGE, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

    }
}
