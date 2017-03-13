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

    protected User user;
    protected UserController userController;

    private ArrayList<User> userList;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);

        userController = ModelManager.getUserController();

        requests = (ListView) findViewById(R.id.notificationsList);
        Button accept = (Button) findViewById(R.id.acceptButton);
        Button decline = (Button) findViewById(R.id.declineButton);

        /**
         * When we accept a follow request, we will add that user to the
         * FollowingList
         */
        accept.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                // Need to get the userid that is beside the button.
                user = userController.getUser(1);
                addToFollowingList(user);
                //saveInFile();
            }
        });

        decline.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                user = userController.getUser(1);
                //Need to remove request from requests
                requests.remove(1);
                //saveInFile();
            }
        });
    }
    public void viewUser(String user) {
        return userController.getUser();
    }

    public void addToFollowingList(String user) {


    }

    public void getRequests() {
        return super.getRequests;
    }

    public void removeFollowingList() {

    }
}
