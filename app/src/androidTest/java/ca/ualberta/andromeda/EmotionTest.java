package ca.ualberta.andromeda;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by livialee on 2017-03-31.
 */

public class EmotionTest {

    @Test
    public void testEmotion() throws Exception {
        Emotion Anger = new Emotion(Emotion.State.ANGER);
        assertEquals("Anger", Anger.getState());
        assertEquals(0xffC23B22, Anger.getColor());
        assertEquals("anger", Anger.getEmoticon());

        Anger.setEmotion(Emotion.State.SADNESS);
        assertEquals("Sadness", Anger.getState());
        assertEquals(Emotion.State.SADNESS, Anger.returnState());
    }
}
