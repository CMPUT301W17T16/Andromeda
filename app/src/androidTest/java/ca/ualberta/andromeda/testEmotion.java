package ca.ualberta.andromeda;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by brian on 2017/2/27.
 */

public class testEmotion {
    @Test
    public void testEmotion(){


        Emotion test = new Emotion();

        String Emotion = "Sad";
        String Color = "Blue";

        test.setEmotion(Emotion);

        assertEquals(test.getColor(), Color);


    }
}
