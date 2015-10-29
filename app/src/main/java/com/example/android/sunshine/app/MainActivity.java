package com.example.android.sunshine.app;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Forecasts to show in the main activity.
            ArrayList<String> forecasts = new ArrayList<String>();
            forecasts.add("Today -- Sunny");
            forecasts.add("Monday -- Rainy");
            forecasts.add("Tuesday -- Snow");
            forecasts.add("Wednesday -- Hurricane");

            String[] forecasts2 = {
                    "Today -- Sunny -- 76/50",
                    "Monday -- Rainy -- 55/40",
                    "Tuesday -- Snow -- 26/17",
                    "Wednesday -- Hurricane -- 60/50",
                    "Thursday -- Eclipse -- 66/13",
                    "Friday -- Full Moon -- 59/49",
                    "Saturday -- Hot -- 110/90",
                    "Sunday -- Windy -- 80/70",
                    "Halloween -- Sweet -- 76/65"
            };

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                    this.getActivity(),
                    R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,
                    forecasts2
            );

            // This is the fragment itself.
            View fragment = inflater.inflate(R.layout.fragment_main, container, false);

            // We get the activity this fragment is a part of.
            // Then we look up a widget in the activity by id.
            // Then we bind a data set to that view widget via an adapter.
            ListView v = (ListView) fragment.findViewById(R.id.listview_forecast);
            v.setAdapter(adapter);

            return fragment;
        } // onCreateView(...)
    } // class PlaceholderFragment
} // class MainActivity
