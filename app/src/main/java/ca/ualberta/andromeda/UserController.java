package ca.ualberta.andromeda;

/**
 * Created by pensk on 2017/02/27.
 */

import java.util.Date;

package ca.ualberta.andromeda;

import java.util.Date;

/**
 * Created by pensk on 2017/02/27.
 */

public class UserController {
    private UserModel model;

    public UserController(){
        model = new UserModel();
    }

    public void addUser(User User){
        model.getUsers().add(User);
    }

    public User getUser(int index){
        return model.getUsers().get(index);
    }

    public void deleteUser(int index){
        model.getUsers().remove(index);
    }
}

