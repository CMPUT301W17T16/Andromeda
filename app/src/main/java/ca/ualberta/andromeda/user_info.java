/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class user_info extends AppCompatActivity {

    String username;
    ArrayList<Mood> moodList;
    UserController userController;

    private ListView moodListView;
    private ArrayAdapter<Mood> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        moodListView = (ListView) findViewById(R.id.MoodList);
    }

    @Override
    protected void onStart(){
        super.onStart();

        // TODO: get all the users moods

        // display all the users Moods
        adapter = new ArrayAdapter<Mood>(this, R.layout.mood_listview, moodList);
        moodListView.setAdapter(adapter);
    }

    // User is already following
    // change button to unfollow
    private void following(){
        Button followButton = (Button) findViewById(R.id.follow);
        followButton.setText("Unfollow");
    }

    // turns off follow button and show add mood button
    private void myUserInfo(){
        Button followButton = (Button) findViewById(R.id.follow);
        ImageButton moodButton = (ImageButton) findViewById(R.id.addMood);
        TextView user = (TextView) findViewById(R.id.userMood);

        user.setText("My Moods");
        followButton.setVisibility(View.GONE);
        moodButton.setVisibility(View.VISIBLE);
    }

    // turns off add mood button and show follow button
    private void otherUserInfo(){
        Button followButton = (Button) findViewById(R.id.follow);
        ImageButton moodButton = (ImageButton) findViewById(R.id.addMood);
        TextView user = (TextView) findViewById(R.id.userMood);

        // TODO: Change to users name
        user.setText("Users Moods");
        followButton.setVisibility(View.VISIBLE);
        moodButton.setVisibility(View.GONE);
    }

    // follows or unfollow the user
    public void followUser(){
        // TODO: check if already following

    }

    // goes to add mood view
    public void newMood(){

    }

    // goes to map vieww
    public void openMap(){

    }

    // goes to filter view
    public void openFilter(){

    }

}