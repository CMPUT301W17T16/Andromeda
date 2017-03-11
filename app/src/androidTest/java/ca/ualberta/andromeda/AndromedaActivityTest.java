package ca.ualberta.andromeda;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.EditText;

import com.robotium.solo.Solo;

/**
 * Created by Jeff on 3/11/2017.
 */

public class AndromedaActivityTest extends ActivityInstrumentationTestCase2 {

    private Solo solo;

    public AndromedaActivityTest(){
        super(ca.ualberta.andromeda.LoginActivity.class);
    }

    public void setUp() throws Exception{
        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testStart() throws Exception {
        Activity activity = getActivity();
    }

    public void testLogin(){
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("enterButton");

        solo.assertCurrentActivity("Wrong Activity", MainPage.class);
    }

    public void testMainActivity(){
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("enterButton");

        solo.assertCurrentActivity("Wrong Activity", MainPage.class);

    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }

}
