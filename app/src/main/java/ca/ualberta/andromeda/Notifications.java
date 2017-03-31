/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ListView;

import java.util.ArrayList;
//import UserController;

/**
 * Created by brettgarbitt on 2017-02-27.
 */
public class Notifications extends AndromedaActivity {
    private ArrayList<String> requests;
    private ArrayAdapter<String> adapter;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);

        final ListView followRequestList = (ListView) findViewById(R.id.requestList);
        Button acceptButton = (Button) findViewById(R.id.acceptButton);
        Button rejectButton = (Button) findViewById(R.id.rejectButton);

        /*
          - Need to populate a list with the user names of people who
            want to follow the current user.
          - place that list in the xml as an expandableListView.
          - create button clicker functions for accepting and rejecting
            the requests.
          - Both buttons will remove the user name associated with it
            on the xml list.
         */

        //populating list
        requests = getRequests();

        //putting list elements in ListView
        adapter = new ArrayAdapter<String>(this,
                R.layout.notifications, requests);
        followRequestList.setAdapter(adapter);

        //accept button
        //TODO: pass username into listener
        acceptButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                //need to add to followers
                //TODO: retrieve username connected to this button
                user.addFollower(user.getUsername());

                //need to remove from ListView
                //TODO: retrieve username connected to this button and update ListView
                requests.remove(user.getUsername());
                adapter.notifyDataSetChanged();
            }
        });

        //reject button
        rejectButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                //TODO: retrieve username connected to this button
                requests.remove(user.getUsername());
                adapter.notifyDataSetChanged();
            }
        });

        //Taken from MainPageActivity.java
        //When the username is selected, we go to their mood page
        final Intent intent = new Intent(this, ViewFriendActivity.class);
        followRequestList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Only if user clicks on other uses name
                intent.putExtra("user", user.getUsername());
                Mood mood = (Mood)parent.getItemAtPosition(position);
                intent.putExtra("ID", String.valueOf(mood.getId()));
                startActivity(intent);
            }
        });
    }

    /**
     * View user.
     *
     * @param User the user
     */
    public void viewUser(String User) {

    }

    /**
     * Add to following list.
     */
    public void addToFollowingList() {

    }

    /**
     * Gets requests.
     */
    public ArrayList<String> getRequests() {
        return user.getFollowerRequest();
    }

    /**
     * Remove following list.
     */
    public void removeFollowingList() {

    }
}
