package ca.ualberta.andromeda;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by livialee on 2017-03-05.
 */

public class LoginTest {

    @Test
    public void login() throws Exception {
        LogIn UserName = new LogIn();
        UserName.setUser("AndromedaUser");
        assertEquals(UserName.getUser(), "AndromedaUser");

        UserName.setUser("NewUser");
        assertEquals(UserName.getUser(), "NewUser");
    }
    private String User;

    public String getUser() {
        return User;
    }

    public void setUser(String user) { User = user; }

}