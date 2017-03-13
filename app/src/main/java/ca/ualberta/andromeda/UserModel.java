/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.content.Context;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/27.
 * <p>
 * The User model handles saving/loading the list of users
 */
public class UserModel implements Model<User> {
    private ArrayList<User> userList;
    private Gson gson;
    private final String FILENAME = "users.json";


    /**
     * Instantiates a new User model.
     */
    public UserModel(){
        this.gson = new Gson();
        this.loadList();
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

    public void deleteItem(User user){
        this.userList.remove(user);
        this.saveList();
    }

    public void loadList(){
        /* load from disk */
        this.userList = new ArrayList<User>();

        try {
            FileInputStream fis = ModelManager.getAppInstance().openFileInput(FILENAME);
            BufferedReader in = new BufferedReader(new InputStreamReader(fis));
            String line = in.readLine();
            while (line != null) {
                this.userList.add(this.gson.fromJson(line, User.class));
                line = in.readLine();
            }
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
            File file = new File(ModelManager.getAppInstance().getFilesDir(), FILENAME);
        }
    }

    public void saveList(){
        /* save to disk */
        try {
            FileOutputStream fos = ModelManager.getAppInstance().openFileOutput(FILENAME, Context.MODE_PRIVATE);
            int length = this.userList.size();
            for(int x=0; x<length; x++) {
                fos.write((this.gson.toJson(this.userList.get(x))+"\n").getBytes());
            }
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
