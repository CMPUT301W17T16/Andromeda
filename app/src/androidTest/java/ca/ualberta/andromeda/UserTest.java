package ca.ualberta.andromeda;

import org.junit.Test;
import java.util.Date;
import static org.junit.Assert.*;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


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