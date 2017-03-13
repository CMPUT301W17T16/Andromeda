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
    private String mood;
    private String location;
    private String detail;
    private String image;
    private String trigger;
    private String emotion;
//    private Emotion emotion;
    @JestId
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public Mood(String user, String socialSituation, Date date, Emotion.State state){
//        this.user = user;
//        this.socialSituation = socialSituation;
//        this.date = date;
//        this.emotion = new Emotion(state);
//    }
    public Mood(String user, Date date, String mood, String socialSituation, String trigger, String detail){
        this.user = user;
        this.date = date;
        this.mood = mood;
        this.socialSituation = socialSituation;
        this.trigger = trigger;
        this.detail = detail;
    }

    public void edit(String user, Date date, String mood, String socialSituation, String trigger, String detail){
        this.user = user;
        this.date = date;
        this.mood = mood;
        this.socialSituation = socialSituation;
        this.trigger = trigger;
        this.detail = detail;
    }

//    public void edit(String user, String mood, String socialSituation, Date date, Emotion.State state){
//        this.user = user;
//        this.mood = mood;
//        this.socialSituation = socialSituation;
//        this.date = date;
//        this.emotion = new Emotion(state);
//    }

//    public Emotion getEmotion(){ return this.emotion; }

    public String getUser(){
        return this.user;
    }

    public String getSocialSituation(){
        return this.socialSituation;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public Date getDate(){
        return this.date;
    }



    // TODO: Fix this to display in listview correctly
    @Override
    public String toString(){
        return user + " " + socialSituation + " " + mood + " " + date;
    }

}
