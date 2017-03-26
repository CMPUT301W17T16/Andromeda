/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

/**
 * The type Filter activity.
 */
public class FilterActivity extends AppCompatActivity {

    private Emotion.State state;

    Spinner MoodSpinner;
    EditText SearchHolder;
    Switch weekSwitch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        MoodSpinner = (Spinner) findViewById(R.id.MoodSpinner);
        SearchHolder = (EditText) findViewById(R.id.SearchTermHolder);
        weekSwitch = (Switch) findViewById(R.id.switch1);

        // Drop down list for the moods
        ArrayAdapter<CharSequence> MoodAdapter = ArrayAdapter.createFromResource(this,
                R.array.moods_array, android.R.layout.simple_spinner_item);
        MoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MoodSpinner.setAdapter(MoodAdapter);

        // Saves the selected mood as a string in "Mood"
        MoodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String theMood = parent.getItemAtPosition(position).toString();
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

    public void filterButton(View v){

        String searchTerm = SearchHolder.getText().toString();
        boolean withinWeek = weekSwitch.isActivated();

        // make filter
        Filter filter = new Filter(state, searchTerm, withinWeek );

        // pass filter to previous
        Intent intent = new Intent();
        intent.putExtra("filter", filter);
        setResult(RESULT_OK, intent);

        finish();
    }

}
