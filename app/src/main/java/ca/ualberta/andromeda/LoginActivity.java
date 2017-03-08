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
    private String User;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editTextBox = (EditText) findViewById(R.id.editText);
        Button enterButton = (Button) findViewById(R.id.enterButton) ;

        // Pass back to MainActivity
        enterButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                User = editTextBox.getText().toString();
                LogIn UserName = new LogIn();
                UserName.setUser(User);

                Intent returnData = new Intent(this, LogIn.class);
                returnData.putExtra("Username", UserName);
                setResult(Activity.RESULT_OK,returnData);
                finish();
            }
        });
    }
}