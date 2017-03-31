/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

/**
 * Created by pensk on 2017/02/27.
 */

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pensk on 2017/02/27.
 */
public class UserController {
    private UserModel userModel;
    private MoodModel moodModel;

    /**
     * Instantiates a new User controller.
     */
    public UserController(){
        this.userModel = ModelManager.getUserModel();
        this.moodModel = ModelManager.getMoodModel();
    }

    /**
     * Has user boolean.
     *
     * @param user the user
     * @return the boolean
     */
    public Boolean hasUser(User user){
        return userModel.getList().contains(user);
    }

    /**
     * Has user boolean.
     *
     * @param username the username
     * @return the boolean
     */
    public Boolean hasUser(String username){
        return userModel.getList().contains(this.getUserByUsername(username));
    }

    /**
     * Create user user.
     *
     * @param username the username
     * @return the user
     */
    public User createUser(String username){
        User user = new User(username);
        this.addUser(user);
        return user;
    }

    /**
     * Add user.
     *
     * @param User the user
     */
    public void addUser(User User){
        userModel.addItem(User);
    }

    /**
     * Get user user.
     *
     * @param index the index
     * @return the user
     */
    public User getUser(int index){
        return userModel.getItem(index);
    }

    /**
     * Delete user.
     *
     * @param index the index
     */
    public void deleteUser(int index){
        userModel.deleteItem(index);
    }

    /**
     * Delete user.
     *
     * @param user the user
     */
    public void deleteUser(User user) { userModel.deleteItem(user); }

    /**
     * Delete user by username.
     *
     * @param username the username
     */
    public void deleteUserByUsername(String username){
        User user = this.getUserByUsername(username);
    }

    /**
     * Gets user by username.
     *
     * @param username the username
     * @return the user by username
     */
    public User getUserByUsername(String username) { // throws UserNotFoundException{
        ArrayList<User> list = userModel.getList();
        int length = list.size();

        for(int x=0; x<length; x++){
            if(list.get(x).getUsername().equals(username)){
                return list.get(x);
            }
        }

        return null;
    }

    /**
     * Get mood list array list.
     *
     * @param user the user
     * @return the array list
     */
    public ArrayList<Mood> getMoodList(User user){
        ArrayList<Mood> myList = new ArrayList<Mood>();
        ArrayList<Mood> moodList = moodModel.getList();
        return moodList;
    }

    public void sendFollowRequest(String requester, User user){
        user.addFollowerRequest(requester);
        int index = this.getPosition(user.getUsername());
        userModel.updateItem(user, index);
    }

    public void acceptFollowRequest(User requester, String user){
        requester.addFollower(user);
        int index = this.getPosition(requester.getUsername());
        userModel.updateItem(requester, index);
    }

    // TODO: Brett use this method to decline requests
    public void declineFollowRequest(String requester, User user){
        user.deleteFollowerRequest(requester);
        int index = this.getPosition(user.getUsername());
        userModel.updateItem(user, index);
    }

    public void unfollow(User user, String unfollow){
        user.unfollow(unfollow);
        int index = this.getPosition(user.getUsername());
        userModel.updateItem(user, index);
    }

    public Integer getPosition(String id) {
        ArrayList<Mood> moodList = moodModel.getList();
        for(int x=0; x<moodList.size(); x++){
            if(moodList.get(x).getId().equals(id)){
                return x;
            }
        }
        return 0;
    }
}

