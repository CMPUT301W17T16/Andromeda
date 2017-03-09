package ca.ualberta.andromeda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.io.Serializable;

/**
 * Created by livialee on 2017-03-05.
 */

public class LoginActivity extends AppCompatActivity implements Serializable{

    private EditText editTextBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextBox = (EditText) findViewById(R.id.editText);
    }

    public void login(View v){
        Intent intent = new Intent(this, UsersMoods.class);
        intent.putExtra("user", editTextBox.getText().toString());
        startActivity(intent);
        finish();
    }
}