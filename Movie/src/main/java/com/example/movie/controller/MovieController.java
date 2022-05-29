package com.example.movie.controller;

import com.example.movie.model.Movie;
import com.example.movie.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/movie")
@RequiredArgsConstructor
public class MovieController {
    private final MovieService movieService;
    @GetMapping
    public ResponseEntity getMovies(){
        return ResponseEntity.status(200).body(movieService.getMovies());
    }
    @PostMapping
    public ResponseEntity addMovie(@RequestBody @Valid Movie movie){
        movieService.addMovie(movie);
        return ResponseEntity.status(201).body("Movie added");
    }
    @PutMapping
    public ResponseEntity updateMovie(@RequestBody @Valid Movie movie){
        movieService.updateMovie(movie);
        return ResponseEntity.status(200).body("Movie updated");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteMovie(@PathVariable String id){
        movieService.deleteMovie(id);
        return ResponseEntity.status(200).body("Movie deleted");
    }

}
