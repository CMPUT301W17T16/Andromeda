package ca.ualberta.andromeda;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddMoodActivity extends AppCompatActivity{
    public String testString;
    private String theMood;
    private String SocialSit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mood);
        Button DeleteButton = (Button) findViewById(R.id.DeleteButton);
        Button SaveButton = (Button) findViewById(R.id.SaveButton);
        Spinner MoodSpinner = (Spinner) findViewById(R.id.MoodSpinner);
        Spinner SocialSpinner = (Spinner) findViewById(R.id.SocialSitSpinner);
        TextView test = (TextView) findViewById(R.id.UsernameHolder);
        TextView date = (TextView) findViewById(R.id.DateHolder);

        // Loads the current date and time, saved as a string
        DateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm");
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
                TextView test = (TextView) findViewById(R.id.UsernameHolder);
                System.out.println(parent);
                SocialSit = parent.getItemAtPosition(position).toString();
                test.setText(SocialSit);
            }
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }
        });

        // Saves the selected mood as a string in "Mood"
        MoodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                TextView test = (TextView) findViewById(R.id.UsernameHolder);
                System.out.println(parent);
                theMood = parent.getItemAtPosition(position).toString();
                test.setText(theMood);
            }
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });


        //Delete Button finishes activity and saves nothing
        DeleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });
        // Save button save everything in the controller

        SaveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView test = (TextView) findViewById(R.id.UsernameHolder);
                test.setText(theMood);

                // Pass information to the controllers.
//                finish();
            }
        });}

        // Add location

        // Add Image

    }
