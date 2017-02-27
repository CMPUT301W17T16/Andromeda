package ca.ualberta.andromeda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import static org.junit.Assert.*;

/**
 * Created by brettgarbitt on 2017-02-27.
 */

public class NotificationsTest {
    ArrayList<String> requests;
    ArrayList<String> requests2;

    @Test
    public void testGetters(ArrayList<String> requests) {
        requests.add(-1, "test1");
        requests.add(-1, "test2");
        requests.add(-1, "test3");


    }
}
