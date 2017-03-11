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

public class MainPage extends AppCompatActivity {

    private ListView oldMoodList;
    private ArrayList<Mood> moodList = new ArrayList<Mood>();
    private ArrayAdapter<Mood> adapter;
    User user;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        oldMoodList = (ListView) findViewById(R.id.MoodList);

        Button myMoodsButton = (Button) findViewById(R.id.button);
        Button mapButton = (Button) findViewById(R.id.button3);
        Button filterButton = (Button) findViewById(R.id.button2);
//
//        mapButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), Map.class);
//                startActivity(intent);
//                finish();
//            }
//
//        });
//
//        filterButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(v.getContext(), Filter.class);
//                startActivity(intent);
//                finish();
//            }
//
//        });

        myMoodsButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(),UsersMoods.class);
                intent.putExtra("user", username);
                startActivity(intent);
                finish();
            }

        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    protected void onStart() {

        super.onStart();
        Intent intent = getIntent();
        username = intent.getStringExtra("user");
        //// TODO:need getMoodList in the moodController 2017/3/5
        //moodList = MoodController.getModdList();

        adapter = new ArrayAdapter<Mood>(this,
              R.layout.mood_listview, moodList);
        oldMoodList.setAdapter(adapter);
    }
}
