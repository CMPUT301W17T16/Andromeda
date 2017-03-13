package ca.ualberta.andromeda;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * This class extends from <code>AndromedaActivity</code>. Show the mood history of user's and friend's. This page will get the moods through <code>MoodController</code>.
 * The user's name will pass to the <code>UsersMoods</code>. This page link to the <code>Map</code>, <code>Filter</code> ,
 * <code>UsersMoods</code> and <code>notification</code>. If there is not any mood, it will show "No Mood" on screen.
 *
 *
 * @see     MoodController
 * @see     AndromedaActivity
 */

public class MainPage extends AndromedaActivity {


    private ListView oldMoodList;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();
    MoodController moodController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        oldMoodList = (ListView) findViewById(R.id.MoodList);
        moodController = ModelManager.getMoodController();
    }


    protected void onStart() {

        super.onStart();



        // TODO:need getMoodList in the moodController 2017/3/5
        moodList = moodController.getAllMoods();
        ArrayAdapter<Mood> adapter = new ArrayAdapter<Mood>(this,
                R.layout.mood_listview, moodList);
        oldMoodList.setAdapter(adapter);
    }

    /**
     *
     */
    //http://stackoverflow.com/questions/5565451/display-no-item-message-in-listview?noredirect=1&lq=1
    @Override
    public void onContentChanged() {
        super.onContentChanged();

        View empty = findViewById(R.id.empty);
        ListView list = (ListView) findViewById(R.id.MoodList);
        list.setEmptyView(empty);
    }


    /**
     *
     * @param v
     */
    public void myMoods(View v){
        Intent intent = new Intent(this, MyMoods.class);
        intent.putExtra("user", user.getUsername());
        startActivity(intent); 
    }

    /**
     *
     * @param v
     */
    public void notification(View v){
        Intent intent = new Intent(this, Notifications.class);
        intent.putExtra("user", user.getUsername());
        startActivity(intent);
    }

}