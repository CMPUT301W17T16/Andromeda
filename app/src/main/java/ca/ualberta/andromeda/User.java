/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import java.util.ArrayList;

import io.searchbox.annotations.JestId;

/**
 * Created by pensk on 2017/02/27.
 */
public class User {
    private String username;
    //private ArrayList<String> following;
    //private ArrayList<String> followerRequest;
    @JestId
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public User(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
