package com.example.movieService.Dao;

 

import java.util.List;

 


import com.example.movieService.model.Movie;
import com.example.movieService.model.Show;

 

public interface MovieDao {

 

    public void addMovie(Movie movie) throws Exception;
    public String updateMovie(Movie movie) throws Exception;
    public String deleteMovie(Movie movie) throws Exception;
    public List<Movie> getAllMovies() throws Exception;
    public Movie getMovie(String movieName) throws Exception;
    public Show getShow(Integer showId) throws Exception;
    public Integer deleteShow(Show show) throws Exception;
    public void addShow(Show show) throws Exception;
    public List<Show> getShowList() throws Exception;
    
    

 

}