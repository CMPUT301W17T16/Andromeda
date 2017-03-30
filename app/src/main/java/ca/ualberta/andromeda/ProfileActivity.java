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
 * <p>
 * Super class for viewing my moods or friends moods
 */
public abstract class ProfileActivity extends AndromedaActivity {

    /**
     * The Mood list.
     */
    protected ArrayList<Mood> moodList;
    /**
     * The Mood list view.
     */
    protected ListView moodListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        moodController = ModelManager.getMoodController();
        moodListView = (ListView) findViewById(R.id.MoodList);
    }

    @Override
    protected void onStart(){
        super.onStart();

        // Display the user name at the top
        String Message = user.getUsername() + "'s Moods";
        TextView textView = (TextView) findViewById(R.id.nameTextView);
        textView.setText(Message);

        // Load all of the moods from the user
        moodList = moodController.getUserMoods(this.user);
        ArrayAdapter<Mood> adapter = new ArrayAdapter<Mood>(this, R.layout.mood_listview);
//        ColorAdapter adapter = new ColorAdapter(this, R.layout.mood_listview);
        adapter.addAll(moodList);
        moodListView.setAdapter(adapter);
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

    /**
     * Gets mood list view.
     *
     * @return the mood list view
     */
    public ListView getMoodListView() {
        return moodListView;
    }

    public ArrayList<Mood> getMoodList(){return  moodList;}
}
