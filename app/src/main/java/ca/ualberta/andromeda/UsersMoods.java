package ca.ualberta.andromeda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Jeff on 3/11/2017.
 */

public class UsersMoods extends AndromedaActivity {

    ArrayList<Mood> moodList;
    ListView moodListView;

    @Override
    protected void onStart(){
        super.onStart();

        getUsername();
        getUser();

        // Display the user name at the top
        String Message = username + "'s Moods";
        TextView textView = (TextView) findViewById(R.id.nameTextView);
        textView.setText(Message);


        // TODO: get all the users moods

        // display all the users Moods
        ArrayAdapter<Mood> adapter = new ArrayAdapter<Mood>(this, R.layout.mood_listview, moodList);
        moodListView.setAdapter(adapter);
    }

}
