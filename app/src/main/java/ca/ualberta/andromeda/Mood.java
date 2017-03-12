package ca.ualberta.andromeda;

import java.util.Date;

/**
 * Created by pensk on 2017/02/27.
 */

public class Mood {
    private User user;
    private String socialSituation;
    private Date date;
    private String location;
    private String detail;
    private String image;
    private Emotion emotion;

    public Mood(User user, String socialSituation, Date date){
        this.user = user;
        this.socialSituation = socialSituation;
        this.date = date;
        this.emotion = new Emotion(Emotion.State.HAPPY);
    }

    public void edit(User user, String socialSituation, Date date){
        this.user = user;
        this.socialSituation = socialSituation;
        this.date = date;
    }

    public User getUser(){
        return this.user;
    }

    public String getSocialSituation(){
        return this.socialSituation;
    }

    public Date getDate(){
        return this.date;
    }

    // TODO: Fix this to display in listview correctly
    @Override
    public String toString(){
        return user.getUsername() + " " +socialSituation;
    }

}
