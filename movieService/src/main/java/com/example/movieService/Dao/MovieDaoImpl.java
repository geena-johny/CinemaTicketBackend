package com.example.movieService.Dao;

 

import java.util.ArrayList;


 

 

import java.util.List;

 

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

 

import org.springframework.stereotype.Repository;


import com.example.movieService.entity.MovieEntity;
import com.example.movieService.entity.ShowEntity;
import com.example.movieService.model.Movie;
import com.example.movieService.model.Show;

 

@Repository("movieDao")
public class MovieDaoImpl implements MovieDao{
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void addMovie(Movie movie) throws Exception{
        MovieEntity movieEntity=new MovieEntity();
        movieEntity.setMovieName(movie.getMovieName());
        movieEntity.setDirector(movie.getDirector());
        movieEntity.setGenre(movie.getGenre());
        movieEntity.setLanguage(movie.getLanguage());
        em.persist(movieEntity);
    }
    
//    @Override
//    public String deleteMovie(Movie movie) throws Exception{
//        MovieEntity movieEntity=em.find(MovieEntity.class, movie.getMovieName());
//        String name=movie.getMovieName();
//        em.remove(movieEntity);
//        return name;
//
// 
//
//    }
    
    
    @Override
    public String deleteMovie(Movie movie) throws Exception {
       
    		MovieEntity movieEntity= em.find(MovieEntity.class, movie.getMovieName());
            String q="select d from ShowEntity d where d.movieName=?1";
            Query query1=em.createQuery(q);
            query1.setParameter(1,movie.getMovieName());
       
            List<ShowEntity> showlist=query1.getResultList();
           
            System.out.println(showlist.size());	           
           
            if(    movieEntity!=null&& showlist.size()==0)  {
            	System.out.println("IFCONDITIONNN");
                Query query = em.createQuery("select a from MovieEntity a where a.movieName=:movieName");
                query.setParameter("movieName",movieEntity.getMovieName());
                List<MovieEntity > movielist=query.getResultList();
                for(MovieEntity  a: movielist) {
                    a.setMovieName(null);
                    a.setDirector(null);
                    a.setLanguage(null);
                    a.setGenre(null);
                }
                   
                em.remove(movieEntity);
                return movie.getMovieName();
                }
                return null;
       
        }
    
    
    @Override
    public Movie getMovie(String movieName) throws Exception {
        MovieEntity movieEntity=em.find(MovieEntity.class, movieName);
        if(movieEntity==null) return null;
        else {
            Movie movievar=new Movie();
            movievar.setMovieName(movieEntity.getMovieName());
            movievar.setDirector(movieEntity.getDirector());
            movievar.setLanguage(movieEntity.getLanguage());
            movievar.setGenre(movieEntity.getGenre());
            return movievar;
        }
        
    }
    
    @Override
    public List<Movie> getAllMovies() throws Exception{
        List<Movie> movies=new ArrayList<Movie>();
        Query query=em.createQuery("select u from MovieEntity u");
        List<MovieEntity> movieList=query.getResultList();
        if(movieList!=null) {
            for(MovieEntity movieEntity: movieList) {
                Movie movie=new Movie();
                movie.setMovieName(movieEntity.getMovieName());
                movie.setDirector(movieEntity.getDirector());
                movie.setGenre(movieEntity.getGenre());
                movie.setLanguage(movieEntity.getLanguage());
                movies.add(movie);
            }
        }return movies;
    }
    
    
    @Override
    public String updateMovie(Movie movie) throws Exception{
        MovieEntity movieEntity=em.find(MovieEntity.class,movie.getMovieName());
        if(movieEntity==null) {
            return null;
        }
        
        movieEntity.setDirector(movie.getDirector());
        movieEntity.setGenre(movie.getGenre());
        movieEntity.setLanguage(movie.getLanguage());
        
        Query query=em.createQuery("select u from MovieEntity u where u.movieName=:movieName");
        query.setParameter("movieName", movieEntity.getMovieName());
        List<MovieEntity> movies=query.getResultList();
        for(MovieEntity m:movies) {
            m.setDirector(movieEntity.getDirector());
            m.setGenre(movieEntity.getGenre());
            m.setLanguage(movieEntity.getLanguage());
            return movie.getMovieName();
        }
        return null;
        
    }
    
    
    @Override
    public void addShow(Show show) throws Exception{
    	System.out.println("HLWWWWWWW");
        ShowEntity showEntity=new ShowEntity();
        System.out.println( show.getMovieName());
        showEntity.setMovieName(show.getMovieName());
        showEntity.setTheatreName(show.getTheatreName());
        showEntity.setTime(show.getTime());
        showEntity.setSeatsAvailable(show.getSeatsAvailable());
        em.persist(showEntity);
    }
    
    
    
    @Override
    public Integer deleteShow(Show show) throws Exception{
    	System.out.println("DAO MOVIE");
        ShowEntity showEntity=em.find(ShowEntity.class, show.getShowId());
        Integer name=show.getShowId();
        em.remove(showEntity);
        return name;

 

    }
    
    
    
    @Override
    public Show getShow(Integer showId) throws Exception {
        ShowEntity showEntity=em.find(ShowEntity.class, showId);
        if(showEntity==null) return null;
        else {
            Show showvar=new Show();
            showvar.setShowId(showEntity.getShowId());
            showvar.setMovieName(showEntity.getMovieName());
            showvar.setTheatreName(showEntity.getTheatreName());
            showvar.setSeatsAvailable(showEntity.getSeatsAvailable());
            showvar.setTime(showEntity.getTime());
            return showvar;
        }
        
    }
    
    
    @Override
    public List<Show> getShowList() throws Exception{
        List<Show> shows=new ArrayList<Show>();
        Query query=em.createQuery("select u from ShowEntity u");
        List<ShowEntity> showList=query.getResultList();
        if(showList!=null) {
            for(ShowEntity showEntity: showList) {
                Show show=new Show();
                show.setShowId(showEntity.getShowId());
                show.setMovieName(showEntity.getMovieName());
                show.setTheatreName(showEntity.getTheatreName());
                show.setSeatsAvailable(showEntity.getSeatsAvailable());
                show.setTime(showEntity.getTime());
                shows.add(show);
            }
        }return shows;
    }

 

}