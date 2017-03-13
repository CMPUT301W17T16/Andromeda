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

    private MoodController moodController;
    private UserController userController;
    private ArrayAdapter<Mood> adapter;
    private String username;
    private String id;
    private Integer idNum;

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
        TextView Trigger = (TextView) findViewById(R.id.TriggerHolder);
        TextView Detail = (TextView) findViewById(R.id.DetailHolder);

        adapter = new ArrayAdapter<Mood>(this, R.layout.mood_listview);
        adapter.addAll(moodController.getUserMoods(this.user));

//         Loading User
         Username.setText(user.getUsername());

        // Loading Date
        Intent intent = getIntent();
        id = intent.getStringExtra("ID");
        idNum = Integer.parseInt(id);

        moodController.getMood(idNum);
        Date.setText(id);


        // Loading Mood on drop down list
        ArrayAdapter<CharSequence> MoodAdapter = ArrayAdapter.createFromResource(this,
            R.array.moods_array, android.R.layout.simple_spinner_item);
        MoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MoodSpinner.setAdapter(MoodAdapter);


        // Loading SocialSit on drop down list
        ArrayAdapter<CharSequence> socAdapter = ArrayAdapter.createFromResource(this,
                R.array.social_sit_array, android.R.layout.simple_spinner_item);
        socAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SocialSpinner.setAdapter(socAdapter);

        // Loading SocialSit
        // Loading Trigger
        // Loading Detail

        // TODO Load all the info in the correct textViews

        // TODO Change the color of the background to match the mood

        // Delete entry
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                moodController.deleteMood(idNum);
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