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

/**
 * The type Friends moods.
 * <p>
 * Activity to view all of friends moods
 */
public class ProfileFriendActivity extends ProfileActivity{

    private String friendname;
    private User friend;
    private boolean following;
    private boolean requestSent;

    Button followButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_friend);
        moodListView = (ListView) findViewById(R.id.MoodList);
        moodList = new ArrayList<Mood>();
        followButton = (Button) findViewById(R.id.follow);

        final Intent intent = new Intent(this, ViewFriendActivity.class);
        moodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("user", user.getUsername());
                Mood mood = (Mood)parent.getItemAtPosition(position);
                intent.putExtra("ID", String.valueOf(mood.getId()));
                startActivity(intent);
            }
        });

        followButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (!following && !requestSent){
                    userController.sendFollowRequest(user.getUsername(), friend);
                    followButton.setText("Request Sent");
                }else if (following){
                    userController.unfollow(user, friendname);
                    followButton.setText("Follow");
                }
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();

        Intent intent = getIntent();

        // Get username of friend
        friendname = intent.getStringExtra("friend");
        friend = userController.getUserByUsername(friendname);

        // Display the user name at the top
        String Message = friend.getUsername() + "'s Moods";
        TextView textView = (TextView) findViewById(R.id.nameTextView);
        textView.setText(Message);

        // Load all of the moods from the user
        moodList = moodController.getUserMoods(this.friend);

        // filter the moods
        if (filter != null){
            filter.searchAllUsers();
            moodList = filter.filterMoods(moodList, user);
        }

        // display the moods
        ArrayAdapter<Mood> adapter = new ArrayAdapter<Mood>(this, R.layout.mood_listview);
        adapter.addAll(moodList);
        moodListView.setAdapter(adapter);

        // check if user is following
        following = user.getFollower().contains(friendname);
        if (following){
            followButton.setText("Unfollow");
        }

        // check if request Sent
        requestSent = friend.getFollowerRequest().contains(username);
        if (requestSent){
            followButton.setText("Request Sent");
        }

    }
    public void openMap(View v){
        Intent intent = new Intent(this, Map.class);
        intent.putExtra("user", friend.getUsername());
        startActivity(intent);
    }

}