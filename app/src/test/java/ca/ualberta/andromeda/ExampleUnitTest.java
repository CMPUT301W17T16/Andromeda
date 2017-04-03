package ca.ualberta.andromeda;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
//    @Test
//    public void addition_isCorrect() throws Exception{
//
//        assertEquals(4, 2 + 2);
//    }

    @Test
    public void Map() throws Exception {
        Map map = new Map();

        assertEquals(map.getLatitude(),53.5444);
        assertEquals(map.getLongitude(),113.4909);

    }

    public void Emotion() throws Exception {
        assertEquals(4, 2 + 2);
    }

}