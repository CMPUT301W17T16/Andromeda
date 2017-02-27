package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/27.
 */
public class User {
    private String username;
    private String password;
    private ArrayList<User> following;
    private ArrayList<User> followerRequest;

    public User(){

    }

    public ArrayList<User> getFollowing(){
        return this.following;
    }

    public ArrayList<User> getFollowRequest(){

    }
}
