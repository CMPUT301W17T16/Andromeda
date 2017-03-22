package ca.ualberta.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * The type View friend activity.
 */
public class ViewFriendActivity extends ViewMoodActivity {

    TextView TriggerHolder;
    TextView DetailHolder;
    TextView MoodHolder;
    TextView SocialHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_friend);

        moodController = ModelManager.getMoodController();
        userController = ModelManager.getUserController();

        CommentButton = (Button) findViewById(R.id.commentButton);
        UsernameHolder = (TextView) findViewById(R.id.UsernameHolder);
        DateHolder = (TextView) findViewById(R.id.DateHolder);

        MoodHolder = (TextView) findViewById(R.id.MoodHolder);
        SocialHolder = (TextView) findViewById(R.id.SocialSitHolder);
        TriggerHolder = (TextView) findViewById(R.id.TriggerHolder);
        DetailHolder = (TextView) findViewById(R.id.DetailHolder);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Load info
        TriggerHolder.setText(mood.getTrigger());
        DetailHolder.setText(mood.getDetail());
        MoodHolder.setText(mood.getEmotion().getState());
        SocialHolder.setText(mood.getSocialSituation());

    }

}
