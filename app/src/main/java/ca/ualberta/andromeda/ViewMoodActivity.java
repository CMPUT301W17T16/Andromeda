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

import org.w3c.dom.Text;

import java.util.Date;

/**
 * Created by livialee on 2017-03-05.
 */

public class ViewMoodActivity extends AndromedaActivity {

    private MoodController moodController;
    private UserController userController;
    private String theMood;
    private String SocialSit;
    private ArrayAdapter<Mood> adapter;
    private String username;
    private String id;
    private String detailString;
    private String triggerString;
    private Date date;
    private Integer idNum;
    private Mood EditMood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_view_mood);
        moodController = ModelManager.getMoodController();
        userController = ModelManager.getUserController();

        Button deleteButton = (Button) findViewById(R.id.DeleteButton);
        Button saveButton = (Button) findViewById(R.id.SaveButton);

        TextView Username = (TextView) findViewById(R.id.UsernameHolder);
        TextView Date = (TextView) findViewById(R.id.DateHolder);
        Spinner MoodSpinner = (Spinner) findViewById(R.id.MoodHolder);
        Spinner SocialSpinner = (Spinner) findViewById(R.id.SocialSitHolder);
        EditText Trigger = (EditText) findViewById(R.id.TriggerHolder);
        EditText Detail = (EditText) findViewById(R.id.DetailHolder);

        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        idNum = Integer.parseInt(id);

        EditMood = moodController.getMood(idNum);
        detailString = EditMood.getDetail();
        triggerString = EditMood.getTrigger();
        date = EditMood.getDate();
        SocialSit = EditMood.getSocialSituation();
        theMood = EditMood.getMood();

        // Loading User
        Username.setText(user.getUsername());

        // Loading Date
        Date.setText(EditMood.getDate().toString());

        // Loading Mood on drop down list
        ArrayAdapter<CharSequence> MoodAdapter = ArrayAdapter.createFromResource(this,
            R.array.moods_array, android.R.layout.simple_spinner_item);
        MoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MoodSpinner.setAdapter(MoodAdapter);

        // Saves the selected social situation as a string in "SocialSit"
        SocialSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SocialSit = parent.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        // Loading SocialSit on drop down list
        ArrayAdapter<CharSequence> socAdapter = ArrayAdapter.createFromResource(this,
                R.array.social_sit_array, android.R.layout.simple_spinner_item);
        socAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SocialSpinner.setAdapter(socAdapter);

        // Saves the selected mood as a string in "Mood"
        MoodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                theMood = parent.getItemAtPosition(position).toString();
            }
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        // Loading Trigger
        Trigger.setText(EditMood.getTrigger());

        // Loading Detail
        Detail.setText(EditMood.getDetail());

        // TODO Change the color of the background to match the mood

        // Delete entry
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                moodController.deleteMood(idNum);
                finish();
            }
        });

        // Save entry
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);
                EditText Trigger = (EditText) findViewById(R.id.TriggerHolder);
                EditText Detail = (EditText) findViewById(R.id.DetailHolder);

                triggerString = Trigger.getText().toString();
                detailString = Detail.getText().toString();

                // TODO Update the entry and then go back
                moodController.updateMood(idNum, user.getUsername(), date , theMood, SocialSit, triggerString, detailString);

                // Finish this activity, go back
                finish();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        // TODO Load all the info in the correct textViews

    }
}