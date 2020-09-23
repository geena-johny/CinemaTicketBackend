package com.example.movieService.service;

 

import java.util.List;

 

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

 

import com.example.movieService.Dao.MovieDao;
import com.example.movieService.model.Movie;
import com.example.movieService.model.Show;

 

@Service(value="movieService")
@Transactional
public class MovieServiceImpl implements MovieService{
    
    @Autowired
    MovieDao movieDao;
    
    @Override
    public void addMovie(Movie movieDetails) throws Exception {
        Movie movie=new Movie();
        movie=movieDao.getMovie(movieDetails.getMovieName());
        if(movie==null) {
            movieDao.addMovie(movieDetails);
        }
        if(movie!=null) {
            throw new Exception("Service.MOVIE_ALREADY_EXISTS");
        }
        
    }
    
    @Override
    public void deleteMovie(Movie movie) throws Exception{
        Movie movies=new Movie();
        movies=movieDao.getMovie(movie.getMovieName());
        if(movies!=null) {
            String str=movieDao.deleteMovie(movie);
            if(str==null) {
            	throw new Exception("Service.SHOW_ASSIGNED");
            }
        }
        if(movies==null) {
            throw new Exception("Service.MOVIE_NOT_EXISTS");
        }
        
    }
    
    @Override
    public String updateMovie(Movie movie) throws Exception{
        String var=movieDao.updateMovie(movie);
        if(var!=null) {
            String mname=movie.getMovieName();
            return mname;
        }
        else {
            throw new Exception("Service.MOVIE_CANT_BE_UPDATED");
        }
    }
    
    @Override
    public List<Movie> getMovieList() throws Exception{
        List<Movie> movieList =null;
        try {
            movieList = movieDao.getAllMovies();

 

            if (movieList.isEmpty())
                throw new Exception("Service.MOVIES_NOT_FOUND");

 

        } catch (Exception e) {
            throw e;
        }
        return movieList;
        
    }
    
    
    @Override
    public void addShow(Show showDetails) throws Exception {
        Show show=new Show();
        System.out.println("SERVICEEEE");
        movieDao.addShow(showDetails);
//        show=movieDao.getShow(showDetails.getShowId());
//        if(show==null) {
//            movieDao.addShow(showDetails);
//        }
//        if(show!=null) {
//            throw new Exception("Service.SHOW_ALREADY_EXISTS");
//        }
        
    }
    
    
    @Override
    public void deleteShow(Show show) throws Exception{
        Show shows=new Show();
        shows=movieDao.getShow(show.getShowId());
        if(shows!=null) {
            movieDao.deleteShow(show);
        }
        if(shows==null) {
            throw new Exception("Service.SHOW_NOT_EXISTS");
        }
        
    }
    
    
    @Override
    public List<Show> getShowList() throws Exception{
        List<Show> showList =null;
        try {
            showList = movieDao.getShowList();

 

            if (showList.isEmpty())
                throw new Exception("Service.SHOWS_NOT_FOUND");

 

        } catch (Exception e) {
            throw e;
        }
        return showList;
        
    }

 

}