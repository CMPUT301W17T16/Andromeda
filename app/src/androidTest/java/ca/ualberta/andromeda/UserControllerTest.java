package ca.ualberta.andromeda;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by pensk on 2017/02/27.
 */
public class UserControllerTest {
    @Test
    public void testAddUser() {
        UserController controller = new UserController();
        User user = new User("user");
        controller.addUser(user);
        assertEquals(user, controller.getUser(0));
    }

    @Test
    public void testDeleteUser() {
        UserController controller = new UserController();
        User user = new User("user");
        controller.addUser(user);
        controller.deleteUser(0);
        assertEquals(null, controller.getUser(0));

    }

}