/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

/**
 * Created by pensk on 2017/02/27.
 */

public class Emotion {
    public enum State {  ANGER, CONFUSION, DISGUST, FEAR, HAPPINESS, SADNESS, SHAME, SURPRISE}

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
            case ANGER:
                return "green";
            case CONFUSION:
                return "blue";
            case DISGUST:
                return "blue";
            case FEAR:
                return "blue";
            case HAPPINESS:
                return "blue";
            case SADNESS:
                return "blue";
            case SHAME:
                return "blue";
            case SURPRISE:
                return "blue";
            default:
                return "white";
        }
    }
}
