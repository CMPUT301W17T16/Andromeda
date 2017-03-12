package ca.ualberta.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

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
        adapter.clear();
        adapter.addAll(moodList);
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


    public void myMoods(View v){
        Intent intent = new Intent(this, MyMoods.class);
        intent.putExtra("user", user.getUsername());
        startActivity(intent);
    }

    public void notification(View v){
        Intent intent = new Intent(this, Notifications.class);
        intent.putExtra("user", user.getUsername());
        startActivity(intent);
    }

}