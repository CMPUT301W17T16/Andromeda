package ca.ualberta.andromeda;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pensk on 2017/02/27.
 */
public class MoodTest {
    
    @Test
    public void testAdd(){
        Mood mood = new Mood();
        assertEquals(7, mood.add(4,3));
    }
}