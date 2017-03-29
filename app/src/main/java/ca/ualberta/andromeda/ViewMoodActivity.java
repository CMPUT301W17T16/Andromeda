package ca.ualberta.andromeda;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

public abstract class ViewMoodActivity extends AndromedaActivity {

    protected String username;
    protected String theMood;
    protected Date date;
    protected String SocialSit;
    protected String Details;
    protected String Trigger;
    protected Uri Image;
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
    ImageView EmoticonHolder;

    @Override
    protected void onStart(){
        super.onStart();

        BackgroundColor = (LinearLayout) findViewById(R.id.ViewUserMood);

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

//        http://stackoverflow.com/questions/2217753/changing-background-color-of-listview-items-on-android
        BackgroundColor.setBackgroundColor(mood.getEmotion().getColor());

        String EmoticonString = mood.getEmotion().getEmoticon();
        int drawableResourceId = this.getResources().getIdentifier(EmoticonString, "drawable", this.getPackageName());

        EmoticonHolder.setImageResource(drawableResourceId);

        PictureHolder.setImageURI(mood.getImage());




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