package com.udacity.basicsnanodegree.android.samplecityguide;

import android.content.Context;
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

    private final Context context;

    SectionsPagerAdapter(FragmentManager fm, Context c) {
        super(fm);

        context = c;
    }

    @Override
    public Fragment getItem(int position) {
        TourGuideFragment fragment = new TourGuideFragment();

        Bundle args = new Bundle();

        // Create an ArrayList of TourGuideItem objects
        ArrayList<TourGuideItem> tourGuideItems = new ArrayList<TourGuideItem>();

        switch (position) {
            case LIST_ITEMS_FOR_EVENTS_TAB:
                tourGuideItems.add(new TourGuideItem(context.getString(R.string.sample_event_1), context.getString(R.string.SAMPLE_EVENT_1_S_LONG_DESCRIPTION), R.drawable.sample_event_1));
                tourGuideItems.add(new TourGuideItem(context.getString(R.string.sample_event_2), context.getString(R.string.SAMPLE_EVENT_2_S_LONG_DESCRIPTION), R.drawable.sample_event_2));
                break;
            case LIST_ITEMS_FOR_PARKS_TAB:
                tourGuideItems.add(new TourGuideItem(context.getString(R.string.sample_park_1), context.getString(R.string.SAMPLE_PARK_1_S_LONG_DESCRIPTION), R.drawable.sample_park_1));
                tourGuideItems.add(new TourGuideItem(context.getString(R.string.sample_park_2), context.getString(R.string.SAMPLE_PARK_2_S_LONG_DESCRIPTION), R.drawable.sample_park_2));
                break;
            case LIST_ITEMS_FOR_HISTORICAL_SITES_TAB:
                tourGuideItems.add(new TourGuideItem(context.getString(R.string.sample_historical_site_1), context.getString(R.string.SAMPLE_HISTORICAL_SITE_1_S_DESCRIPTION), R.drawable.sample_historical_site_1));
                tourGuideItems.add(new TourGuideItem(context.getString(R.string.sample_historical_site_2), context.getString(R.string.SAMPLE_HISTORICAL_SITE_2_S_DESCRIPTION), R.drawable.sample_historical_site_2));
                break;
            case LIST_ITEMS_FOR_HISTORICAL_PEOPLE_TAB:
                tourGuideItems.add(new TourGuideItem(context.getString(R.string.historical_person_1), context.getString(R.string.HISTORICAL_PERSON_1_S_BIOGRAPHY), R.drawable.historical_person_1));
                tourGuideItems.add(new TourGuideItem(context.getString(R.string.historical_person_2), context.getString(R.string.HISTORICAL_PERSON_2_S_BIOGRAPHY), R.drawable.historical_person_2));
                tourGuideItems.add(new TourGuideItem(context.getString(R.string.historical_person_3), context.getString(R.string.HISTORICAL_PERSON_3_S_BIOGRAPHY), R.drawable.historical_person_3));
                tourGuideItems.add(new TourGuideItem(context.getString(R.string.historical_person_4), context.getString(R.string.HISTORICAL_PERSON_4_S_BIOGRAPHY), R.drawable.historical_person_4));
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