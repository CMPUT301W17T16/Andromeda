package ca.ualberta.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mood);

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
