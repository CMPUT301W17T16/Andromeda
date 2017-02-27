package ca.ualberta.andromeda;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by Jeff on 2/27/2017.
 */

public class UserTest {

    public UserTest(){
        super();
    }


    @Test
    public void testSaveUser(){

        UserList users = new UserList();
        User user = new User("user1", "password");

        User.addUser(user);
        assertTrue(users.hasUser(user));
    }

    @Test
    public void testGetUser(){
        UserList users = new UserList();
        User user = new User("user1");

        User.addUser(user);

        User returnedUser = users.getUser(0);

        assertEquals(user.getUsername(), user.getUsername());
        assertEquals(user.getPassword(), user.getPassword());
    }
}
