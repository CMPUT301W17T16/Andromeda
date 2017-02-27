package ca.ualberta.andromeda;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by pensk on 2017/02/27.
 */

public class MoodControllerTest {
    
    @Test
    public void testGet(){
        MoodController controller = new MoodController();
        Mood mood = new Mood(new User(), "school", new Date());

        controller.addMood(mood);

        assertEquals(mood, controller.getMood(0));
    }

    @Test
    public void testDelete(){
        MoodController controller = new MoodController();
        Mood mood = new Mood(new User(), "school", new Date());

        controller.addMood(mood);
        controller.deleteMood(0);

        assertEquals(null, controller.getMood(0));
    }
}