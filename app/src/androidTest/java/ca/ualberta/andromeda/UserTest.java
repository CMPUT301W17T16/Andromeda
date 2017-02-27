package ca.ualberta.andromeda;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Jeff on 2/27/2017.
 */

public class UserTest {

    public UserTest(){
        super();
    }


    @Test
    public void testSaveUser(){

        UserController users = new UserController();
        User user = new User("user1", "password");

        users.addUser(user);

        assertTrue(users.hasUser(user));
    }

    @Test
    public void testGetUser(){
        UserController users = new UserController();
        User user = new User();

        users.addUser(user);

        User returnedUser = users.getUser(0);

        assertEquals(user, returnedUser);
    }
}
