package ca.ualberta.andromeda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * The type My moods.
 * <p>
 * Activity to view all of my moods
 */
public class ProfileUserActivity extends ProfileActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_user);
        moodListView = (ListView) findViewById(R.id.MoodList);

        final Intent intent = new Intent(this, ViewUserActivity.class);

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

        // Display username
        String Message = user.getUsername() + "'s Moods";
        TextView textView = (TextView) findViewById(R.id.nameTextView);
        textView.setText(Message);

        // Load all of the moods from the user
        moodList = moodController.getUserMoods(user);

        // filter the moods
        if (filter != null){
            moodList = filter.filterMoods(moodList, user);
        }

        // display the moods
        ArrayAdapter<Mood> adapter = new ArrayAdapter<Mood>(this, R.layout.mood_listview);
        adapter.addAll(moodList);
        moodListView.setAdapter(adapter);
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

    public void openMap(View v){
        Intent intent = new Intent(this, Map.class);
        intent.putExtra("user", user.getUsername());
        startActivity(intent);
    }

}