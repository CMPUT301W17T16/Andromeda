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
//Refactor - Class structure/Field can be local/LoginActivity.java

public class LoginActivity extends Activity{

    private EditText editTextBox;
    private UserController userController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        userController = ModelManager.getUserController();
        setContentView(R.layout.activity_login);
        editTextBox = (EditText) findViewById(R.id.editText);
    }

    /**
     * Login.
     *
     * @param v the v
     */
    public void login(View v){
        User user;
        if (userController.hasUser(editTextBox.getText().toString())) {
            user = userController.getUserByUsername(editTextBox.getText().toString());
        }
        else {
            user = userController.createUser(editTextBox.getText().toString());
        }
        Intent intent = new Intent(this, MainPage.class);
        intent.putExtra("user", user.getUsername());
        startActivity(intent);
        finish();
    }
}