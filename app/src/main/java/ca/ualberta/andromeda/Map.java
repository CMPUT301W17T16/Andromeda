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

public class Map extends Activity {


    MoodController moodController;
    double longitude;
    double latitude;
    String code = getIntent().getStringExtra("code");


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String code = getIntent().getStringExtra("code");
        moodController = ModelManager.getMoodController();

        //get current location
        TrackGPS gps = new TrackGPS(Map.this);
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
        switch(code){
            case "main":
                ArrayList<Mood> moodList = moodController.getAllMoods();
                setMap(moodList);
        }
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
                    switch(code){
                        case "main":
                            ArrayList<Mood> moodList = moodController.getAllMoods();
                            setMap(moodList);
                    }


                } else {

                    finish();
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }

    public void setMap(ArrayList<Mood> moodList){
        setContentView(R.layout.activity_map);
        MapView map = (MapView) findViewById(R.id.map);
        map.setTileSource(TileSourceFactory.MAPNIK);
        map.setBuiltInZoomControls(true);
        map.setMultiTouchControls(true);

        GeoPoint startPoint = new GeoPoint(longitude,latitude);
        IMapController mapController = map.getController();
        mapController.setZoom(9);
        mapController.setCenter(startPoint);


        //ArrayList<Mood> moodList = moodController.getAllMoods();
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
                    case 0xffff4d4d:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.anger_marker));
                        Toast.makeText(getApplicationContext(),"\n " + color, Toast.LENGTH_SHORT).show();
                        break;
                    case 0xff794dff:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.confuse));
                        break;
                    case 0xffA47B37:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.dis));
                        break;
                    case 0xff4EDAC5:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.fear));
                        break;
                    case 0xffffff4d:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.happy));
                        break;
                    case 0xff4da6ff:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.sad));
                        break;
                    case 0xffffa64d:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.shame));
                        break;
                    case 0xffff4dff:
                        startMarker.setIcon(getResources().getDrawable(R.drawable.sup));
                        break;
                    default:
                        break;
                }

            }
        }
    }
}
