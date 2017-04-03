package ca.ualberta.andromeda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public abstract class ProfileActivity extends AndromedaActivity {

    protected String username;
    protected ArrayList<Mood> moodList;
    protected ListView moodListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //moodController = ModelManager.getMoodController();
        moodListView = (ListView) findViewById(R.id.MoodList);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    //http://stackoverflow.com/questions/5565451/display-no-item-message-in-listview?noredirect=1&lq=1
//    @Override
//    public void onContentChanged() {
//        super.onContentChanged();
//
//        View empty = findViewById(R.id.empty);
//        ListView list = (ListView) findViewById(R.id.MoodList);
//        list.setEmptyView(empty);
//    }

    public ListView getMoodListView() {
        return moodListView;
    }

    public ArrayList<Mood> getMoodList(){return  moodList;}
}
