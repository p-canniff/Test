package com.example.philipcanniff.youtube_video_test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by philipcanniff on 3/19/16.
 */
public class VideoAdapter extends BaseAdapter {

    String authorString;
    Context mContext;
    ArrayList<YouTube_Object> mClass;


    public VideoAdapter(Context c, ArrayList<YouTube_Object> m) {
        this.mContext = c;
        this.mClass = m;
    }

    static class ViewHolder {
        public TextView mTitle;
        public TextView mPoster;
        public TextView mDuration;
        public ImageView mPreviewImage;

        public ViewHolder(View v) {
            mTitle = (TextView) v.findViewById(R.id.Title);
            mPoster = (TextView) v.findViewById(R.id.Poster);
            mDuration = (TextView) v.findViewById(R.id.Duration);
            mPreviewImage = (ImageView) v.findViewById(R.id.previewImage);

        }

    }

    @Override
    public int getCount() {
        if (mClass != null) {
            return mClass.size();
        } else {
            return 0;
        }
    }

    @Override
    public Object getItem(int position) {
        if (mClass != null && position < mClass.size() && position >= 0) {

            return mClass.get(position);

        }
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        // If convertView doesn't already exist....

        if (convertView == null) {

            //Create ConvertView from the row layout
            convertView = LayoutInflater.from(mContext).inflate(R.layout.youtube_item, parent, false);


            //Assign convertView toViewHolder
            holder = new ViewHolder(convertView);

            //Set Tag for ViewHolder
            convertView.setTag(holder);
        } else {

            // Otherwise return existing convertView
            holder = (ViewHolder) convertView.getTag();
        }

        //Assign Crew Member Details to row
        YouTube_Object member = (YouTube_Object) getItem(position);

        //SETUP GRID UI BUILD HERE
        holder.mTitle.setText(member.getVideoTitle());

        return convertView;
    }



}
