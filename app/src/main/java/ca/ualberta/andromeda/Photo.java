/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

/**
 * Created by livialee on 2017-02-27.
 */
public class Photo {

    private String Location = "~/Desktop/CMPUT301/";


    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return Location;
    }

    /**
     * Sets location.
     *
     * @param location the location
     */
    public void setLocation(String location) {
        Location = location;
    }


}
