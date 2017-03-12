/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.app.Application;

/**
 * Created by pensk on 2017/03/04.
 */

public class ModelManager extends Application {
    private static MoodModel moodModel;
    private static UserModel userModel;
    private static MoodController moodController;
    private static UserController userController;

    private static ModelManager appInstance;

    public void onCreate(){
        appInstance = this;
    }

    public static UserModel getUserModel(){
        if(userModel == null){
            userModel = new UserModel();
        }
        return userModel;
    }

    public static UserController getUserController(){
        if(userController == null){
            userController = new UserController();
        }
        return userController;
    }

    public static MoodModel getMoodModel(){
        if(moodModel == null){
            moodModel = new MoodModel();
        }
        return moodModel;
    }

    public static MoodController getMoodController(){
        if(moodController == null){
            moodController = new MoodController();
        }
        return moodController;
    }

    public static ModelManager getAppInstance(){
        return appInstance;
    }

}
