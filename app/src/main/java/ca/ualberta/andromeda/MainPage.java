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

import java.util.ArrayList;

public class MainPage extends AndromedaActivity {

    private ListView oldMoodList;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();
    private ArrayAdapter<Mood> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    protected void onStart() {

        super.onStart();

        // TODO:need getMoodList in the moodController 2017/3/5
        // moodList = MoodController.getModdList();
    }

    protected void myMoods(View v){
        Intent intent = new Intent(this, MyMoods.class);
        intent.putExtra("user", username);
        startActivity(intent);
    }
}