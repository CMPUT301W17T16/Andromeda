/*
 * Copyright (c) 2017. Andromeda
 */

package ca.ualberta.andromeda;

/**
 * Created by livialee on 2017-02-27.
 */
public class Map {
    // Stores latitude and longitude.

    private double latitude = 53.5444;
    private double longitude = 113.4909;

    /**
     * Gets latitude.
     *
     * @return the latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     * Sets latitude.
     *
     * @param latitude the latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    /**
     * Gets longitude.
     *
     * @return the longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     * Sets longitude.
     *
     * @param longitude the longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }
}
