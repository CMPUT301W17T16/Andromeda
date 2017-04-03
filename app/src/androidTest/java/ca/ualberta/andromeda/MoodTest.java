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

        assertEquals(user1.getUsername(), "1");

        MoodController moodController = ModelManager.getMoodController();

        Mood mood1 = moodController.createMood(user1.getUsername(), "Crowd", Emotion.State.HAPPINESS, "", "");

        //check we inserted the mood for the user
        assertTrue(moodController.getAllMoods().contains(mood1));
//        assertEquals(moodController.getUserMoods(user1).get(0).getId(),mood1.getId());

        //int index, String user, String situation, Date date, Emotion.State state, String trigger, String detail

        //Bugged while elasticsearch is under load
        /*
        moodController.updateMood(mood1.getId(), user2.getUsername(), "Two People", date1, Emotion.State.CONFUSION, "", "");

        assertEquals(moodController.getMood(mood1.getId()).getEmotion().getState(), "Confusion");
        assertEquals(moodController.getMood(mood1.getId()).getUser(), user2.getUsername());
        assertEquals(moodController.getMood(mood1.getId()).getSocialSituation(), "Two People");
        */
        moodController.deleteMood(mood1.getId());
//        moodController.deleteMood(mood2.getId());
    }

}