package ca.ualberta.andromeda;

import java.util.ArrayList;

/**
 * Created by pensk on 2017/02/27.
 */

public class MoodModel {
    private ArrayList<Mood> moodList;

    public MoodModel(){
        this.moodList = this.loadMoods();
    }

    public ArrayList<Mood> getMoods(){
        return this.moodList;
    }

    public ArrayList<Mood> loadMoods(){
        /* load from disk */
        return new ArrayList<Mood>();
    }

    public void saveMoods(){
        /* save to disk */
    }
}
