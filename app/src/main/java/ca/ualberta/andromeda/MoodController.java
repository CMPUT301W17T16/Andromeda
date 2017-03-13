/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

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

    public Mood createMood(String user, String socialSituation, Emotion.State state, String trigger, String detail){
        String id = getUniqueId();
        Mood newMood = new Mood(user, socialSituation, new Date(), state, trigger, detail, id);
        this.addMood(newMood);
        return newMood;
    }

    public Mood createMood(String user, String socialSituation, Emotion.State state, String trigger, String detail, String MyLocation){
        String id = getUniqueId();
        Mood newMood = new Mood(user, socialSituation, new Date(), state, trigger, detail, id, MyLocation);
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

    public void updateMood(int index, String user, String situation, Date date, Emotion.State state, String trigger, String detail){
        moodModel.getItem(index).edit("adfgh", situation, date, state, trigger, detail);
    }

    public void deleteMood(int index){
        moodModel.deleteItem(index);
    }

    public void deleteMood(Mood mood){
        moodModel.deleteItem(mood);
    }

    /**
     * http://stackoverflow.com/questions/1389736/how-do-i-create-a-unique-id-in-java
     * date: March 13, 2017
     * Time: 1:16 PM
     */
    public String getUniqueId() {
        String id = UUID.randomUUID().toString();
        return id;
    }

    public Integer getPosition(String id) {
        ArrayList<Mood> moodList = moodModel.getList();
        for(int x=0; x<moodList.size(); x++){
            if(moodList.get(x).getId().equals(id)){
                return x;
            }
        }
        return 0;
    }
}
