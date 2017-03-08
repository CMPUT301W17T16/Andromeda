package ca.ualberta.andromeda;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * Created by livialee on 2017-03-05.
 */

public class ViewMoodActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_mood);

        Button deleteButton = (Button) findViewById(R.id.DeleteButton);
        Button saveButton = (Button) findViewById(R.id.SaveButton);

        // TODO Load all the info in the correct textViews



        // Delete entry
        deleteButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                // TODO Delete the specific entry and go back

                // Finish this activity, go back
                finish();
            }
        });

        // Save entry
        saveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                setResult(RESULT_OK);

                // TODO Save the entry or update the entry and then go back

                // Finish this activity, go back
                finish();
            }
        });
    }
}