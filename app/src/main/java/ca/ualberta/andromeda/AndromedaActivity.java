package ca.ualberta.andromeda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class AndromedaActivity extends AppCompatActivity {

    protected User user;
    protected UserController userController;
    protected MoodController moodController;
    protected Filter filter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userController = ModelManager.getUserController();
        moodController = ModelManager.getMoodController();

        if (getIntent().hasExtra("user")) {
            user = userController.getUserByUsername(getIntent().getStringExtra("user"));
        }
    }

    public void openMap(View v){
        //Intent intent = new Intent(v.getContext(), Map.class);
        //startActivity(intent);
    }

    public void openFilter(View v){
        Intent intent = new Intent(this, FilterActivity.class);
        startActivityForResult(intent, 2);
    }

    // receive filter back from filter activity
    // https://stackoverflow.com/questions/14292398/how-to-pass-data-from-2nd-activity-to-1st-activity-when-pressed-back-android
    // March 26, 2017
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2) {
            if(resultCode == RESULT_OK){
                filter = (Filter) data.getSerializableExtra("filter");
            }
        }
    }
}
