package ca.ualberta.andromeda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by livialee on 2017-03-05.
 */

public class PhotoTest {

    @Test
    public void Photo() throws Exception {
        Photo location = new Photo();
        assertEquals(location.getLocation(), "~/Desktop/CMPUT301/");
    }


}
