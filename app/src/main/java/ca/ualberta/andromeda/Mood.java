/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import java.util.Date;

import io.searchbox.annotations.JestId;

/**
 * Created by pensk on 2017/02/27.
 */
public class Mood {
    private String user;
    private String socialSituation;
    private Date date;
    private String detail;
    private String trigger;
    private String image;
    private Emotion emotion;
    private String id;
    private String MyLocation;

    /**
     * Instantiates a new Mood.
     *
     * @param user            the user
     * @param socialSituation the social situation
     * @param date            the date
     * @param state           the state
     * @param trigger         the trigger
     * @param detail          the detail
     * @param id              the id
     */
    public Mood(String user, String socialSituation, Date date, Emotion.State state, String trigger, String detail, String id){
        this.user = user;
        this.socialSituation = socialSituation;
        this.date = date;
        this.emotion = new Emotion(state);
        this.trigger = trigger;
        this.detail = detail;
        this.id = id;
    }

    /**
     * Instantiates a new Mood.
     *
     * @param user            the user
     * @param socialSituation the social situation
     * @param date            the date
     * @param state           the state
     * @param trigger         the trigger
     * @param detail          the detail
     * @param id              the id
     * @param MyLocation      the my location
     */
    public Mood(String user, String socialSituation, Date date, Emotion.State state, String trigger, String detail, String id, String MyLocation){
        this.user = user;
        this.socialSituation = socialSituation;
        this.date = date;
        this.emotion = new Emotion(state);
        this.trigger = trigger;
        this.detail = detail;
        this.id = id;
        this.MyLocation = MyLocation;
    }

    /**
     * Edit.
     *
     * @param user            the user
     * @param socialSituation the social situation
     * @param date            the date
     * @param state           the state
     * @param trigger         the trigger
     * @param detail          the detail
     */
    public void edit(String user, String socialSituation, Date date, Emotion.State state, String trigger, String detail){
        this.user = user;
        this.socialSituation = socialSituation;
        this.date = date;
        this.emotion = new Emotion(state);
        this.trigger = trigger;
        this.detail = detail;
    }

    /**
     * Get emotion emotion.
     *
     * @return the emotion
     */
    public Emotion getEmotion(){ return this.emotion; }

    /**
     * Get user string.
     *
     * @return the string
     */
    public String getUser(){
        return this.user;
    }

    /**
     * Get social situation string.
     *
     * @return the string
     */
    public String getSocialSituation(){
        return this.socialSituation;
    }

    /**
     * Get date date.
     *
     * @return the date
     */
    public Date getDate(){
        return this.date;
    }

    /**
     * Gets detail.
     *
     * @return the detail
     */
    public String getDetail() {
        return detail;
    }

    /**
     * Gets trigger.
     *
     * @return the trigger
     */
    public String getTrigger() {
        return trigger;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public String getId() { return id; }

    /**
     * Gets my location.
     *
     * @return the my location
     */
    public String getMyLocation() { return MyLocation; }

    // TODO: Fix this to display in listview correctly
    @Override
    public String toString(){
        return user + " | " + socialSituation + " | " + emotion.getState() + " | " + date;
    }

}
