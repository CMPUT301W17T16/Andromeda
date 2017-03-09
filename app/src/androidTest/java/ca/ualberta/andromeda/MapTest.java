package ca.ualberta.andromeda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by livialee on 2017-03-05.
 */

public class MapTest {
    @Test
    public void Map() throws Exception {
        Map map = new Map();

        assertEquals(map.getLatitude(),53.5444);
        assertEquals(map.getLongitude(),113.4909);

    }
}
