package ca.ualberta.andromeda;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.robotium.solo.Solo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

        solo.assertCurrentActivity("Wrong Activity", MainPageActivity.class);
    }

    public void testMainActivity(){
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPageActivity.class);

        // To myMoods
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity", MainPageActivity.class);

        // TODO: ADD to map and to filter test
    }

    public void testMyMoods() {
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPageActivity.class);

        // To myMoods
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // To Add Moon
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", AddMoodActivity.class);

        solo.goBack();
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // TODO: ADD to map and to filter test
    }

    public void testAddMoods() {
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPageActivity.class);

        // To myMoods
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // To Add Mood
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", AddMoodActivity.class);

        // select mood
        solo.pressSpinnerItem(0,0);
        solo.pressSpinnerItem(1,1);
        solo.enterText((EditText) solo.getView(R.id.TriggerHolder), "Test trigger");
        solo.enterText((EditText) solo.getView(R.id.DetailHolder), "Test Detail");

        solo.clickOnButton("Save");
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // check it got added    solo.waitForActivity("Activity3");
        solo.waitForActivity("ProfileUserActivity");
        ProfileUserActivity activity = (ProfileUserActivity) solo.getCurrentActivity();
        final ListView MoodList = activity.getMoodListView();
        Mood mood = (Mood) MoodList.getItemAtPosition(0);
        assertEquals("User", mood.getUser());

        assertEquals("Anger", mood.getEmotion().getState());
        assertEquals("Alone", mood.getSocialSituation());
        assertEquals("Test trigger", mood.getTrigger());
        assertEquals("Test Detail", mood.getDetail());

        //check main
        solo.goBack();
        solo.waitForActivity("MainPageActivity");
        MainPageActivity mainActvity = (MainPageActivity) solo.getCurrentActivity();
        final ListView MoodListView = mainActvity.getMoodListView();
        mood = (Mood) MoodListView.getItemAtPosition(0);
        assertEquals("User", mood.getUser());

        assertEquals("Anger", mood.getEmotion().getState());
        assertEquals("Alone", mood.getSocialSituation());
        assertEquals("Test trigger", mood.getTrigger());
        assertEquals("Test Detail", mood.getDetail());

    }

    public void testDeleteMood() {
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPageActivity.class);

        // To myMoods
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // To Add Mood
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", AddMoodActivity.class);

        // select mood
        solo.pressSpinnerItem(0,0);
        solo.pressSpinnerItem(1,1);
        solo.enterText((EditText) solo.getView(R.id.TriggerHolder), "Test trigger");
        solo.enterText((EditText) solo.getView(R.id.DetailHolder), "Test Detail");

        solo.clickOnButton("Save");
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // check it got added    solo.waitForActivity("Activity3");
        solo.waitForActivity("ProfileUserActivity");
        ProfileUserActivity activity = (ProfileUserActivity) solo.getCurrentActivity();
        final ListView MoodListV = activity.getMoodListView();
        Mood mood = (Mood) MoodListV.getItemAtPosition(0);
        assertEquals("User", mood.getUser());
        assertEquals("Anger", mood.getEmotion().getState());
        assertEquals("Alone", mood.getSocialSituation());
        assertEquals("Test trigger", mood.getTrigger());

        solo.clickInList(0);
        solo.assertCurrentActivity("wrong Activity", ViewUserActivity.class);
        solo.clickOnButton("Delete");
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // check it got deleted
        solo.waitForActivity("ProfileUserActivity");
        final ArrayList<Mood> MoodList = activity.getMoodList();
        assertFalse(MoodList.contains(mood));
    }

    public void testUpdateMoods() {
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPageActivity.class);

        // To myMoods
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // To Add Mood
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", AddMoodActivity.class);

        // select mood
        solo.pressSpinnerItem(0,0);
        solo.pressSpinnerItem(1,1);
        solo.enterText((EditText) solo.getView(R.id.TriggerHolder), "Test trigger");
        solo.enterText((EditText) solo.getView(R.id.DetailHolder), "Test Detail");

        solo.clickOnButton("Save");
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // check it got added    solo.waitForActivity("Activity3");
        solo.waitForActivity("ProfileUserActivity");
        ProfileUserActivity activity = (ProfileUserActivity) solo.getCurrentActivity();
        final ListView MoodList = activity.getMoodListView();
        Mood mood = (Mood) MoodList.getItemAtPosition(0);
        assertEquals("User", mood.getUser());

        assertEquals("Anger", mood.getEmotion().getState());
        assertEquals("Alone", mood.getSocialSituation());
        assertEquals("Test trigger", mood.getTrigger());
        assertEquals("Test Detail", mood.getDetail());

        //click on mood and update
        solo.clickInList(0);
        solo.assertCurrentActivity("wrong Activity", ViewUserActivity.class);

        solo.pressSpinnerItem(0,2);
        solo.pressSpinnerItem(1,1);
        solo.enterText((EditText) solo.getView(R.id.TriggerHolder), "2");
        solo.enterText((EditText) solo.getView(R.id.DetailHolder), "2");

        solo.clickOnButton("Save");
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // check it got Updated
        solo.waitForActivity("ProfileUserActivity");
        activity = (ProfileUserActivity) solo.getCurrentActivity();
        final ListView MoodList1 = activity.getMoodListView();
        mood = (Mood) MoodList.getItemAtPosition(0);
        assertEquals("User", mood.getUser());

        assertEquals("Disgust", mood.getEmotion().getState());
        assertEquals("Two to several people", mood.getSocialSituation());
        assertEquals("Test trigger2", mood.getTrigger());
        assertEquals("Test Detail2", mood.getDetail());
    }

    public void testComments() {
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPageActivity.class);

        // To myMoods
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

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
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // check it got added
        solo.waitForActivity("ProfileUserActivity");
        ProfileUserActivity activity = (ProfileUserActivity) solo.getCurrentActivity();
        final ListView MoodList = activity.getMoodListView();
        Mood mood = (Mood) MoodList.getItemAtPosition(0);
        assertEquals("User", mood.getUser());

        assertEquals("Anger", mood.getEmotion().getState());
        assertEquals("Alone", mood.getSocialSituation());
        assertEquals("Test trigger", mood.getTrigger());
        assertEquals("Test Detail", mood.getDetail());

        //click on mood and enter comment
        solo.clickInList(0);
        solo.assertCurrentActivity("wrong Activity", ViewUserActivity.class);

        solo.clickOnButton(3);
        solo.assertCurrentActivity("Wrong Activity", commentsActivity.class);

        solo.enterText((EditText) solo.getView(R.id.commentText), "Test Comment");
        solo.clickOnButton("Enter");

        solo.waitForActivity("commentsActivity");
        commentsActivity activity2 = (commentsActivity) solo.getCurrentActivity();
        ListView commentList = activity2.getListView();
        Comment comment = (Comment) commentList.getItemAtPosition(0);
        assertEquals("Test Comment", comment.getComment());
        assertEquals("User", comment.getUser());

        //TODO WTF FIX THIS. ITS NOT WORKING FOR SOME REASON
    }

    public void testFilters() {
        solo.assertCurrentActivity("Wrong Activity", LoginActivity.class);
        solo.enterText((EditText) solo.getView(R.id.editText), "User");
        solo.clickOnButton("Enter");

        solo.assertCurrentActivity("Wrong Activity", MainPageActivity.class);

        // To myMoods
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // To Add Mood
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", AddMoodActivity.class);

        // enter content
        solo.pressSpinnerItem(0,2);
        solo.pressSpinnerItem(1,3);
        solo.enterText((EditText) solo.getView(R.id.TriggerHolder), "Test trigger");
        solo.enterText((EditText) solo.getView(R.id.DetailHolder), "Test Detail");

        solo.clickOnButton("Save");
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // check it got added    solo.waitForActivity("Activity3");
        solo.waitForActivity("ProfileUserActivity");
        ProfileUserActivity activity = (ProfileUserActivity) solo.getCurrentActivity();
        final ListView MoodList = activity.getMoodListView();
        Mood mood = (Mood) MoodList.getItemAtPosition(0);
        assertEquals("User", mood.getUser());
        assertEquals("Disgust", mood.getEmotion().getState());
        assertEquals("Crowd", mood.getSocialSituation());
        assertEquals("Test trigger", mood.getTrigger());
        assertEquals("Test Detail", mood.getDetail());

        // Add  Second Mood
        solo.clickOnImageButton(1);
        solo.assertCurrentActivity("Wrong Activity", AddMoodActivity.class);

        // enter content
        solo.pressSpinnerItem(0,0);
        solo.pressSpinnerItem(1,2);
        solo.enterText((EditText) solo.getView(R.id.TriggerHolder), "Second Trigger");
        solo.enterText((EditText) solo.getView(R.id.DetailHolder), "Second Detail");

        solo.clickOnButton("Save");
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // check it got added
        Mood mood2 = (Mood) MoodList.getItemAtPosition(0);
        assertEquals("User", mood2.getUser());
        assertEquals("Anger", mood2.getEmotion().getState());
        assertEquals("Two to several people", mood2.getSocialSituation());
        assertEquals("Second Trigger", mood2.getTrigger());
        assertEquals("Second Detail", mood2.getDetail());

        //Filter mood
        solo.clickOnImageButton(2);
        solo.assertCurrentActivity("wrong Activity", FilterActivity.class);
        solo.pressSpinnerItem(0,2);
        solo.clickOnImageButton(0);
        solo.assertCurrentActivity("Wrong Activity", ProfileUserActivity.class);

        // check filter
        solo.waitForActivity("ProfileUserActivity");
        final ArrayList<Mood> MoodList1 = activity.getMoodList();
        assertFalse(MoodList1.contains(mood2));
    }



    @Override
    public void tearDown() throws Exception{
        solo.finishOpenedActivities();
    }

}
