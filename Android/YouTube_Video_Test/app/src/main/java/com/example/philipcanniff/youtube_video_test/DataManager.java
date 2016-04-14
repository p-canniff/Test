package com.example.philipcanniff.youtube_video_test;

import android.content.Context;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Created by philipcanniff on 3/18/16.
 */
public class DataManager {

    public static DataManager INSTANCE = null;

    Context context;

    ArrayList<YouTube_Object> saveArray;

    private DataManager(Context c){

        this.context = c;
        saveArray = new ArrayList<YouTube_Object>();

    }

    public static DataManager getInstance(Context c){

        if (INSTANCE == null){

            INSTANCE = new DataManager(c);

        }

        return INSTANCE;

    }

    public void updateYouTube_Object(YouTube_Object _YouTube_Object, int _placement){

        saveArray = getYouTube_Objects();
        saveArray.remove(_placement);
        saveArray.add(_placement, _YouTube_Object);
        saveYouTube_ObjectArray(saveArray);


    }
    public void appendYouTube_Object(YouTube_Object _YouTube_Object){

        saveArray = getYouTube_Objects();
        saveArray.add(_YouTube_Object);
        saveYouTube_ObjectArray(saveArray);


    }
    public void saveYouTube_ObjectArray(ArrayList<YouTube_Object> _YouTube_Object){

        String filename = "TechYouTube_Object.bin";
        FileOutputStream fos;

        try {

            fos = context.openFileOutput(filename, Context.MODE_PRIVATE);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(saveArray);

            Log.i("Saved", "Successfully Saved to Storage");


        } catch(Exception e ){

            Log.i("Failed to Save", "Failed Saving to Storage");
            e.printStackTrace();

        }

    }
    public void deleteYouTube_Objects(int _placement){

        saveArray = getYouTube_Objects();

        saveArray.remove(_placement);

        saveYouTube_ObjectArray(saveArray);

    }

    public ArrayList<YouTube_Object> getYouTube_Objects(){

        ArrayList<YouTube_Object> storedArray;

        String filename = "TechYouTube_Object.bin";

        try {

            FileInputStream inputStream = context.openFileInput(filename);
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            saveArray = (ArrayList<YouTube_Object>) ois.readObject();

            Log.i("Loaded YouTube_Objects", "YouTube_Objects Loaded Successfully");
            ois.close();

            return saveArray;

        } catch(Exception e ) {

            saveArray = new ArrayList<>();


            Log.i("Failed to Load", "Failed to Load YouTube_Object Array");
            e.printStackTrace();

            return saveArray;

        }

    }

}
