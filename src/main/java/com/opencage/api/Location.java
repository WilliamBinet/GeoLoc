package com.opencage.api;

public class Location {
    private double latitude;

    private double longitude;

    public Location(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setLatitude(double latitude){
        this.latitude = latitude;
    }
    public double getLatitude(){
        return this.latitude;
    }
    public void setLongitude(double longitude){
        this.longitude = longitude;
    }
    public double getLongitude(){
        return this.longitude;
    }
}