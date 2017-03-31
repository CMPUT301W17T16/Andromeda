/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupWindow;

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


        followRequestList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Only if user clicks on other uses name


            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // get all the moods
        requests = user.getFollowerRequest();
        customAdapter adapter = new customAdapter(requests, this, user.getUsername());

        followRequestList.setAdapter(adapter);
    }
}
