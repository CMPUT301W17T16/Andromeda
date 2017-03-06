package ca.ualberta.andromeda;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by pensk on 2017/02/27.
 */
public class MoodTest {

    @Test
    public void testGetters(){
        Date now = new Date();
        User test = new User();
        Mood User = new Mood(test, "school", now);

        assertEquals(test, User.getUser());
        assertEquals("school", User.getSocialSituation());
        assertEquals(now, User.getDate());
    }

    @Test
    public void testEdit(){
        Date now = new Date();
        User test = new User();
        Mood mood = new Mood(new User(), "school", new Date());

        mood.edit(test, "cafe", now);

        assertEquals(test,mood.getUser());
        assertEquals("cafe", mood.getSocialSituation());
        assertEquals(now, mood.getDate());
    }
}