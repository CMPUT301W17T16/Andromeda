/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/27.
 */
public class User {
    private String username;
    private ArrayList<String> following;
    private ArrayList<String> followerRequest;

    public User(String username){
        this.username = username;
    }

    public User(String username,
                ArrayList<String> following,
                ArrayList<String> followerRequest) {
        this.username = username;
        this.following = following;
        this.followerRequest = followerRequest;
    }

    public ArrayList<String> getFollowingList() { return this.following; }

    public ArrayList<String> getFollowRequest() { return this.followerRequest;}

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getFollowing(){
        return this.following;
    }

    public void addNewFollower(User user){
        following.add(user.getUsername());
    }

    public void addFollowRequest(User user){
        followerRequest.add(user.getUsername());
    }
}
