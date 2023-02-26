package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    MovieRepository movieRepository;

    public void addMovie(Movie movie){
        movieRepository.saveMovie(movie);
    }
    public void addDirector(Director director){
        movieRepository.saveDirector(director);
    }
    public void pairMovieAndDirector(String movie,String director){
         movieRepository.saveMovieDirectorPair(movie,director);
    }
    public Movie findMovie(String name){
        return movieRepository.findMovie(name);
    }
    public Director findDirector(String Director){
        return movieRepository.findDirector(Director);
    }
    public List<String> getMoviesOfDirector(String director){
        return movieRepository.getMoviesOfDirector(director);
    }
    public List<String> getAllMovies(){
        return movieRepository.getAllMovies();
    }
    public void deleteDirectorAndMovies(String director){
        movieRepository.deleteDirectorAndMovies(director);
    }
    public void deleteAllDirectors(){
        movieRepository.deleteAllDirectors();
    }
}
