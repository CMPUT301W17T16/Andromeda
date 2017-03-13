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
    private String image;
    private String trigger;
//    private String emotion;
    private Emotion emotion;
    private String mood;

    @JestId
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Mood(String user, Date date, String mood, String socialSituation, String trigger, String detail){
        this.user = user;
        this.date = date;
        this.mood = mood;
        this.socialSituation = socialSituation;
        this.trigger = trigger;
        this.detail = detail;
    }

    public void edit(String user, String mood, String socialSituation, String trigger, String detail){
        this.user = user;
        this.mood = mood;

        this.socialSituation = socialSituation;
        this.trigger = trigger;
        this.detail = detail;
    }

    public String getUser(){
        return this.user;
    }

    public String getSocialSituation(){
        return this.socialSituation;
    }

    public String getDetail() {
        return detail;
    }

    public String getTrigger() {
        return trigger;
    }

    public Date getDate(){
        return this.date;
    }

    public String getMood() {
        return this.mood;
    }
    public Emotion getEmotion() {
        return this.emotion;
    }


    // TODO: Fix this to display in listview correctly
    @Override
    public String toString(){

        return user + " | " + socialSituation + " | " + emotion.getEmotion() + " | " + date;
    }

}
