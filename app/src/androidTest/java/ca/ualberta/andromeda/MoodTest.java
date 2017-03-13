package ca.ualberta.andromeda;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by pensk on 2017/02/27.
 */
public class MoodTest {

    @Test
    public void testMood(){
        User user1 = new User("1");
        User user2 = new User("2");

        
    }

    @Test
    public void testAddMood(){

        Date now = new Date();


        assertEquals("user",mood.getUser());
        assertEquals("school", mood.getSocialSituation());
        assertEquals(now, mood.getDate());
    }

    @Test
    public void testEditMood(){
        Date now = new Date();
        Mood mood = new Mood("user", "school", now);

        assertEquals("user",mood.getUser());
        assertEquals("school", mood.getSocialSituation());
        assertEquals(now, mood.getDate());
    }

    @Test
    public void testDeleteMood(){
        Date now = new Date();
        Mood mood = new Mood("user", "school", now);

        assertEquals("user",mood.getUser());
        assertEquals("school", mood.getSocialSituation());
        assertEquals(now, mood.getDate());


    }

}