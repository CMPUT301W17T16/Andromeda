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

    public Mood createMood(User user, String socialSituation, Date date) {
        Mood newMood = new Mood(user, socialSituation, date);
        this.addMood(newMood);
    }

    public Mood createMood(User user, String socialSituation){
        Mood newMood = new Mood(user, socialSituation, new Date());
        this.addMood(newMood);
    }

    public ArrayList<Mood> getUserMoods(User user){
        
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
