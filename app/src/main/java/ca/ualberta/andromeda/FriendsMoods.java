package ca.ualberta.andromeda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
// Deleted all the unnecessary imports


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
        // Replaced the argument with <> as it is implicit
        moodList = new ArrayList<>();
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