package ca.ualberta.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mood);

        Spinner MoodSpinner = (Spinner) findViewById(R.id.MoodSpinner);
        ArrayAdapter<CharSequence> MoodAdapter = ArrayAdapter.createFromResource(this,
                R.array.moods_array, android.R.layout.simple_spinner_item);
        MoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MoodSpinner.setAdapter(MoodAdapter);

        Spinner SocialSpinner = (Spinner) findViewById(R.id.SocialSitSpinner);
        ArrayAdapter<CharSequence> socAdapter = ArrayAdapter.createFromResource(this,
                R.array.social_sit_array, android.R.layout.simple_spinner_item);
        socAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SocialSpinner.setAdapter(socAdapter);

        // NOTE: ViewMoodActivity loads information when clicked on, AddMoodActivity starts as a blank

//        // Starting intent for the activity_login page
//        Intent intent = new Intent(this, LoginActivity.class);
//        startActivityForResult(intent, 1);
    }

    // The intent returns your username and prints it out in the textView3 in activity_main
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        box = (TextView) findViewById(R.id.textView3);
//        String username = data.getStringExtra("Username");
//        box.setText(username);
//    }

    // The intent returns your username and prints it out in the textView3 in activity_main
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        box = (TextView) findViewById(R.id.MoodsTitle);
        String username = data.getStringExtra("Username");
        box.setText(username);
    }

}
