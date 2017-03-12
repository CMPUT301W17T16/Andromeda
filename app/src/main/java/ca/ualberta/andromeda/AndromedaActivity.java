package ca.ualberta.andromeda;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Jeff on 3/10/2017.
 *
 * Base abstract  Activity
 */
public abstract class AndromedaActivity extends Activity {

    String username;
    User user;

    protected void getUsername(){
        Intent intent = getIntent();
        username = intent.getStringExtra("user");
    }

    protected void getUser() {
        user = new User(username);
    }

    /**
     * Open map.
     *
     * @param v the v
     */
    public void openMap(View v){
        Intent intent = new Intent(v.getContext(), Map.class);
        startActivity(intent);
        finish();
    }

    /**
     * Open filter.
     *
     * @param v the v
     */
// goes to filter view
    public void openFilter(View v){
        Intent intent = new Intent(v.getContext(), Filter.class);
        startActivity(intent);
        finish();
    }
}