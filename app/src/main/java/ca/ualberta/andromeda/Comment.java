package ca.ualberta.andromeda;

/**
 * Created by jcho1 on 3/21/17.
 */

public class Comment {
    private String comment;
    private String user;

    public Comment(String comment, String user){
        this.comment = comment;
        this.user = user;
    }

    @Override
    public String toString(){
        return this.user + ": " + this.comment;
    }

    public String getUser() { return user; }
}
