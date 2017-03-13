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
public class FriendsMoods extends UsersMoods{

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
                intent.putExtra("user", user.getUsername());
                startActivity(intent);
            }
        });
    }


    /**
     * Follow user.
     *
     * @param v the v
     */
    public void followUser(View v){
        // TODO: check if already following

    }

}