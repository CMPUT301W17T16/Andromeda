package ca.ualberta.andromeda;

import android.Manifest;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Date;


public class AddMoodActivity extends AndromedaActivity {

    private Uri selectedImageFromGallery;
    private String theMood;
    private String username;
    private String SocialSit;
    private String Details;
    private String Trigger;
    private Emotion.State state;
    private LocationManager locationManager;
    private LocationListener listener;
    private String MyLocation;
    private boolean hasLocation;
    private boolean hasImage;
    private Photo retrievedImage;
    static final int IMAGE_PICK = 1;

    TextView UsernameHolder;
    TextView DateHolder;
    Spinner MoodSpinner;
    Spinner SocialSpinner;
    EditText TriggerHolder;
    EditText DetailHolder;
    ImageView PictureHolder;
    RelativeLayout Background;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        hasLocation = false;
        hasImage = false;
        setContentView(R.layout.activity_add_mood);
        moodController = ModelManager.getMoodController();
        userController = ModelManager.getUserController();


        Background = (RelativeLayout) findViewById(R.id.Background);
        UsernameHolder = (TextView) findViewById(R.id.UsernameHolder);
        DateHolder = (TextView) findViewById(R.id.DateHolder);
        MoodSpinner = (Spinner) findViewById(R.id.MoodSpinner);
        SocialSpinner = (Spinner) findViewById(R.id.SocialSitSpinner);
        TriggerHolder = (EditText) findViewById(R.id.TriggerHolder);
        DetailHolder = (EditText) findViewById(R.id.DetailHolder);
        PictureHolder = (ImageView) findViewById(R.id.PictureHolder);

       //get location
        Switch location = (Switch) findViewById(R.id.LocationSwitch);
        location.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked){
                    hasLocation = true;
                    Toast.makeText(getApplicationContext(),"save Location", Toast.LENGTH_SHORT).show();
                    locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
                    listener = new LocationListener() {
                        @Override
                        public void onLocationChanged(Location location) {
                            Toast.makeText(getApplicationContext(),"\n " + location.getLongitude() + " " + location.getLatitude(), Toast.LENGTH_SHORT).show();
                            MyLocation = String.valueOf(location.getLongitude()) + " " + String.valueOf(location.getLatitude());
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

    // Adding Image
//    http://stackoverflow.com/questions/2507898/how-to-pick-an-image-from-gallery-sd-card-for-my-app
    public void PictureHolder(View v){
        imageConfigureButton();
        Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, IMAGE_PICK);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case IMAGE_PICK:
                if(resultCode == RESULT_OK){
                    try {
                        selectedImageFromGallery = imageReturnedIntent.getData();
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImageFromGallery);
                        retrievedImage = new Photo(bitmap);

                        hasImage = true;
                        PictureHolder.setImageBitmap(retrievedImage.getBitmap());

                    } catch (IOException ie){
                        Background.setBackgroundColor(0x3311FF);
                    }

                }
        }
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


        if(hasLocation){
            moodController.createMood(username, SocialSit, state, Trigger, Details,  MyLocation);
        }else {
            moodController.createMood(username, SocialSit, state, Trigger, Details);
        }
        if (hasImage){
            moodController.addImage(retrievedImage.getBitmap());
        }
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

    private void imageConfigureButton(){
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) !=
                PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE}, 11);
            }
        }
    }

    //get permission to use location for this app
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        switch (requestCode) {
            case 10:
                configure_button();
                break;
            case 11:
                imageConfigureButton();
            default:
                break;
        }
    }
}
