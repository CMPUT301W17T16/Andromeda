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
        super.onCreate();
        appInstance = this;
    }

    /**
     * Get user model user model.
     *
     * @return the user model
     */
    public static UserModel getUserModel(){
        if(userModel == null){
            userModel = new UserModel();
        }
        return userModel;
    }

    /**
     * Get user controller user controller.
     *
     * @return the user controller
     */
    public static UserController getUserController(){
        if(userController == null){
            userController = new UserController();
        }
        return userController;
    }

    /**
     * Get mood model mood model.
     *
     * @return the mood model
     */
    public static MoodModel getMoodModel(){
        if(moodModel == null){
            moodModel = new MoodModel();
        }
        return moodModel;
    }

    /**
     * Get mood controller mood controller.
     *
     * @return the mood controller
     */
    public static MoodController getMoodController(){
        if(moodController == null){
            moodController = new MoodController();
        }
        return moodController;
    }

    /**
     * Get app instance model manager.
     *
     * @return the model manager
     */
    public static ModelManager getAppInstance(){
        return appInstance;
    }

}
