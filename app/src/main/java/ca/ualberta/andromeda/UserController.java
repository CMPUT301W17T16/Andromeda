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

    public UserController(){
        this.userModel = ModelManager.getUserModel();
        this.moodModel = ModelManager.getMoodModel();
    }

    public Boolean hasUser(User user){
        return userModel.getList().contains(user);
    }

    public Boolean hasUser(String username){
        return userModel.getList().contains(this.getUserByUsername(username));
    }

    public User createUser(String username){
        User user = new User(username);
        this.addUser(user);
        return user;
    }

    public void addUser(User User){
        userModel.addItem(User);
    }

    public User getUser(int index){
        return userModel.getItem(index);
    }

    public void deleteUser(int index){
        userModel.deleteItem(index);
    }

    public void deleteUser(User user) { userModel.deleteItem(user); }

    public void deleteUserByUsername(String username){
        User user = this.getUserByUsername(username);
    }

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

    public ArrayList<Mood> getMoodList(User user){
        ArrayList<Mood> myList = new ArrayList<Mood>();
        ArrayList<Mood> moodList = moodModel.getList();
        return moodList;
    }
}

