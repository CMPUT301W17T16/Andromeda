package ca.ualberta.andromeda;

import org.junit.Test;

import static org.junit.Assert.*;

// Deleted all the unnecessary imports

public class UserTest {

    public UserTest(){
        super();
    }


    @Test
    public void testSaveUser(){

        UserController users = new UserController();
        User user = new User("user");

        users.addUser(user);

        assertTrue(users.hasUser(user));
    }

    @Test
    public void testGetUser(){
        UserController users = new UserController();
        User user = new User("user");

        users.addUser(user);

        User returnedUser = users.getUser(0);

        assertEquals(user, returnedUser);
    }
}