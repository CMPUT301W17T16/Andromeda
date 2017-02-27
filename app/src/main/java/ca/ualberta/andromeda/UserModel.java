package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/27.
 */
public class UserModel {
    private ArrayList<User> userList;

    public UserModel(){
        this.userList = this.loadUsers();
    }

    public ArrayList<User> getUsers(){
        return this.userList;
    }

    public ArrayList<User> loadUsers(){
        /* load from disk */
        return new ArrayList<User>();
    }

    public void saveUsers(){
        /* save to disk */
    }
}
