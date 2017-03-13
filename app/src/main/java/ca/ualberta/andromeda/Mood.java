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
    private String location;
    private String detail;
    private String trigger;
    private String image;
    private Emotion emotion;
    private int id;

    public Mood(String user, String socialSituation, Date date, Emotion.State state){
        this.user = user;
        this.socialSituation = socialSituation;
        this.date = date;
        this.emotion = new Emotion(state);
    }

    public void edit(String user, String socialSituation, Date date, Emotion.State state){
        this.user = user;
        this.socialSituation = socialSituation;
        this.date = date;
        this.emotion = new Emotion(state);
    }

    public Emotion getEmotion(){ return this.emotion; }

    public String getUser(){
        return this.user;
    }

    public String getSocialSituation(){
        return this.socialSituation;
    }

    public Date getDate(){
        return this.date;
    }

    public String getDetail() {
        return detail;
    }

    public String getTrigger() {
        return trigger;
    }

    public int getId() { return this.id; }

    public void setId(int id) { this.id = id; }

    // TODO: Fix this to display in listview correctly
    @Override
    public String toString(){
        return user + " | " + socialSituation + " | " + emotion.getState() + " | " + date;
    }

}
