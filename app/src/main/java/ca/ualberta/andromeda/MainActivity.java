package ca.ualberta.andromeda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.security.PrivateKey;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
        // Starting intent for the activity_login page
        Intent intent = new Intent(this, LoginActivity.class);
        startActivityForResult(intent, 1);

        setContentView(R.layout.activity_add_mood);
        Intent intent2 = new Intent(this, AddMoodActivity.class);
        startActivity(intent2);
    }

    //     The intent returns your username and prints it out in the textView3 in activity_main
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        String username = data.getStringExtra("Username");
        UserController newUser = new UserController();
        newUser.createUser(username);
    }

}
