package ca.ualberta.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class commentsActivity extends AndromedaActivity {

    private String username;
    private String idNum;
    private ArrayList<String> commentList;

    private EditText commentHolder;
    private TextView usernameHolder;
    private TextView moodHolder;
    private ListView commentListView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        moodController = ModelManager.getMoodController();

        commentHolder = (EditText) findViewById(R.id.commentText);
        usernameHolder = (TextView) findViewById(R.id.usernameHolder);
        moodHolder = (TextView) findViewById(R.id.moodHolder);

        commentList = new ArrayList<String>();
        commentListView = (ListView) findViewById(R.id.commentListView);

        Button saveButton = (Button) findViewById(R.id.save);

        // ADD username of commenter
        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);
                String comment = commentHolder.getText().toString();
                commentList.add(comment);
                adapter.notifyDataSetChanged();
                commentListView.setSelection(commentListView.getCount() - 1);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();

        // Set username
        username = intent.getStringExtra("user");
        usernameHolder.setText(username);

        // Set Mood
        idNum = intent.getStringExtra("ID");
        Mood mood = moodController.getMood(idNum);
        moodHolder.setText(mood.toString());

        // TODO: Get All previous comments

        // Set Comments
        adapter = new ArrayAdapter<String>(this, R.layout.mood_listview, commentList);
        commentListView.setAdapter(adapter);
    }

}
