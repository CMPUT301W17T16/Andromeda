package ca.ualberta.andromeda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * The type View friend activity.
 */
public class ViewFriendActivity extends ViewMoodActivity {

    TextView TriggerHolder;
    TextView DetailHolder;

    @Override
    protected void onStart() {
        super.onStart();

        // Loading Trigger
        TriggerHolder.setText(mood.getTrigger());

        // Loading Detail
        DetailHolder.setText(mood.getDetail());
    }

}
