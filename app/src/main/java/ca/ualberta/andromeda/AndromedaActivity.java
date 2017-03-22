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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userController = ModelManager.getUserController();

        if (getIntent().hasExtra("user")) {
            user = userController.getUserByUsername(getIntent().getStringExtra("user"));
        }
    }

    public void openMap(View v){
        //Intent intent = new Intent(v.getContext(), Map.class);
        //startActivity(intent);
        //finish();
    }

    public void openFilter(View v){
        //Intent intent = new Intent(v.getContext(), Filter.class);
        //startActivity(intent);
        //finish();
    }
}
