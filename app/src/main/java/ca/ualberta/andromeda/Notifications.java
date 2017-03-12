/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by brettgarbitt on 2017-02-27.
 */

public class Notifications extends AndromedaActivity {
    private ArrayList<User> requests;
    private String username;
    ArrayList<User> userList;
    UserController userController;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        requests = (ListView) findViewById(R.id.notificationsList);
        Button accept = (Button) findViewById(R.id.acceptButton);
        Button decline = (Button) findViewById(R.id.declineButton);

        /**
         * When we accept a follow request, we will add that user to the
         *
         */
        acceptButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                tweetList.clear();
                adapter.notifyDataSetChanged();
                //saveInFile();
            }
        });

        declineButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                tweetList.clear();
                adapter.notifyDataSetChanged();
                //saveInFile();
            }
        });
    }
    public void viewUser(String User) {
        username = super.getUser();
    }

    public void addToFollowingList() {

    }

    public void getRequests() {
        return super.getRequests;
    }

    public void removeFollowingList() {

    }
}
