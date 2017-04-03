package ca.ualberta.andromeda;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Created by Jeff on 3/21/2017.
 *
 * abstract class that used by Friends Mood and users Mood activity
 */

public class ViewUserActivity extends ViewMoodActivity {

    EditText TriggerHolder;
    EditText DetailHolder;
    Spinner MoodSpinner;
    Spinner SocialSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_user);

        moodController = ModelManager.getMoodController();
        userController = ModelManager.getUserController();
        BackgroundColor = (LinearLayout) findViewById(R.id.ViewUserMood);
        CommentButton = (Button) findViewById(R.id.commentButton);

        UsernameHolder = (TextView) findViewById(R.id.UsernameHolder);
        DateHolder = (TextView) findViewById(R.id.DateHolder);
        MoodSpinner = (Spinner) findViewById(R.id.MoodSpinner);
        SocialSpinner = (Spinner) findViewById(R.id.SocialSitSpinner);
        TriggerHolder = (EditText) findViewById(R.id.TriggerHolder);
        DetailHolder = (EditText) findViewById(R.id.DetailHolder);
        PictureHolder = (ImageView) findViewById(R.id.PictureHolder);
        EmoticonHolder = (ImageView) findViewById(R.id.EmoticonHolder);

        // Drop down list for the moods
        ArrayAdapter<CharSequence> MoodAdapter = ArrayAdapter.createFromResource(this,
                R.array.moods_array, android.R.layout.simple_spinner_item);
        MoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MoodSpinner.setAdapter(MoodAdapter);

        // Drop down list for the social situation
        ArrayAdapter<CharSequence> socAdapter = ArrayAdapter.createFromResource(this,
                R.array.social_sit_array, android.R.layout.simple_spinner_item);
        socAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SocialSpinner.setAdapter(socAdapter);


        // Saves the selected social situation as a string in "SocialSit"
        SocialSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SocialSit = parent.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        // Saves the selected mood as a string in "Mood"
        MoodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                theMood = parent.getItemAtPosition(position).toString();
                switch (theMood) {
                    case "Anger":
                        state = Emotion.State.ANGER;
                        break;
                    case "Confusion":
                        state = Emotion.State.CONFUSION;
                        break;
                    case "Disgust":
                        state = Emotion.State.DISGUST;
                        break;
                    case "Fear":
                        state = Emotion.State.FEAR;
                        break;
                    case "Happiness":
                        state = Emotion.State.HAPPINESS;
                        break;
                    case "Sadness":
                        state = Emotion.State.SADNESS;
                        break;
                    case "Shame":
                        state = Emotion.State.SHAME;
                        break;
                    case "Surprise":
                        state = Emotion.State.SURPRISE;
                        break;

                    default:
                        break;
                }

            }


            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();

        // Loading info
        TriggerHolder.setText(mood.getTrigger());
        DetailHolder.setText(mood.getDetail());
        MoodSpinner.setSelection(getIndex(MoodSpinner, mood.getEmotion().getState()));
        SocialSpinner.setSelection(getIndex(SocialSpinner, mood.getSocialSituation()));

    }

    //https://stackoverflow.com/questions/8769368/how-to-set-position-in-spinner
    private int getIndex(Spinner spinner, String myString){

        int index = 0;

        for (int i=0;i<spinner.getCount();i++){
            if (spinner.getItemAtPosition(i).toString().equalsIgnoreCase(myString)){
                index = i;
            }
        }
        return index;
    }

    public void deleteMood(View v) {
        moodController.deleteMood(idNum);
        finish();
    }

    // Saves the updated mood
    public void saveMood(View v) {
        Trigger = TriggerHolder.getText().toString();
        Details = DetailHolder.getText().toString();
        moodController.updateMood(idNum, username, SocialSit, date, state, Trigger, Details);
        finish();
    }

}
