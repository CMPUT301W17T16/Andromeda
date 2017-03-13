package ca.ualberta.andromeda;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.robotium.solo.Solo;

import java.util.Date;

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
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPage.class);
    }

    public void testMainActivity(){
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPage.class);

        // To myMoods
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", MyMoods.class);

        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity", MainPage.class);

        // TODO: ADD to map and to filter test
    }

    public void testMyMoods() {
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPage.class);

        // To myMoods
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", MyMoods.class);

        // To Add Moon
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", AddMoodActivity.class);

        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity", MyMoods.class);

        // TODO: ADD to map and to filter test
    }

    public void testAddMoods() {
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPage.class);

        // To myMoods
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", MyMoods.class);

        // To Add Mood
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", AddMoodActivity.class);

        // https://stackoverflow.com/questions/10921036/how-do-i-click-the-first-item-in-a-spinner-using-robotium
        // select mood
        View view1 = solo.getView(Spinner.class, 0);
        solo.clickOnView(view1);
        solo.scrollToTop();
        solo.clickOnView(solo.getView(TextView.class, 0));

        View view2 = solo.getView(Spinner.class, 1);
        solo.clickOnView(view2);
        solo.scrollToTop();
        solo.clickOnView(solo.getView(TextView.class, 9));

        solo.enterText((EditText) solo.getView(R.id.TriggerHolder), "Test trigger");
        solo.enterText((EditText) solo.getView(R.id.DetailHolder), "Test Detail");

        solo.clickOnButton("Save");
        solo.assertCurrentActivity("Wrong Activity", MyMoods.class);

        // check it got added    solo.waitForActivity("Activity3");
        solo.waitForActivity("MyMoods");
        MyMoods activity = (MyMoods) solo.getCurrentActivity();
        final ListView MoodList = activity.getMoodListView();
        Mood mood = (Mood) MoodList.getItemAtPosition(0);
        assertEquals("user", mood.getUser());
        assertEquals(new Date(), mood.getDate());
        assertEquals("Angry", mood.getEmotion());
        assertEquals("Alone", mood.getSocialSituation());
    }

    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }

}
