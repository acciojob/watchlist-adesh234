package com.driver;

public class Movie {
    private String name;
    private int duration;
    private double imbdRating;
    public Movie(){

    }

    public Movie(String name, int duration, double imbdRating) {
        this.name = name;
        this.duration = duration;
        this.imbdRating = imbdRating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getImbdRating() {
        return imbdRating;
    }

    public void setImbdRating(double imbdRating) {
        this.imbdRating = imbdRating;
    }
}
