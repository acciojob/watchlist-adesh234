package com.driver;

public class Director {
    private String name;
    private int noOfMovies;
    private double rating;
    public Director(){

    }

    public Director(String name, int noOfMovies, double rating) {
        this.name = name;
        this.noOfMovies = noOfMovies;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNoOfMovies() {
        return noOfMovies;
    }

    public void setNoOfMovies(int noOfMovies) {
        this.noOfMovies = noOfMovies;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }
}
