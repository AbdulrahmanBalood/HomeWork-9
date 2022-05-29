package com.example.movie.service;

import com.example.movie.model.Movie;
import com.example.movie.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@RequiredArgsConstructor
@Service
public class MovieService {
    private final MovieRepository movieRepository;
    public List<Movie> getMovies(){
        return movieRepository.findAll();
    }
    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }
    public void updateMovie(Movie movie){
        Movie newMovie = movieRepository.findById(movie.getId()).get();
        newMovie.setName(movie.getName());
        newMovie.setGenre(movie.getGenre());
        newMovie.setRating(movie.getRating());
        newMovie.setDuration(movie.getDuration());
        newMovie.setLaunchDate(movie.getLaunchDate());
        movieRepository.save(newMovie);
    }
    public void deleteMovie(String id){
        movieRepository.delete(movieRepository.findById(id).get());
    }
}
