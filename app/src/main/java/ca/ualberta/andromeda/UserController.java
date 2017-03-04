package ca.ualberta.andromeda;

/**
 * Created by pensk on 2017/02/27.
 */

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pensk on 2017/02/27.
 */

public class UserController {
    private UserModel model;

    public UserController(){
        model = new UserModel();
    }

    public Boolean hasUser(User user){
        return model.getList().contains(user);
    }

    public void addUser(User User){
        model.addItem(User);
    }

    public User getUser(int index){
        return model.getItem(index);
    }

    public void deleteUser(int index){
        model.deleteItem(index);
    }

    public User getUserByUsername(String username) { // throws UserNotFoundException{
        ArrayList<User> list = model.getList();
        int length = list.size();

        for(int x=0; x<length; x++){
            if(list.get(x).getUsername().equals(username)){
                return list.get(x);
            }
        }

        return null;
    }
}

