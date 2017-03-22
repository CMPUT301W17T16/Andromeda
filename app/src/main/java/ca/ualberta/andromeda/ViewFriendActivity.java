package ca.ualberta.andromeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * The type View friend activity.
 */
public class ViewFriendActivity extends ViewMoodActivity {

    TextView TriggerHolder;
    TextView DetailHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_friend);

        moodController = ModelManager.getMoodController();
        userController = ModelManager.getUserController();

        UsernameHolder = (TextView) findViewById(R.id.UsernameHolder);
        DateHolder = (TextView) findViewById(R.id.DateHolder);
        MoodSpinner = (Spinner) findViewById(R.id.MoodSpinner);
        SocialSpinner = (Spinner) findViewById(R.id.SocialSitSpinner);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Loading Trigger
        TriggerHolder.setText(mood.getTrigger());

        // Loading Detail
        DetailHolder.setText(mood.getDetail());
    }

}
