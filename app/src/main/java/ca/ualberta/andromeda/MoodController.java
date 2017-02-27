package ca.ualberta.andromeda;

import java.util.Date;

/**
 * Created by pensk on 2017/02/27.
 */

public class MoodController {
    MoodModel model;

    public MoodController(){
        model = new MoodModel();
    }

    public void addMood(Mood mood){
        model.getMoods().add(mood);
    }

    public Mood getMood(int index){
        return model.getMoods().get(index);
    }

    public void updateMood(int index, User user, String situation, Date date){
        model.getMoods().get(index).edit(user, situation, date);
    }

    public void deleteMood(int index){
        model.getMoods().remove(index);
    }
}
