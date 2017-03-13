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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class AddMoodActivity extends AndromedaActivity{

    private String theMood;
    private String SocialSit;
    private String Details;
    private String Trigger;
    public String username;
    private MoodController moodController;
    private UserController userController;
    private Emotion.State state;
    private Date newDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moodController = ModelManager.getMoodController();
        userController = ModelManager.getUserController();

        setContentView(R.layout.activity_add_mood);
        Button DeleteButton = (Button) findViewById(R.id.DeleteButton);
        Button SaveButton = (Button) findViewById(R.id.SaveButton);

        TextView UsernameHolder = (TextView) findViewById(R.id.UsernameHolder);
        TextView date = (TextView) findViewById(R.id.DateHolder);
        Spinner MoodSpinner = (Spinner) findViewById(R.id.MoodSpinner);
        Spinner SocialSpinner = (Spinner) findViewById(R.id.SocialSitSpinner);
        EditText TriggerHolder = (EditText) findViewById(R.id.TriggerHolder);
        EditText DetailHolder = (EditText) findViewById(R.id.DetailHolder);

        // Loads the username
        Intent intent = getIntent();
        username = intent.getStringExtra("user");
        UsernameHolder.setText(username);

        // Loads the current date and time, saved as a string
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
        newDate = Calendar.getInstance().getTime();

        String currentDateandTime = df.format(Calendar.getInstance().getTime());
        date.setText(currentDateandTime);

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

        // Loads the input from trigger
        Trigger = TriggerHolder.getText().toString();

        // Loads the inout from details
        Details = DetailHolder.getText().toString();


        //Delete Button finishes activity and saves nothing
        DeleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

        // Save button save everything in the controller

        SaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Pass information to the controllers.

                //user = userController.getUserByUsername(username);
                moodController.createMood(username, newDate, theMood, SocialSit, Trigger, Details );
                finish();
            }
        });}

        // Add location

        // Add Image

    }
