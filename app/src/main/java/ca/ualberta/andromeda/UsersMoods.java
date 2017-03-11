package ca.ualberta.andromeda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Date;

public class UsersMoods extends AppCompatActivity implements toActivity {

    User user;
    String username;
    ArrayList<Mood> moodList;
    UserController userController;

    private ListView moodListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_moods);
        moodListView = (ListView) findViewById(R.id.MoodList);
        moodList = new ArrayList<Mood>();
        final Intent intent = new Intent(this, ViewMoodActivity.class);

        moodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("user", username);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();

        // Get the username
        Intent intent = getIntent();
        username = intent.getStringExtra("user");
        intent.putExtra("user", username);

        // Display the user name at the top
        String Message = username + "'s Moods";
        TextView textView = (TextView) findViewById(R.id.nameTextView);
        textView.setText(Message);

        // Create user object
        user = new User(username);

        // TODO: get all the users moods

        // display all the users Moods
        ArrayAdapter<Mood> adapter = new ArrayAdapter<Mood>(this, R.layout.mood_listview, moodList);
        moodListView.setAdapter(adapter);
    }


    // goes to add mood view
    public void newMood(View v){

        // TODO: Change to correct activity when its made
        Intent intent = new Intent(this, AddMoodActivity.class);
        intent.putExtra("user", username);
        startActivity(intent);
    }

    // goes to map view
    public void openMap(View v){

    }

    // goes to filter view
    public void openFilter(View v){

    }

}