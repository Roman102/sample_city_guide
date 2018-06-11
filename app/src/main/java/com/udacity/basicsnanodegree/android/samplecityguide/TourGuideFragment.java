package com.udacity.basicsnanodegree.android.samplecityguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A tour fragment containing a simple view.
 */
public class TourGuideFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ArrayList<TourGuideItem> tourGuideItems = getArguments().getParcelableArrayList("TOUR_GUIDE_ITEMS");

        // Create an {@link TourGuideItemAdapter}, whose data source is a list of
        // {@link TourGuideItem}s. The adapter knows how to create list item views for each item
        // in the list.
        TourGuideItemAdapter tourGuideItemAdapter = new TourGuideItemAdapter(getActivity(), tourGuideItems);

        // Get a reference to the ListView, and attach the adapter to the listView.
        ListView listView = (ListView) rootView.findViewById(R.id.listview_flavor);
        listView.setAdapter(tourGuideItemAdapter);

        return rootView;
    }

}