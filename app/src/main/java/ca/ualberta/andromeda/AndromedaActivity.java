package ca.ualberta.andromeda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Jeff on 3/10/2017.
 * <p>
 * Super class that implements activities
 */
public abstract class AndromedaActivity extends AppCompatActivity {

    /**
     * The User.
     */
    protected User user;
    /**
     * The User controller.
     */
    protected UserController userController;
    /**
     * The Mood controller.
     */
    protected MoodController moodController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userController = ModelManager.getUserController();

        if (getIntent().hasExtra("user")) {
            user = userController.getUserByUsername(getIntent().getStringExtra("user"));
        }
    }

    /**
     * Open map.
     *
     * @param v the v
     */
    public void openMap(View v){
        //Intent intent = new Intent(v.getContext(), Map.class);
        //startActivity(intent);
        //finish();
    }

    /**
     * Open filter.
     *
     * @param v the v
     */
    public void openFilter(View v){
        //Intent intent = new Intent(v.getContext(), Filter.class);
        //startActivity(intent);
        //finish();
    }
}
