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
                //Dark Red
                return 0xffC23B22;
            case CONFUSION:
                //Violet
                return 0xffCB99C9;
            case DISGUST:
                //Green
                return 0xff77DD77;
            case FEAR:
                //Dark blue
                return 0xff779ECB;
            case HAPPINESS:
                //Yellow
                return 0xffFDFD96;
            case SADNESS:
                //Dark Blue
                return 0xff779ECb;
            case SHAME:
                //Magenta
                return 0xffF49AC2;
            case SURPRISE:
                //Orange
                return 0xffFFB347;
            default:
                return 0xffffff;
        }
    }
}
