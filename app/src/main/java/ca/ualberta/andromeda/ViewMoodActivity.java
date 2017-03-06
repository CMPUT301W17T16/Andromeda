package ca.ualberta.andromeda;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by livialee on 2017-03-05.
 */

public class ViewMoodActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mood);

        // Load all the info


//        setContentView(R.layout.accidentlymadethemain);
    }
}

//        editTextBox = (EditText) findViewById(R.id.editText);
//        Button enterButton = (Button) findViewById(R.id.enterButton) ;
//
//        // Pass back to MainActivity
//        enterButton.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View v) {
//                User = editTextBox.getText().toString();
//                LogIn UserName = new LogIn();
//                UserName.setUser(User);
//
//                Intent returnData = new Intent();
//                returnData.putExtra("Username", User);
//                setResult(Activity.RESULT_OK,returnData);
//                finish();
//            }
//        });
//    }