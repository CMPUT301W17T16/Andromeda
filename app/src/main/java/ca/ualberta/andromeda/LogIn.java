package ca.ualberta.andromeda;

/**
 * Created by livialee on 2017-02-27.
 */

public class LogIn {
    // Get username and password
    // Compare to see if it matches
    // Opens MainPage

    private String User;
    private String Password;

    public String getUser() {
        return User;
    }

    public void setUser(String user) { User = user; }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
