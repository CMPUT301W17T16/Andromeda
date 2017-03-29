/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.widget.Toast;

import org.apache.commons.lang3.time.DateUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
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

                // https://stackoverflow.com/questions/17134773/to-check-if-string-contains-particular-word
                // march 28, 2017
                if (moodList.get(x).getDetail().toLowerCase().indexOf(Search.toLowerCase()) == -1 ){
                    add = false;
                }
            }
            if(WithinWeek){

                // https://stackoverflow.com/questions/11882926/how-to-subtract-x-day-from-a-date-object-in-java
                // march 28, 2017
                Date lastWeek = DateUtils.addDays(new Date(),-7);

                // https://www.mkyong.com/java/how-to-compare-dates-in-java/
                // march 28, 2017
                if (moodList.get(x).getDate().compareTo(lastWeek) < 0){
                    add = false;
                }
            }

            if(add){
                filteredMood.add(moodList.get(x));
            }
        }
        return filteredMood;
    }
}
