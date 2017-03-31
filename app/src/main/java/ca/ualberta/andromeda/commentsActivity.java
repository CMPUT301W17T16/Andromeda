package ca.ualberta.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
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
    private ArrayList<Comment> commentList;

    private EditText commentHolder;
    private TextView usernameHolder;
    private TextView moodHolder;
    private ListView commentListView;
    private ArrayAdapter<Comment> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comments);

        moodController = ModelManager.getMoodController();

        commentHolder = (EditText) findViewById(R.id.commentText);
        usernameHolder = (TextView) findViewById(R.id.usernameHolder);
        moodHolder = (TextView) findViewById(R.id.moodHolder);

        commentList = new ArrayList<Comment>();
        commentListView = (ListView) findViewById(R.id.commentListView);

        Button saveButton = (Button) findViewById(R.id.save);

        // ADD username of commenter
        saveButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                setResult(RESULT_OK);

                // get comment
                String text = commentHolder.getText().toString();
                Comment comment = new Comment(text, username);

                // add to the intent list
                commentList.add(comment);

                // add to mood controller and data set
                moodController.updateMood(idNum, comment);

                // update listview
                adapter.notifyDataSetChanged();

                // scroll to bottom
                commentListView.setSelection(commentListView.getCount() - 1);
            }
        });

        // go to commenters profile
        final Intent intent = new Intent(this, ProfileFriendActivity.class);
        commentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Only if user clicks on other uses name
                if (!username.equals(commentList.get(position).getUser())) {
                    intent.putExtra("user", user.getUsername());
                    intent.putExtra("friend", commentList.get(position).getUser());
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();

        // Get commenting users name
        username = user.getUsername();

        // Set Mood
        idNum = intent.getStringExtra("ID");
        Mood mood = moodController.getMood(idNum);
        moodHolder.setText(mood.toString());

        // Set username of the mood
        usernameHolder.setText(mood.getUser());

        // Load all previous comments
        commentList = mood.getComments();

        // Set Comments
        adapter = new ArrayAdapter<Comment>(this, R.layout.mood_listview, commentList);
        commentListView.setAdapter(adapter);
    }

    public ListView getListView() {
        return commentListView;
    }

    public ArrayList<Comment> getCommentList(){return commentList;}

}
