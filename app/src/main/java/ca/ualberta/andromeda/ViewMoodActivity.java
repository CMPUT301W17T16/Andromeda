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

//      http://stackoverflow.com/questions/2217753/changing-background-color-of-listview-items-on-android
        // Load Colour
        BackgroundColor = (LinearLayout) findViewById(R.id.ViewUserMood);
        BackgroundColor.setBackgroundColor(mood.getEmotion().getColor());

        // Load Emoticon
//      http://stackoverflow.com/questions/29047902/how-to-add-an-image-to-the-drawable-folder-in-android-studio
//      http://stackoverflow.com/questions/8642823/using-setimagedrawable-dynamically-to-set-image-in-an-imageview
        String EmoticonString = mood.getEmotion().getEmoticon();
        int drawableResourceId = this.getResources().getIdentifier(EmoticonString, "drawable", this.getPackageName());

        EmoticonHolder.setImageResource(drawableResourceId);

        PictureHolder.setImageBitmap(mood.getImage());

    }

    public void showLocation(View v) {
        Toast.makeText(getApplicationContext(),MyLocation,Toast.LENGTH_SHORT).show();
    }

    public void toComments(View v){
        Intent intent = new Intent(this, commentsActivity.class);
        intent.putExtra("user", username);
        intent.putExtra("ID", idNum);
        startActivity(intent);
    }
}