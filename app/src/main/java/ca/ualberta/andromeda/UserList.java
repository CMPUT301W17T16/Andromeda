package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by Jeff on 2/27/2017.
 */

public class UserList {
    private ArrayList<User> users = new ArrayList<User>();

    public void add(User user){

        if (hasUser(user)){
            throw new IllegalArgumentException();
        }else{
            users.add(user);
        }
    }

    public boolean hasUser(User user){
        return users.contains(user);
    }

    public void delete(User user){

        users.remove(user);
    }

    public User getUser(int index){

        return  users.get(index);
    }

    public ArrayList<User> getTweets(){
        return users;
    }

    public int getCount(){
        return users.size();
    }
}
