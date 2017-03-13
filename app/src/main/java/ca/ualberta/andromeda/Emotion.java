/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

/**
 * Created by pensk on 2017/02/27.
 */
public class Emotion {
    /**
     * The enum State.
     */
    public enum State {
        /**
         * Anger state.
         */
        ANGER, /**
         * Confusion state.
         */
        CONFUSION, /**
         * Disgust state.
         */
        DISGUST, /**
         * Fear state.
         */
        FEAR, /**
         * Happiness state.
         */
        HAPPINESS, /**
         * Sadness state.
         */
        SADNESS, /**
         * Shame state.
         */
        SHAME, /**
         * Surprise state.
         */
        SURPRISE}

    private State state;

    /**
     * Instantiates a new Emotion.
     *
     * @param emotion the emotion
     */
    public Emotion(State emotion){
        this.state = emotion;
    }

    /**
     * Sets emotion.
     *
     * @param emotion the emotion
     */
    public void setEmotion(State emotion) {
        this.state = emotion;
    }

    /**
     * Gets state.
     *
     * @return the state
     */
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

    /**
     * Gets color.
     *
     * @return the color
     */
    public String getColor() {
        switch(state) {
            case ANGER:
                return "RED";
            case CONFUSION:
                return "LIGHT GREEN";
            case DISGUST:
                return "DARK GREEN";
            case FEAR:
                return "PURPLE";
            case HAPPINESS:
                return "YELLOW";
            case SADNESS:
                return "BLUE";
            case SHAME:
                return "ORANGE";
            case SURPRISE:
                return "PINK";
            default:
                return "WHITE";
        }
    }
}
