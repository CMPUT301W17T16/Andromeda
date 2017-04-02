/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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


        final Intent intent = new Intent(this, ViewFriendActivity.class);
        followRequestList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Only if user clicks on other uses name
                //TODO: allow the user to go the the requester's main page.


            }
        });
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
