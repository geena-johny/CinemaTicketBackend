package com.example.movieService.service;

 

import java.util.List;

 


import com.example.movieService.model.Movie;
import com.example.movieService.model.Show;

 

public interface MovieService {
    public void addMovie(Movie movieDetails) throws Exception;
    public void deleteMovie(Movie movie) throws Exception;
    public List<Movie> getMovieList() throws Exception;
    public String updateMovie(Movie movie) throws Exception;
    void addShow(Show showDetails) throws Exception;
    void deleteShow(Show show) throws Exception;
    public List<Show> getShowList() throws Exception;

 

}