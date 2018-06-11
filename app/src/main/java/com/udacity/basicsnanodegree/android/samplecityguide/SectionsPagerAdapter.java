package com.udacity.basicsnanodegree.android.samplecityguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    private static final int LIST_ITEMS_FOR_EVENTS_TAB = 0;
    private static final int LIST_ITEMS_FOR_PARKS_TAB = 1;
    private static final int LIST_ITEMS_FOR_HISTORICAL_SITES_TAB = 2;
    private static final int LIST_ITEMS_FOR_HISTORICAL_PEOPLE_TAB = 3;

    SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        TourGuideFragment fragment = new TourGuideFragment();

        Bundle args = new Bundle();

        // Create an ArrayList of TourGuideItem objects
        ArrayList<TourGuideItem> tourGuideItems = new ArrayList<TourGuideItem>();

        switch (position) {
            case LIST_ITEMS_FOR_EVENTS_TAB:
                tourGuideItems.add(new TourGuideItem("Sample Event 1", "Sample Event 1's long description", R.drawable.sample_event_1));
                tourGuideItems.add(new TourGuideItem("Sample Event 2", "Sample Event 2's long description", R.drawable.sample_event_2));
                break;
            case LIST_ITEMS_FOR_PARKS_TAB:
                tourGuideItems.add(new TourGuideItem("Sample Park 1", "Sample Park 1's long description", R.drawable.sample_park_1));
                tourGuideItems.add(new TourGuideItem("Sample Park 2", "Sample Park 2's long description", R.drawable.sample_park_2));
                break;
            case LIST_ITEMS_FOR_HISTORICAL_SITES_TAB:
                tourGuideItems.add(new TourGuideItem("Sample Historical Site 1", "Sample Historical Site 1's description", R.drawable.sample_historical_site_1));
                tourGuideItems.add(new TourGuideItem("Sample Historical Site 2", "Sample Historical Site 2's description", R.drawable.sample_historical_site_2));
                break;
            case LIST_ITEMS_FOR_HISTORICAL_PEOPLE_TAB:
                tourGuideItems.add(new TourGuideItem("Historical person 1", "Historical person 1's biography", R.drawable.historical_person_1));
                tourGuideItems.add(new TourGuideItem("Historical person 2", "Historical person 2's biography", R.drawable.historical_person_2));
                tourGuideItems.add(new TourGuideItem("Historical person 3", "Historical person 3's biography", R.drawable.historical_person_3));
                tourGuideItems.add(new TourGuideItem("Historical person 4", "Historical person 4's biography", R.drawable.historical_person_4));
                break;
        }

        args.putParcelableArrayList("TOUR_GUIDE_ITEMS", tourGuideItems);

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }

}