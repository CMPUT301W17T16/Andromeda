/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

public class Emotion {
    public enum State {
        ANGER,
        CONFUSION,
        DISGUST,
        FEAR,
        HAPPINESS,
        SADNESS,
        SHAME,
        SURPRISE}

    private State state;

    public Emotion(State emotion){
        this.state = emotion;
    }

    public void setEmotion(State emotion) {
        this.state = emotion;
    }

    public String getState() {
        if (state == null) {
            return "";
        }
        switch(state) {
            case ANGER:
                return "Anger";
            case CONFUSION:
                return "Confusion";
            case DISGUST:
                return "Disgust";
            case FEAR:
                return "Fear";
            case HAPPINESS:
                return "Happiness";
            case SADNESS:
                return "Sadness";
            case SHAME:
                return "Shame";
            case SURPRISE:
                return "Surprise";
            default:
                return "";
        }
    }

    public int getColor() {
        switch(state) {
            case ANGER:
                return 0xffff4d4d;
            case CONFUSION:
                return 0xff794dff;
            case DISGUST:
                return 0xffA47B37;
            case FEAR:
                return 0xff4EDAC5;
            case HAPPINESS:
                return 0xffffff4d;
            case SADNESS:
                return 0xff4da6ff;
            case SHAME:
                return 0xffffa64d;
            case SURPRISE:
                return 0xffff4dff;
            default:
                return 0xffffff;
        }
    }
}
