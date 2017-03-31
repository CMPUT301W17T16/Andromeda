package ca.ualberta.andromeda;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

/**
 * Created by Jeff on 3/30/2017.
 */

public class FilterTest {

    @Test
    public void testMoodFilter() {
        User user1 = new User("1");
        User user2 = new User("2");
        Date date1 = new Date();
        Date date2 = new Date();

        assertEquals(user1.getUsername(), "1");

        //String user, String socialSituation, Date date, Emotion.State state, String trigger, String detail, String id)
        Mood mood1 = new Mood(user1.getUsername(), "Crowd", date1, Emotion.State.HAPPINESS, "", "", "id1");
        Mood mood2 = new Mood(user2.getUsername(), "Alone", date2, Emotion.State.FEAR, "", "", "id2");

        MoodController moodController = ModelManager.getMoodController();
        moodController.addMood(mood1);
        moodController.addMood(mood2);

        // Filter Mood
        Filter filter = new Filter(Emotion.State.HAPPINESS, null, false, true);
        ArrayList<Mood> moodList = filter.filterMoods(moodController.getAllMoods(), user1);
        for (int x = 0; x < moodList.size(); x++){
            Mood mood = moodList.get(x);
            assertEquals(moodList.get(x).getEmotion().getState(), "Happiness");
        }

        moodController.deleteMood(mood1.getId());
        moodController.deleteMood(mood2.getId());
    }

    @Test
    public void testSearchFilter() {
        User user1 = new User("1");
        User user2 = new User("2");
        Date date1 = new Date();
        Date date2 = new Date();

        assertEquals(user1.getUsername(), "1");

        //String user, String socialSituation, Date date, Emotion.State state, String trigger, String detail, String id)
        Mood mood1 = new Mood(user1.getUsername(), "Crowd", date1, Emotion.State.HAPPINESS, "search", "search", "id1");
        Mood mood2 = new Mood(user2.getUsername(), "Alone", date2, Emotion.State.FEAR, "", "", "id2");

        MoodController moodController = ModelManager.getMoodController();
        moodController.addMood(mood1);
        moodController.addMood(mood2);

        // Filter Mood
        Filter filter = new Filter(null, "search", false, true);
        ArrayList<Mood> moodList = filter.filterMoods(moodController.getAllMoods(), user1);
        for (int x = 0; x < moodList.size(); x++){
            assertEquals(moodList.get(x).getDetail(), "search");
        }

        moodController.deleteMood(mood1.getId());
        moodController.deleteMood(mood2.getId());
    }

    @Test
    public void testWithinWeekFilter() {
        User user1 = new User("1");
        User user2 = new User("2");
        Date date1 = DateUtils.addDays(new Date(),-8);
        Date date2 = new Date();

        assertEquals(user1.getUsername(), "1");

        //String user, String socialSituation, Date date, Emotion.State state, String trigger, String detail, String id)
        Mood mood1 = new Mood(user1.getUsername(), "Crowd", date1, Emotion.State.HAPPINESS, "", "", "id1");
        Mood mood2 = new Mood(user2.getUsername(), "Alone", date2, Emotion.State.FEAR, "", "", "id2");

        MoodController moodController = ModelManager.getMoodController();
        moodController.addMood(mood1);
        moodController.addMood(mood2);

        // Filter Mood
        Filter filter = new Filter(null, "search", false, true);
        ArrayList<Mood> moodList = filter.filterMoods(moodController.getAllMoods(), user1);
        for (int x = 0; x < moodList.size(); x++){
            Date lastWeek = DateUtils.addDays(new Date(),-7);
            assertFalse( moodList.get(x).getDate().compareTo(lastWeek) < 0);
        }


        moodController.deleteMood(mood1.getId());
        moodController.deleteMood(mood2.getId());
    }
}
