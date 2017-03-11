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

public class FriendsMoods extends AndromedaActivity{

    ArrayList<Mood> moodList;
    UserController userController;

    private ListView moodListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_moods);
        moodListView = (ListView) findViewById(R.id.MoodList);
        moodList = new ArrayList<Mood>();
        final Intent intent = new Intent(this, ViewFriendActivity.class);

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

        getUsername();

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


    // follows or unfollow the user
    public void followUser(View v){
        // TODO: check if already following

    }

    public void openMap(View v) {

    }

    public void openFilter(View v) {

    }
}