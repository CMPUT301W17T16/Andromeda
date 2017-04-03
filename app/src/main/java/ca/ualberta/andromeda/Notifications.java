/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by brettgarbitt on 2017-02-27.
 */
public class Notifications extends AndromedaActivity {
    private ArrayList<String> requests;
    private ListView followRequestList;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        followRequestList = (ListView) findViewById(R.id.requestList);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // get all the moods
        requests = user.getFollowerRequest();

        // https://stackoverflow.com/questions/17525886/listview-with-add-and-delete-buttons-in-each-row-in-android
        // Date: March 31, 2017
        CustomAdapter adapter = new CustomAdapter(requests, this, user.getUsername());
        followRequestList.setAdapter(adapter);
    }
}
