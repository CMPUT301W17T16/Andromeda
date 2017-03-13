package ca.ualberta.andromeda;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Date;

/**
 * Created by livialee on 2017-03-05.
 */
public class ViewMoodActivity extends AndromedaActivity {

    private String idNum;
    private Date date;
    /**
     * The The mood.
     */
    protected String theMood;
    /**
     * The Username.
     */
    protected String username;
    /**
     * The Social sit.
     */
    protected String SocialSit;
    /**
     * The Details.
     */
    protected String Details;
    /**
     * The Trigger.
     */
    protected String Trigger;
    /**
     * The State.
     */
    protected Emotion.State state;
    private Integer position;
    private String MyLocation;

    /**
     * The Username holder.
     */
    TextView UsernameHolder;
    /**
     * The Date holder.
     */
    TextView DateHolder;
    /**
     * The Mood spinner.
     */
    Spinner MoodSpinner;
    /**
     * The Social spinner.
     */
    Spinner SocialSpinner;
    /**
     * The Trigger holder.
     */
    EditText TriggerHolder;
    /**
     * The Detail holder.
     */
    EditText DetailHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mood);

        moodController = ModelManager.getMoodController();
        userController = ModelManager.getUserController();

        UsernameHolder = (TextView) findViewById(R.id.UsernameHolder);
        DateHolder = (TextView) findViewById(R.id.DateHolder);
        MoodSpinner = (Spinner) findViewById(R.id.MoodSpinner);
        SocialSpinner = (Spinner) findViewById(R.id.SocialSitSpinner);
        TriggerHolder = (EditText) findViewById(R.id.TriggerHolder);
        DetailHolder = (EditText) findViewById(R.id.DetailHolder);

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
    protected void onStart(){
        super.onStart();

        Intent intent = getIntent();

        // Set username
        username = intent.getStringExtra("user");
        UsernameHolder.setText(username);

        // Loading Mood
        idNum = intent.getStringExtra("ID");
        position = moodController.getPosition(idNum);
        Mood mood = moodController.getMood(idNum);

        // Loading date
        date = mood.getDate();
        DateHolder.setText(date.toString());

        MoodSpinner.setSelection(getIndex(MoodSpinner, mood.getEmotion().getState()));

        SocialSpinner.setSelection(getIndex(SocialSpinner, mood.getSocialSituation()));

        // Loading Trigger
        TriggerHolder.setText(mood.getTrigger());

        // Loading Detail
        DetailHolder.setText(mood.getDetail());

        // Load Location
        MyLocation = mood.getMyLocation();

        // TODO Change the color of the background to match the mood

    }

    /**
     * Delete mood.
     *
     * @param v the v
     */
    public void deleteMood(View v){
        moodController.deleteMood(position);
        finish();
    }

    /**
     * Save mood.
     *
     * @param v the v
     */
// Saves the updated mood
    public void saveMood(View v){
        Trigger = TriggerHolder.getText().toString();
        Details = DetailHolder.getText().toString();
        moodController.updateMood(idNum, username, SocialSit, date, state, Trigger, Details);
        finish();
    }

    /**
     * Show location.
     *
     * @param v the v
     */
    public void showLocation(View v) {
        Toast.makeText(getApplicationContext(),MyLocation,Toast.LENGTH_SHORT).show();
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
}