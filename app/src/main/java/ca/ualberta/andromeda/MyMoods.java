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

public class MyMoods extends UsersMoods {

    private ArrayAdapter<Mood> adapter;

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
                startActivity(intent);
            }
        });



    }
    @Override
    protected void onStart(){
        // Load all of the moods from the user
        super.onStart();

        adapter = new ArrayAdapter<Mood>(this, R.layout.mood_listview);
        adapter.addAll(moodController.getUserMoods(this.user));
        moodListView.setAdapter(adapter);


    }

    // goes to add mood view
    public void newMood(View v){

        // TODO: Change to correct activity when its made
        Intent intent = new Intent(this, AddMoodActivity.class);
        intent.putExtra("user", user.getUsername());
        startActivity(intent);
    }
}