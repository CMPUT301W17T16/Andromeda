package ca.ualberta.andromeda;

import org.junit.Test;

import static junit.framework.Assert.assertFalse;

/**
 * Created by brian on 2017/2/27.
 */

public class TestFilter {

    @Test
    public void testFilterList(){
        Filter filterMoods = new Filter();
        assertFalse(filterMoods.filterList());
    }
}
