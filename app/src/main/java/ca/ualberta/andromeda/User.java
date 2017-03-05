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

    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public ArrayList<User> getFollowing(){
        return this.following;
    }

    public ArrayList<User> getFollowRequest(){
        return this.followerRequest;
    }

    public void addNewFollower(User user){
        following.add(user);
    }

    public void addFollowRequest(User user){
        followerRequest.add(user);
    }
}
