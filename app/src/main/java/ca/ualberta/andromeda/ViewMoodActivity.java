package ca.ualberta.andromeda;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by livialee on 2017-03-05.
 */

public class ViewMoodActivity extends AndromedaActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mood);

        Button locationButton = (Button) findViewById(R.id.LocationButton);
        Button deleteButton = (Button) findViewById(R.id.DeleteButton);
        Button saveButton = (Button) findViewById(R.id.SaveButton);

        TextView Username = (TextView) findViewById(R.id.UsernameHolder);
        TextView Date = (TextView) findViewById(R.id.DateHolder);
        TextView Mood = (TextView) findViewById(R.id.MoodHolder);
        TextView SocialSit = (TextView) findViewById(R.id.SocialSitHolder);
        TextView Trigger = (TextView) findViewById(R.id.TriggerHolder);
        TextView Detail = (TextView) findViewById(R.id.DetailHolder);


        // TODO Load all the info in the correct textViews

        // TODO Change the color of the background to match the mood

        // Location
        locationButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                // TODO make a map pop up

            }
        });

        // Delete entry
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                // TODO Delete the specific entry and go back

                // Finish this activity, go back
                finish();
            }
        });

        // Save entry
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                // TODO Save the entry or update the entry and then go back

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