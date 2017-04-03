package ca.ualberta.andromeda;

import android.Manifest;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import org.osmdroid.api.IMapController;
import org.osmdroid.bonuspack.utils.DouglasPeuckerReducer;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import org.osmdroid.views.overlay.Marker;

import java.util.ArrayList;

public class MapFriend extends Activity {


    MoodController moodController;
    protected User User;
    protected UserController userController;
    double longitude;
    double latitude;

    String user = getIntent().getStringExtra("user");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        String code = getIntent().getStringExtra("code");
        moodController = ModelManager.getMoodController();

        //get current location
        TrackGPS gps = new TrackGPS(MapFriend.this);
        if (gps.canGetLocation()) {


            longitude = gps.getLongitude();
            latitude = gps.getLatitude();
        } else {
            gps.showSettingsAlert();
        }


        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {


            // No explanation needed, we can request the permission.

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                    0);

            // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
            // app-defined int constant. The callback method gets the
            // result of the request.
        }

        setMap();
//        switch(code){
//            case "main":
//                ArrayList<Mood> moodList = moodController.getAllMoods();
//                setMap(moodList);
//        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[], @NonNull int[] grantResults) {
        switch (requestCode) {
            case 0: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
//                    switch(code){
//                        case "main":

                    setMap();
//                    }


                } else {

                    finish();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void setMap(){
        setContentView(R.layout.activity_map);
        MapView map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        GeoPoint startPoint = new GeoPoint(longitude,latitude);
        IMapController mapController = map.getController();
        mapController.setZoom(9);
        mapController.setCenter(startPoint);

        User = userController.getUserByUsername(getIntent().getStringExtra("user"));

        ArrayList<Mood> moodList = moodController.getUserMoods(User);

        for(int x=0; x<moodList.size(); x++) {
            if (moodList.get(x).getMyLocation() != null){

                String str = moodList.get(x).getMyLocation();
                String[] splitStr = str.split("\\s+");


                double lon = Double.parseDouble(splitStr[0]);
                double lat = Double.parseDouble(splitStr[1]);
                GeoPoint moodPoint = new GeoPoint(lon,lat);


                Marker startMarker = new Marker(map);
                startMarker.setPosition(moodPoint);
                startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_BOTTOM);
                map.getOverlays().add(startMarker);

                map.invalidate();

                int color = moodList.get(x).getEmotion().getColor();

                switch (color){
                    case 0xffC23B22:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.anger_marker));
                        break;
                    case 0xffCB99C9:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.confuse_marker));
                        break;
                    case 0xff77DD77:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.dis_marker));
                        break;
                    case 0xff779ECB:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.fear_marker));
                        break;
                    case 0xffFDFD96:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.happy_marker));
                        break;
                    case 0xffAEC6CF:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.sad_marker));
                        break;
                    case 0xffF49AC2:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.shame_marker));
                        break;
                    case 0xffFFB347:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.sup_marker));
                        break;
                    default:
                        break;
                }
                startMarker.setTitle(str + moodList.get(x).getUser() );

            }
        }
    }
}