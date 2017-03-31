package ca.ualberta.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * The type Main page.
 */
public class MainPageActivity extends AndromedaActivity {

    private ListView oldMoodList;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();

    MoodController moodController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        oldMoodList = (ListView) findViewById(R.id.MoodList);
        moodController = ModelManager.getMoodController();

        final Intent intent = new Intent(this, ViewFriendActivity.class);
        oldMoodList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Only if user clicks on other uses name
                if (!user.getUsername().equals(moodList.get(position).getUser())) {
                    intent.putExtra("user", user.getUsername());
                    Mood mood = (Mood)parent.getItemAtPosition(position);
                    intent.putExtra("ID", String.valueOf(mood.getId()));
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        // get all the moods
        moodList = moodController.getAllMoods();

        // filter the moods
        if (filter == null) {
            filter = new Filter(null, null, false, false);
        }
        moodList = filter.filterMoods(moodList, user);

        ArrayAdapter<Mood> adapter = new ArrayAdapter<Mood>(this, R.layout.mood_listview);
        adapter.clear();
        adapter.addAll(moodList);

        // TODO IT ERRORS OUT HERE
        oldMoodList.setAdapter(adapter);
    }

    //http://stackoverflow.com/questions/5565451/display-no-item-message-in-listview?noredirect=1&lq=1
    @Override
    public void onContentChanged() {
        super.onContentChanged();

        View empty = findViewById(R.id.empty);
        ListView list = (ListView) findViewById(R.id.MoodList);
        list.setEmptyView(empty);
    }


    /**
     * My moods.
     *
     * @param v the v
     */
    public void myMoods(View v){
        Intent intent = new Intent(this, ProfileUserActivity.class);
        intent.putExtra("user", user.getUsername());
        startActivity(intent);
    }

    /**
     * Notification.
     *
     * @param v the v
     */
    public void notification(View v){
//        Intent intent = new Intent(this, Notifications.class);
//        intent.putExtra("user", user.getUsername());
//        startActivity(intent);
    }

    public ListView getMoodListView() {
        return oldMoodList;
    }

}