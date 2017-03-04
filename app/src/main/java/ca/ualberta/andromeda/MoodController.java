package ca.ualberta.andromeda;

import java.util.Date;

/**
 * Created by pensk on 2017/02/27.
 */

public class MoodController {
    private MoodModel moodModel;
    private UserModel userModel;

    public MoodController(){
        moodModel = ModelManager.getMoodModel();
        userModel = ModelManager.getUserModel();
    }

    public void addMood(Mood mood){
        moodModel.addItem(mood);
    }

    public Mood getMood(int index){
        return moodModel.getItem(index);
    }

    public void updateMood(int index, User user, String situation, Date date){
        moodModel.getItem(index).edit(user, situation, date);
    }

    public void deleteMood(int index){
        moodModel.deleteItem(index);
    }
}
