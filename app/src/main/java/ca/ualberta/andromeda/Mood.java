/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.net.Uri;

import java.net.URI;
import java.util.Date;

import io.searchbox.annotations.JestId;

public class Mood {
    private String user;
    private String socialSituation;
    private Date date;
    private String detail;
    private String trigger;
    private Uri image;
    private Emotion emotion;
    private String id;
    private String MyLocation;

    public Mood(String user, String socialSituation, Date date, Emotion.State state, String trigger, String detail, String id){
        this.user = user;
        this.socialSituation = socialSituation;
        this.date = date;
        this.emotion = new Emotion(state);
        this.trigger = trigger;
        this.detail = detail;
        this.id = id;
    }

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
    public void addImage(Uri image){
        this.image = image;
    }

    public void edit(String user, String socialSituation, Date date, Emotion.State state, String trigger, String detail){
        this.user = user;
        this.socialSituation = socialSituation;
        this.date = date;
        this.emotion = new Emotion(state);
        this.trigger = trigger;
        this.detail = detail;
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

    public String getId() { return id; }

    public Uri getImage() { return image;}

    public String getMyLocation() { return MyLocation; }

    // TODO: Fix this to display in listview correctly
    @Override
    public String toString(){
        return user + " | " + socialSituation + " | " + emotion.getState() + " | " + date;
    }

}
