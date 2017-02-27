package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/27.
 */
public class User {

    private String Username;
    private String Password;
    private ArrayList<String> Following;
    private ArrayList<String> FollowerRequest;


    public User(String Username, String Password,
                ArrayList<String> Following,
                ArrayList<String> FollowerRequest) {
        this.Username = Username;
        this.Password = Password;
        this.Following = Following;
        this.FollowerRequest = FollowerRequest;
    }

    public ArrayList<String> getFollowingList() { return this.Following; }

    public ArrayList<String> getFollowRequest() { return this.FollowerRequest;}

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
