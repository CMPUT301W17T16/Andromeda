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

//    public Mood createMood(String user, String socialSituation, Emotion.State state, Date date) {
//        Mood newMood = new Mood(user, socialSituation, date, state);
//        this.addMood(newMood);
//        return newMood;
//    }

    public Mood createMood(String user, Date date, String mood, String socialSituation, String trigger, String detail){
        Mood newMood = new Mood(user, date, mood, socialSituation, trigger, detail);
        this.addMood(newMood);
        return newMood;
    }

    public ArrayList<Mood> getUserMoods(User user){
        ArrayList<Mood> moodList = moodModel.getList();
        ArrayList<Mood> userMoods = new ArrayList<Mood>();
        for(int x=0; x<moodList.size(); x++){
            if(moodList.get(x).getUser().equals(user.getUsername())){
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

    public void updateMood(int index, String user,  Date date, String mood, String socialSituation, String trigger, String detail){
        moodModel.getItem(index).edit(user, date, mood, socialSituation, trigger, detail);
    }

    public void deleteMood(int index){
        moodModel.deleteItem(index);
    }

    public void deleteMood(Mood mood){
        moodModel.deleteItem(mood);
    }
}
