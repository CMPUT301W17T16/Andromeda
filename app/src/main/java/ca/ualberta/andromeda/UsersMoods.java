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

public abstract class UsersMoods extends AndromedaActivity {

    protected MoodController moodController;
    protected ArrayList<Mood> moodList;
    protected ListView moodListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moodController = ModelManager.getMoodController();
    }

    @Override
    protected void onStart(){
        super.onStart();

        // Display the user name at the top
        String Message = user.getUsername() + "'s Moods";
        TextView textView = (TextView) findViewById(R.id.nameTextView);
        textView.setText(Message);


        // TODO: get all the users moods

        // display all the users Moods
        //ArrayAdapter<Mood> adapter = new ArrayAdapter<Mood>(this, R.layout.mood_listview, moodList);
        //moodListView.setAdapter(adapter);
    }


    //http://stackoverflow.com/questions/5565451/display-no-item-message-in-listview?noredirect=1&lq=1
    @Override
    public void onContentChanged() {
        super.onContentChanged();

        View empty = findViewById(R.id.empty);
        ListView list = (ListView) findViewById(R.id.MoodList);
        list.setEmptyView(empty);
    }

}
