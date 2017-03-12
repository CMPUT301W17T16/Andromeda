/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import java.util.ArrayList;
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

    public Mood createMood(User user, String socialSituation, Emotion.State state, Date date) {
        Mood newMood = new Mood(user, socialSituation, date, state);
        this.addMood(newMood);
        return newMood;
    }

    public Mood createMood(User user, String socialSituation, Emotion.State state){
        Mood newMood = new Mood(user, socialSituation, new Date(), state);
        this.addMood(newMood);
        return newMood;
    }

    public ArrayList<Mood> getUserMoods(User user){
        ArrayList<Mood> moodList = moodModel.getList();
        ArrayList<Mood> userMoods = new ArrayList<Mood>();
        for(int x=0; x<moodList.size(); x++){
            if(moodList.get(x).getUser() == user){
                userMoods.add(moodList.get(x));
            }
        }
        return userMoods;
    }

    public ArrayList<Mood> getAllMoods(){
        return moodModel.getList();
    }

    public Mood getMood(int index){
        return moodModel.getItem(index);
    }

    public void addMood(Mood mood){
        moodModel.addItem(mood);
    }

    public void updateMood(int index, User user, String situation, Date date){
        moodModel.getItem(index).edit(user, situation, date);
    }

    public void deleteMood(int index){
        moodModel.deleteItem(index);
    }

    public void deleteMood(Mood mood){
        moodModel.deleteItem(mood);
    }
}
