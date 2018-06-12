package com.udacity.basicsnanodegree.android.samplecityguide;

import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * {@link TourGuideItem} is a list item with a description for an event, historical site, etc.
 * Each item has 3 properties: short title, detailed description and image resource ID.
 */
public class TourGuideItem implements Parcelable {

    public static final Creator<TourGuideItem> CREATOR = new Creator<TourGuideItem>() {

        @Override
        public TourGuideItem createFromParcel(Parcel in) {
            return new TourGuideItem(in);
        }

        @Override
        public TourGuideItem[] newArray(int size) {
            return new TourGuideItem[size];
        }

    };

    private String title;

    private String description;

    // Drawable resource ID
    private int imageResourceId;

    /*
     * Create a new TourGuideItem object.
     *
     * @param vTitle is a short title for the list item.
     * @param vDescription is a detailed description of the list item.
     * @param image is a drawable reference ID that corresponds to the list item.
     * */
    TourGuideItem(String vTitle, String vDescription, int imageResourceId) {
        title = vTitle;
        description = vDescription;
        this.imageResourceId = imageResourceId;
    }

    private TourGuideItem(Parcel in) {
        title = in.readString();
        description = in.readString();
        imageResourceId = in.readInt();
    }

    /**
     * Get the short title for the list item.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the detailed description of the list item.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return imageResourceId;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(description);
        dest.writeInt(imageResourceId);
    }

    // The ViewHolder caches the TextViews and ImageView.
    static class ViewHolderItem {

        public TextView titleTextView;
        public TextView descriptionTextView;
        public ImageView iconView;

    }

}
