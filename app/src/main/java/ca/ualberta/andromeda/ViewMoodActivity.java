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

public abstract class ViewMoodActivity extends AndromedaActivity {

    protected String username;
    protected String theMood;
    protected Date date;
    protected String SocialSit;
    protected String Details;
    protected String Trigger;
    protected Emotion.State state;
    protected String MyLocation;
    protected String idNum;
    protected Mood mood;

    TextView UsernameHolder;
    TextView DateHolder;
    Spinner MoodSpinner;
    Spinner SocialSpinner;

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
    protected void onStart(){
        super.onStart();

        Intent intent = getIntent();

        // Set username
        username = intent.getStringExtra("user");
        UsernameHolder.setText(username);

        // Loading Mood
        idNum = intent.getStringExtra("ID");
        mood = moodController.getMood(idNum);

        // Loading date
        date = mood.getDate();
        DateHolder.setText(date.toString());

        MoodSpinner.setSelection(getIndex(MoodSpinner, mood.getEmotion().getState()));

        SocialSpinner.setSelection(getIndex(SocialSpinner, mood.getSocialSituation()));

        // TODO Change the color of the background to match the mood

    }

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