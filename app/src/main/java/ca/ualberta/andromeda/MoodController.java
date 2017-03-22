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

    /**
     * Instantiates a new Mood controller.
     */
    public MoodController(){
        moodModel = ModelManager.getMoodModel();
        userModel = ModelManager.getUserModel();
    }

    /**
     * Create mood mood.
     *
     * @param user            the user
     * @param socialSituation the social situation
     * @param state           the state
     * @param trigger         the trigger
     * @param detail          the detail
     * @return the mood
     */
    public Mood createMood(String user, String socialSituation, Emotion.State state, String trigger, String detail){
        String id = getUniqueId();
        Mood newMood = new Mood(user, socialSituation, new Date(), state, trigger, detail, id);
        this.addMood(newMood);
        return newMood;
    }

    /**
     * Create mood mood.
     *
     * @param user            the user
     * @param socialSituation the social situation
     * @param state           the state
     * @param trigger         the trigger
     * @param detail          the detail
     * @param MyLocation      the my location
     * @return the mood
     */
    public Mood createMood(String user, String socialSituation, Emotion.State state, String trigger, String detail, String MyLocation){
        String id = getUniqueId();
        Mood newMood = new Mood(user, socialSituation, new Date(), state, trigger, detail, id, MyLocation);
        this.addMood(newMood);
        return newMood;
    }

    /**
     * Get user moods array list.
     *
     * @param user the user
     * @return the array list
     */
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

    /**
     * Get all moods array list.
     *
     * @return the array list
     */
    public ArrayList<Mood> getAllMoods(){
        return moodModel.getList();
    }

    /**
     * Get mood mood.
     *
     * @param index the index
     * @return the mood
     */
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

    /**
     * Add mood.
     *
     * @param mood the mood
     */
    public void addMood(Mood mood){
        moodModel.addItem(mood);
    }

    /**
     * Update mood.
     *
     * @param id     the index
     * @param user      the user
     * @param situation the situation
     * @param date      the date
     * @param state     the state
     * @param trigger   the trigger
     * @param detail    the detail
     */

    public void updateMood(String id, String user, String situation, Date date, Emotion.State state, String trigger, String detail){
        this.getMood(id).edit(user, situation, date, state, trigger, detail);
        moodModel.saveList();
    }


    /**
     * Update mood with new comment
     *
     * @param id    the index
     * @param comment   new comment
     */
    public void updateMood(String id, Comment comment){
        this.getMood(id).addComment(comment);
        moodModel.saveList();
    }

    /**
     * Delete mood.
     *
     * @param index the index
     */
    public void deleteMood(int index){
        moodModel.deleteItem(index);
    }

    /**
     * Delete mood.
     *
     * @param mood the mood
     */
    public void deleteMood(Mood mood){
        moodModel.deleteItem(mood);
    }

    public void deleteMood(String id){
        moodModel.deleteItem(this.getPosition(id));
    }

    /**
     * http://stackoverflow.com/questions/1389736/how-do-i-create-a-unique-id-in-java
     * date: March 13, 2017
     * Time: 1:16 PM
     *
     * @return the unique id
     */
    public String getUniqueId() {
        String id = UUID.randomUUID().toString();
        return id;
    }

    /**
     * Gets position.
     *
     * @param id the id
     * @return the position
     */
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
