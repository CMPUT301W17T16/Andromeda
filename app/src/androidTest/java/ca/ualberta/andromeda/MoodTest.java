package ca.ualberta.andromeda;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by pensk on 2017/02/27.
 *
 * Tests the Mood class as well as its controller/model
 */
public class MoodTest {

    @Test
    public void testMood(){
        User user1 = new User("1");
        Date date1 = new Date();

        assertEquals(user1.getUsername(), "1");

        Mood mood1 = new Mood(user1.getUsername(), "Alone", date1, Emotion.State.HAPPINESS, "", "");

        assertEquals(mood1.getUser(), user1.getUsername());
        assertEquals(mood1.getSocialSituation(), "Alone");
        assertEquals(mood1.getDate(), date1);

        mood1.edit(user1.getUsername(), "Crowd", date1, Emotion.State.ANGER, "", "");

        assertEquals(mood1.getSocialSituation(), "Alone");
        assertEquals(mood1.getEmotion().getState(), Emotion.State.ANGER.toString());
    }

}