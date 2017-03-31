package ca.ualberta.andromeda;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
    LinearLayout BackgroundColor;
    ImageView PictureHolder;
    Button CommentButton;

    @Override
    protected void onStart(){
        super.onStart();

        Intent intent = getIntent();

        // Get login username
        username = user.getUsername();

        // Loading Mood
        idNum = intent.getStringExtra("ID");
        mood = moodController.getMood(idNum);

        // Set username
        UsernameHolder.setText(mood.getUser());

        // Loading date
        date = mood.getDate();
        DateHolder.setText(date.toString());

        // Load number of comments
        String text = "Comments (" + String.valueOf(mood.getComments().size()) + ")";
        CommentButton.setText(text);

        // Load Colour
        BackgroundColor = (LinearLayout) findViewById(R.id.ViewUserMood);
        BackgroundColor.setBackgroundColor(mood.getEmotion().getColor());


    }

    public void showLocation(View v) {
        MyLocation = mood.getMyLocation();
        Toast.makeText(getApplicationContext(),MyLocation,Toast.LENGTH_SHORT).show();
    }

    public void toComments(View v){
        Intent intent = new Intent(this, commentsActivity.class);
        intent.putExtra("user", username);
        intent.putExtra("ID", idNum);
        startActivity(intent);
    }
}