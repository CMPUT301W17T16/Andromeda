/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
//import UserController;

/**
 * Created by brettgarbitt on 2017-02-27.
 */

public class Notifications extends Activity implements UserModel<UserController> {
    private ArrayList<String> requests;
    ArrayList<User> userList;
    UserController userController;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notifications);
        requests = (ListView) findViewById(R.id.notificationsList);
        Button accept = (Button) findViewById(R.id.acceptButton);
        Button decline = (Button) findViewById(R.id.declineButton);
    }
    public void viewUser(String User) {

    }

    public void addToFollowingList() {

    }

    public void getRequests() {

    }

    public void removeFollowingList() {

    }
}
