/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

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

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
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

}
