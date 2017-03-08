package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/27.
 */
public class User {
    private String username;
    private String password;
    private ArrayList<String> following;
    private ArrayList<String> followerRequest;


    public User(String username, String password){
        this.username = username;
        this.password = password;
    }

    public User(String username, String password,
                ArrayList<String> following,
                ArrayList<String> followerRequest) {
        this.username = username;
        this.password = password;
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

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void addNewFollower(User user){
        following.add(user.getUsername());
    }

    public void addFollowRequest(User user){
        followerRequest.add(user.getUsername());
    }
}
