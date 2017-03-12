package ca.ualberta.andromeda;

/**
 * Created by pensk on 2017/02/27.
 */

public class Emotion {
    public enum State { HAPPY, SAD }

    private State state;

    public Emotion(State emotion){
        this.state = emotion;
    }

    public State getEmotion() {
        return state;
    }

    public void setEmotion(State emotion) {
        this.state = emotion;
    }

    public String getColor() {
        switch(state) {
            case HAPPY:
                return "green";
            case SAD:
                return "blue";
            default:
                return "white";
        }
    }
}
