package com.driver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieController {
    @Autowired
    MovieService movieService;
    @PostMapping("/add_movie")
    public ResponseEntity<String> addMovie(@RequestBody() Movie movie){
        movieService.addMovie(movie);
        return new ResponseEntity<>("new Movie added successfully", HttpStatus.CREATED);
    }
    @PostMapping("/add_director")
    public ResponseEntity<String> addDirector(@RequestBody() Director director){
        movieService.addDirector(director);
        return new ResponseEntity<>("new director added successfully",HttpStatus.CREATED);
    }
    @PutMapping("/pair_movie_director")
    public ResponseEntity<String> pairMovieAndDirector(@RequestParam("movie") String movie,@RequestParam("director") String director){
        movieService.pairMovieAndDirector(movie,director);
        return new ResponseEntity<>("new movie director pair added succesfully",HttpStatus.CREATED);
    }
    @GetMapping("/get_movie_by_name/{name}")
    public ResponseEntity<Movie> getMovieByName(@PathVariable String movie){
        Movie movies = movieService.findMovie(movie);
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }
    @GetMapping("/get_director_by_name/{name}")
    public ResponseEntity<Director> getDirector(@PathVariable("director") String director){
        Director directors = movieService.findDirector(director);
        return new ResponseEntity<>(directors,HttpStatus.FOUND);
    }
    @GetMapping("/get_movie_by_director_name/{director}")
    public ResponseEntity<List<String>> getMoviesOfDirector(@PathVariable("director") String director){
        List<String> l = movieService.getMoviesOfDirector(director);
        return new ResponseEntity<>(l,HttpStatus.FOUND);
    }
    @GetMapping("/get_all_movies")
    public ResponseEntity<List<String>> getAllMovies(){
        List<String> l = movieService.getAllMovies();
        return new ResponseEntity<>(l,HttpStatus.FOUND);
    }
    @DeleteMapping("/delete_director")
    public ResponseEntity<String> deleteDirectorAndMovies(@RequestParam String director){
        movieService.deleteDirectorAndMovies(director);
        return new ResponseEntity<>("director and it's movies deleted successfully",HttpStatus.ACCEPTED);
    }
    @DeleteMapping("/delete_all_director")
    public ResponseEntity<String> deleteAllDirectors(){
        movieService.deleteAllDirectors();
        return new ResponseEntity<>("Deleted all Directors and their Movies",HttpStatus.ACCEPTED);
    }
}
