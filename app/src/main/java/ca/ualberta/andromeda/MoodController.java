/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.graphics.Bitmap;
import android.net.Uri;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class MoodController {
    private MoodModel moodModel;
    private UserModel userModel;

    public MoodController(){
        moodModel = ModelManager.getMoodModel();
        userModel = ModelManager.getUserModel();
    }

    public Mood createMood(String user, String socialSituation, Emotion.State state, String trigger, String detail){
        //String id = getUniqueId();
        Mood newMood = new Mood(user, socialSituation, new Date(), state, trigger, detail);
        this.addMood(newMood);
        return newMood;
    }

    public Mood createMood(String user, String socialSituation, Emotion.State state, String trigger, String detail, String MyLocation){
        //String id = getUniqueId();
        Mood newMood = new Mood(user, socialSituation, new Date(), state, trigger, detail, MyLocation);
        this.addMood(newMood);
        return newMood;
    }

    public void addImage(Bitmap image){
        moodModel.getItem(0).addImage(image);
        moodModel.saveList();
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

    public Mood getMood(String id) {
        for (int x = 0; x < moodModel.getList().size(); x++) {
            if (moodModel.getItem(x).getId().equals(id)) {
                return moodModel.getItem(x);
            }
        }
        //TODO -- throw an exception
        return moodModel.getItem(0);
    }

    public void addMood(Mood mood){
        moodModel.addItem(mood);
    }

    public void updateMood(String id, String user, String situation, Date date, Emotion.State state, String trigger, String detail){
        this.getMood(id).edit(user, situation, date, state, trigger, detail);
        moodModel.updateItem(this.getMood(id));
    }

    public void updateMood(String id, Comment comment){
        this.getMood(id).addComment(comment);
        moodModel.updateItem(this.getMood(id));
    }

    public void deleteMood(int index){
        moodModel.deleteItem(index);
    }

    public void deleteMood(Mood mood){
        moodModel.deleteItem(mood);
    }

    public void deleteMood(String id){
        moodModel.deleteItem(id);
    }

    public String getUniqueId() {
        String id = UUID.randomUUID().toString();
        return id;
    }

    public void loadList(){
        moodModel.loadList();
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
