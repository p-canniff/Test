package com.example.philipcanniff.youtube_video_test;

import android.content.Context;
import android.os.AsyncTask;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.ListView;

import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by philipcanniff on 3/18/16.
 */
public class YouTubeManager extends AsyncTask<String, Void, String> {

    String mUrl;
    ListView yVideoList;
    Context mContext;
    ArrayList<String> myAuthors;
    ArrayList<YouTube_Object> yVideos;
    VideoAdapter vAdapter;

    @Override
    protected String doInBackground(String... params) {

        yVideos = new ArrayList<>();

        try{

            URL url = new URL(mUrl);

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.connect();

            InputStream is = connection.getInputStream();

            String data = IOUtils.toString(is);

            is.close();

            connection.disconnect();

            return data;


        } catch(IOException e) {

            e.printStackTrace();

        }

        return null;

    }

    @Override
    protected void onPostExecute(String s) {

        Log.i("App Status", "Parse" +
                "\n Remote Data");

        try {

            JSONObject outObj = new JSONObject(s);

            JSONArray dataArray = outObj.getJSONArray("items");

            Log.i("ENTRIES: ",  dataArray.length() + "");


            for(int i = 0; i < dataArray.length(); i++){

                myAuthors = new ArrayList<>();

                JSONObject postPosition = dataArray.getJSONObject(i);

                JSONObject postData = postPosition.getJSONObject("volumeInfo");

                JSONObject postImageData = postData.getJSONObject("imageLinks");

                JSONArray postAuthors = postData.getJSONArray("authors");

                String postImage = postImageData.getString("thumbnail");

                String postTitle = postData.getString("title");

                Log.i("ENTRIES: ",  postTitle + "");


                for (int f = 0; f < postAuthors.length(); f++){
                    if (f >= 1){

                        myAuthors.add(", \n");

                    }
                    String postAuthor = postAuthors.getString(f);

                    myAuthors.add(postAuthor);

                }

                YouTube_Object video = new YouTube_Object("", "", 0);
                yVideos.add(video);

            }

            vAdapter = new VideoAdapter(mContext, yVideos);
            yVideoList.setAdapter(vAdapter);

        } catch(JSONException e ){

            e.printStackTrace();

        }

    }

    public YouTubeManager(String mUrl, ListView yVideoList, Context mContext) {
        this.mUrl = mUrl;
        this.yVideoList = yVideoList;
        this.mContext = mContext;
    }





}
