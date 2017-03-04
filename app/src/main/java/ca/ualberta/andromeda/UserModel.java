package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/27.
 */
public class UserModel implements Model<User> {
    private ArrayList<User> userList;

    public UserModel(){
        this.userList = this.loadList();
    }

    public ArrayList<User> getList(){
        return this.userList;
    }

    public User getItem(int index){
        return this.userList.get(index);
    }

    public void addItem(User user){
        this.userList.add(user);
        this.saveList();
    }

    public void deleteItem(int index){
        this.userList.remove(index);
        this.saveList();
    }

    public ArrayList<User> loadList(){
        /* load from disk */
        return new ArrayList<User>();
    }

    public void saveList(){
        /* save to disk */
    }
}
