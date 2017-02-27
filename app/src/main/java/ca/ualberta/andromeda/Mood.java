package ca.ualberta.andromeda;

import java.util.Date;

/**
 * Created by pensk on 2017/02/27.
 */

public class Mood {
    User user;
    String socialSituation;
    Date date;
    String location;
    String detail;
    String image;
    String emotion;

    public Mood(User user, String socialSituation, Date date){
        this.user = user;
        this.socialSituation = socialSituation;
        this.date = date;
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

}
