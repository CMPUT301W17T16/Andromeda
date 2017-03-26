/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by pensk on 2017/02/27.
 */
public class Filter implements Serializable {
    private Emotion.State State;
    private String Search;
    private Boolean WithinWeek;

    public Filter(Emotion.State state, String search, boolean WithinWeek){
        this.State = state;
        this.Search = search;
        this.WithinWeek = WithinWeek;
    }

    public boolean filterList(){
        return true;

    }

    public ArrayList<Mood> filterMoods(ArrayList<Mood> moodList){
        ArrayList<Mood> filteredMood = new ArrayList<Mood>();
        for(int x=0; x<moodList.size(); x++){
            boolean add = true;
            if(State != null){
                if (!moodList.get(x).getEmotion().returnState().equals(State)){ add = false; }
            }
            if(Search != null){
                // TODO tokenize this and filter
            }
            if(WithinWeek){
                // TODO do the dates
            }

            if(add){
                filteredMood.add(moodList.get(x));
            }
        }
        return filteredMood;
    }
}
