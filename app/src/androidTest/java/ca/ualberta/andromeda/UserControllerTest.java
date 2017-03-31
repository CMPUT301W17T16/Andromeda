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

    @Test
    public void testFollowUser() {
        UserController controller = new UserController();
        User user = new User("user");
        controller.addUser(user);
        User user2 = new User("user2");
        controller.addUser(user2);
        controller.sendFollowRequest("user2", user);
        controller.acceptFollowRequest(user2, "user");
        assertTrue(user2.getFollower().contains("user"));
    }


    @Test
    public void testUnfollowUser() {
        UserController controller = new UserController();
        User user = new User("user");
        controller.addUser(user);
        User user2 = new User("user2");
        controller.addUser(user2);
        controller.sendFollowRequest("user2", user);
        controller.acceptFollowRequest(user2, "user");
        controller.unfollow(user2, "user");
        assertFalse(user2.getFollower().contains("user"));
    }
}