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
        User user2 = new User("2");
        Date date1 = new Date();
        Date date2 = new Date();

        //String user, String socialSituation, Date date, Emotion.State state, String trigger, String detail, String id)
        Mood mood1 = new Mood(user1.getUsername(), "Crowd", date1, Emotion.State.HAPPINESS, "", "", "id1");
        Mood mood2 = new Mood(user2.getUsername(), "Alone", date2, Emotion.State.FEAR, "", "", "id2");

        MoodController moodController = ModelManager.getMoodController();

        moodController.addMood(mood1);
        moodController.addMood(mood2);

        //check we inserted the mood for the user
        assertEquals(moodController.getMood("id1"), mood1);
        assertEquals(moodController.getUserMoods(user1).size(), 1);

        //String id, String user, String situation, Date date, Emotion.State state, String trigger, String detail
        moodController.updateMood("id1", );
    }

}