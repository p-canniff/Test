package com.example.philipcanniff.youtube_video_test;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by philipcanniff on 3/19/16.
 */
public class Result_List_Fragment extends ListFragment {

    public static final String TAG = "Result_List_Fragment.TAG";


    public static Result_List_Fragment newInstance(){

        Result_List_Fragment frag = new Result_List_Fragment();

        return frag;

    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //I have to grab the YouTube Object before setting the adapter
        ArrayAdapter<YouTube_Object> adapter = new ArrayAdapter<YouTube_Object>(getActivity(), android.R.layout.simple_list_item_1, DataManager.getInstance(getActivity()).getYouTube_Objects());
        setListAdapter(adapter);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //View view = inflater.inflate(R.layout.grid_layout, container, false);



        return view;
    }
}
