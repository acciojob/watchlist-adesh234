package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class MovieRepository {
    private HashMap<String,Movie> movieHashMap;
    private HashMap<String,Director> directorHashMap;
    private HashMap<String, List<String>> directorMovieMap;
    public MovieRepository(){
        this.movieHashMap = new HashMap<>();
        this.directorHashMap = new HashMap<>();
        this.directorMovieMap = new HashMap<>();
    }
    public void saveMovie(Movie movie){
        movieHashMap.put(movie.getName(),movie);
    }
    public void saveDirector(Director director){
        directorHashMap.put(director.getName(), director);
    }
    public void saveMovieDirectorPair(String movie,String director){
        if(movieHashMap.containsKey(movie) && directorHashMap.containsKey(director)){
            List<String> currMovies = new ArrayList<>();
            if(directorMovieMap.containsKey(director)) currMovies = directorMovieMap.get(director);
            currMovies.add(movie);
            directorMovieMap.put(director,currMovies);
        }
    }
    public Movie findMovie(String Movie){
        return movieHashMap.get(Movie);
    }
    public Director findDirector(String Director){
        return directorHashMap.get(Director);
    }
    public List<String> getMoviesOfDirector(String director){
        return directorMovieMap.get(director);
    }
    public List<String> getAllMovies(){
        List<String> l = new ArrayList<>();
        for(String s : movieHashMap.keySet()){
            l.add(s);
        }
        return l;
    }
    public void deleteDirectorAndMovies(String director){
        //remove from movie HashMap
        List<String> movieList = directorMovieMap.get(director);
        for(String s : movieList){
            movieHashMap.remove(s);
        }
        //remove from director hashmap
        directorHashMap.remove(director);
        //remove from pair hashmap
        directorMovieMap.remove(director);
    }
    public void deleteAllDirectors(){
        for(String s : directorMovieMap.keySet())
            deleteDirectorAndMovies(s);
    }
}
