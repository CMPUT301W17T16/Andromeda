package ca.ualberta.andromeda;

import android.Manifest;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import android.os.UserHandle;
import android.provider.MediaStore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class AddMoodActivity extends AndromedaActivity {
    protected String theMood;
    protected String username;
    protected String SocialSit;
    protected String Details;
    protected String Trigger;
    protected Emotion.State state;
    private LocationManager locationManager;
    private LocationListener listener;
    TextView UsernameHolder;
    TextView DateHolder;
    Spinner MoodSpinner;
    Spinner SocialSpinner;
    EditText TriggerHolder;
    EditText DetailHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_mood);

        moodController = ModelManager.getMoodController();
        userController = ModelManager.getUserController();


        UsernameHolder = (TextView) findViewById(R.id.UsernameHolder);
        DateHolder = (TextView) findViewById(R.id.DateHolder);
        MoodSpinner = (Spinner) findViewById(R.id.MoodSpinner);
        SocialSpinner = (Spinner) findViewById(R.id.SocialSitSpinner);
        TriggerHolder = (EditText) findViewById(R.id.TriggerHolder);
        DetailHolder = (EditText) findViewById(R.id.DetailHolder);
        
      
       //get loction
        Switch location = (Switch) findViewById(R.id.LocationSwitch);
        location.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    Toast.makeText(getApplicationContext(),"save Location", Toast.LENGTH_SHORT).show();
                    locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                    listener = new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            Toast.makeText(getApplicationContext(),"\n " + location.getLongitude() + " " + location.getLatitude(), Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onStatusChanged(String provider, int status, Bundle extras) {

                        }

                        @Override
                        public void onProviderEnabled(String provider) {

                        }

                        @Override
                        public void onProviderDisabled(String provider) {
                            Intent i = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(i);
                        }
                    };
                    configure_button();
                }else {
                    Toast.makeText(getApplicationContext(),"Don't save Location", Toast.LENGTH_SHORT).show();
                }
            }
        });
      
        // Drop down list for the moods
        ArrayAdapter<CharSequence> MoodAdapter = ArrayAdapter.createFromResource(this,
                R.array.moods_array, android.R.layout.simple_spinner_item);
        MoodAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MoodSpinner.setAdapter(MoodAdapter);

        // Drop down list for the social situation
        ArrayAdapter<CharSequence> socAdapter = ArrayAdapter.createFromResource(this,
                R.array.social_sit_array, android.R.layout.simple_spinner_item);
        socAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        SocialSpinner.setAdapter(socAdapter);


        // Saves the selected social situation as a string in "SocialSit"
        SocialSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                SocialSit = parent.getItemAtPosition(position).toString();
            }

            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        // Saves the selected mood as a string in "Mood"
        MoodSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                theMood = parent.getItemAtPosition(position).toString();
                switch (theMood) {
                    case "Anger":
                        state = Emotion.State.ANGER;
                        break;
                    case "Confusion":
                        state = Emotion.State.CONFUSION;
                        break;
                    case "Disgust":
                        state = Emotion.State.DISGUST;
                        break;
                    case "Fear":
                        state = Emotion.State.FEAR;
                        break;
                    case "Happiness":
                        state = Emotion.State.HAPPINESS;
                        break;
                    case "Sadness":
                        state = Emotion.State.SADNESS;
                        break;
                    case "Shame":
                        state = Emotion.State.SHAME;
                        break;
                    case "Surprise":
                        state = Emotion.State.SURPRISE;
                        break;

                    default:
                        break;
                }

            }

            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Intent intent = getIntent();

        // Set username
        username = intent.getStringExtra("user");
        UsernameHolder.setText(username);

        // Load date
        Date now = new Date();
        DateHolder.setText(now.toString());
    }


    public void deleteMood(View v){
        finish();
    }

    // Saves the updated mood
    public void saveMood(View v){
        Trigger = TriggerHolder.getText().toString();
        Details = DetailHolder.getText().toString();
        moodController.createMood(username, SocialSit, state);
        finish();
    }
  
   private void configure_button() {
        // first check for permissions
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION,
                                Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.INTERNET}
                        , 10);
            }
            return;
        }
        // this code won'textView execute IF permissions are not allowed, because in the line above there is return statement.

        locationManager.requestLocationUpdates("gps", 5000, 0, listener);

    }

    //get permission to use location for this app
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                configure_button();
                break;
            default:
                break;
        }
    }
}
