package com.udacity.basicsnanodegree.android.samplecityguide;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/*
 * {@link TourGuideItemAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
 * based on a data source, which is a list of {@link TourGuideItem} objects.
 * */
public class TourGuideItemAdapter extends ArrayAdapter<TourGuideItem> {

    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param tourGuideItems A List of TourGuideItem objects to display in a list
     */
    TourGuideItemAdapter(Activity context, ArrayList<TourGuideItem> tourGuideItems) {
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context, 0, tourGuideItems);
    }

    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position    The position in the list of data that should be displayed in the
     *                    list item view.
     * @param convertView The recycled view to populate.
     * @param parent      The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TourGuideItem.ViewHolderItem viewHolder;

        // Get the {@link TourGuideItem} object located at this position in the list
        TourGuideItem currentTourGuideItem = getItem(position);

        // Check if the existing view is being reused, otherwise inflate the view
        if (null == convertView) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);

            viewHolder = new TourGuideItem.ViewHolderItem();

            // Find the TextView in the list_item.xml layout with the ID title_
            viewHolder.titleTextView = convertView.findViewById(R.id.title_);

            // Find the TextView in the list_item.xml layout with the ID description_
            viewHolder.descriptionTextView = convertView.findViewById(R.id.description_);

            // Find the ImageView in the list_item.xml layout with the ID list_item_icon
            viewHolder.iconView = convertView.findViewById(R.id.list_item_icon);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (TourGuideItem.ViewHolderItem) convertView.getTag();
        }

        // Get the title from the current TourGuideItem object and
        // set this text on the title-TextView
        viewHolder.titleTextView.setText(currentTourGuideItem.getTitle());

        // Get the description from the current TourGuideItem object and
        // set this text on the description-TextView
        viewHolder.descriptionTextView.setText(currentTourGuideItem.getDescription());

        // Get the image resource ID from the current TourGuideItem object and
        // set the image to iconView
        viewHolder.iconView.setImageResource(currentTourGuideItem.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews and an ImageView)
        // so that it can be shown in the ListView
        return convertView;
    }

}
