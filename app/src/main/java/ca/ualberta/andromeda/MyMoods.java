package ca.ualberta.andromeda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

// Deleted all the unnecessary imports


/**
 * The type My moods.
 * <p>
 * Activity to view all of my moods
 */
public class MyMoods extends UsersMoods {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_moods);
        moodListView = (ListView) findViewById(R.id.MoodList);

        final Intent intent = new Intent(this, ViewMoodActivity.class);

        moodListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                intent.putExtra("user", user.getUsername());
                Mood mood = (Mood)parent.getItemAtPosition(position);
                intent.putExtra("ID", String.valueOf(mood.getId()));
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    /**
     * Goes to add New mood.
     *
     * @param v the v
     */
    public void newMood(View v){

        Intent intent = new Intent(this, AddMoodActivity.class);
        intent.putExtra("user", user.getUsername());
        startActivity(intent);
    }
}