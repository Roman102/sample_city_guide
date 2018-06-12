package com.udacity.basicsnanodegree.android.samplecityguide;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        /*
         *  Create the {@link android.support.v4.view.PagerAdapter} that will provide
         *  fragments for each of the sections. Use a
         *  {@link FragmentPagerAdapter} derivative, which will keep every
         *  loaded fragment in memory. If this becomes too memory intensive, it
         *  may be best to switch to a
         *  {@link android.support.v4.app.FragmentStatePagerAdapter}.
         *
         *  Set up the {@link ViewPager}, that will host the section contents, with the sections adapter.
         */

        ViewPager viewPager = findViewById(R.id.container);
        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), this));

        TabLayout tabLayout = findViewById(R.id.tabs);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
    }

}
