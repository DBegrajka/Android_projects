package com.example.android.vipcare;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.Vector;


public class Information extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);


        /*
        * dInitialize the Fragment to be paged
         */

        List<Fragment> fragments = new Vector<>();
        fragments.add(Fragment.instantiate(this, video_fragement.class.getName()));
        fragments.add(Fragment.instantiate(this, info_fragement.class.getName()));
        fragments.add(Fragment.instantiate(this, image_fragement.class.getName()));
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), fragments);
        final ViewPager pager = (ViewPager) findViewById(R.id.viewpager);
        pager.setAdapter(adapter);

        final ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.TabListener tabListener = new ActionBar.TabListener(){
            @Override
            public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft){
                pager.setCurrentItem(tab.getPosition());
            }
            public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft){

            }
            public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft){

            }
        };

        actionBar.addTab(actionBar.newTab().setText("Video").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Info").setTabListener(tabListener));
        actionBar.addTab(actionBar.newTab().setText("Image").setTabListener(tabListener));

        pager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener(){
            public void onPageSelected(int Position){
                actionBar.setSelectedNavigationItem(Position);
            }
        });
    }
}