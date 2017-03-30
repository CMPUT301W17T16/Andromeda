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
    private ArrayList<String> following;
    private ArrayList<String> followerRequest;
    @JestId
    private String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /**
     * Instantiates a new User.
     *
     * @param username the username
     */
    public User(String username){
        this.username = username;
        this.following = new ArrayList<String>();
        this.followerRequest = new ArrayList<String>();
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getFollower() {
        return following;
    }

    public ArrayList<String> getFollowerRequest() {
        return followerRequest;
    }

    public void addFollower(String following) {
        this.following.add(following);
    }

    public void addFollowerRequest(String requester) {
        this.followerRequest.add(requester);
    }

    public void deleteFollowerRequest(String requester){
        this.followerRequest.remove(requester);
    }

    public void unfollow(String unfollow){
        this.following.remove(unfollow);
    }

}
