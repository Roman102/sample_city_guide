package com.udacity.basicsnanodegree.android.samplecityguide;

import android.os.Parcel;
import android.os.Parcelable;

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

    private String mTitle;
    private String mDescription;

    // Drawable resource ID
    private int mImageResourceId;

    /*
     * Create a new TourGuideItem object.
     *
     * @param vTitle is a short title for the list item.
     * @param vDescription is a detailed description of the list item.
     * @param image is a drawable reference ID that corresponds to the list item.
     * */
    TourGuideItem(String vTitle, String vDescription, int imageResourceId) {
        mTitle = vTitle;
        mDescription = vDescription;
        mImageResourceId = imageResourceId;
    }

    private TourGuideItem(Parcel in) {
        mTitle = in.readString();
        mDescription = in.readString();
        mImageResourceId = in.readInt();
    }

    /**
     * Get the short title for the list item.
     */
    public String getTitle() {
        return mTitle;
    }

    /**
     * Get the detailed description of the list item.
     */
    public String getDescription() {
        return mDescription;
    }

    /**
     * Get the image resource ID
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mDescription);
        dest.writeInt(mImageResourceId);
    }

}
