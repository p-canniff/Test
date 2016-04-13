package com.example.philipcanniff.youtube_video_test;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

public class MainActivity extends Activity {

    Context mContext;
    ListView videoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = this;

        ConnectivityManager mgr = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (mgr != null) {
            NetworkInfo info = mgr.getActiveNetworkInfo();

            if (info != null) {
                if (info.isConnected()) {
                    Log.i("Connection Status", "Network is connected");

                    String redditURL = "https://www.googleapis.com/books/v1/volumes?q=android";

                   // YouTubeManager task = new YouTubeManager(redditURL, myGridView, mContext);

                   // task.execute();

                } else {

                    Log.i("Connect Status", "There is no network connection.");
                }

            } else{
                AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
                alert.setTitle("No Connection");
                alert.setMessage("Please find internet!");
                alert.show();
            }

        } else if (mgr == null) {

            AlertDialog.Builder alert = new AlertDialog.Builder(mContext);
            alert.setTitle("No Connection");
            alert.setMessage("Please find internet!");
            alert.show();

        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        Result_List_Fragment list = new Result_List_Fragment().newInstance();
        getFragmentManager().beginTransaction().replace(R.id.list_container, list, Result_List_Fragment.TAG).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
