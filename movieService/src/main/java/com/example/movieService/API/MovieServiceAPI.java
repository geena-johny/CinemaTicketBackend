package com.example.movieService.API;

 

import java.util.ArrayList;

 


import java.util.List;

 

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

 

import com.example.movieService.model.Movie;
import com.example.movieService.model.Show;
import com.example.movieService.service.MovieService;

 


@RestController
@CrossOrigin
@RequestMapping(value="/movieservice")
public class MovieServiceAPI {
    @Autowired
    private MovieService movieService;
    @Autowired
    Environment env;
    
        
    
    @PostMapping(value="/addMovie")
    public JSONObject addMovie(@RequestBody Movie movieDetails) throws Exception{
        try {
            movieService.addMovie(movieDetails);
            String name=movieDetails.getMovieName();
            JSONObject obj=new JSONObject();
            obj.put("Movie "+name, "successfully added");
            return obj;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
        }
    }
    
    
    @PostMapping(value="/deleteMovie")
    public JSONObject deleteMovie(@RequestBody Movie movie) throws Exception{
        try {
            movieService.deleteMovie(movie);
            String name=movie.getMovieName();
            JSONObject obj=new JSONObject();
            obj.put("Movie "+name, "successfully deleted");
            return obj;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
        }
        
    }
    
    
    @GetMapping(value="/getMovie")
    public ResponseEntity <List<Movie>> getMovie() throws Exception{
        try {
            List<Movie> movies=new ArrayList<Movie>();
            movies=movieService.getMovieList();
            ResponseEntity<List<Movie>> movieList=new ResponseEntity<List<Movie>>(movies,HttpStatus.OK);
            return movieList;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
        }
    }
    
    
    @PostMapping(value="/updateMovie")
    public JSONObject updateMovie(@RequestBody Movie movieDetails) throws Exception{
        try {
            movieService.updateMovie(movieDetails);
//            String name=movieDetails.getMovieName(); 
            JSONObject obj=new JSONObject();
            obj.put("Movie", "successfully updated");
            return obj;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
        }
    }
    
    
    
    @PostMapping(value="/addShow")
    public JSONObject addShow(@RequestBody Show showDetails) throws Exception{
    	System.out.println("APIIII");
        try {
        	System.out.println(showDetails.getMovieName());
            movieService.addShow(showDetails);
//            Integer name=showDetails.getShowId();
            JSONObject obj=new JSONObject();
            obj.put("Show", "successfully added");
            return obj;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
        }
    }
    
    
    
    @PostMapping(value="/deleteShow")
    public JSONObject deleteShow(@RequestBody Show show) throws Exception{
        try {
        	System.out.println("API MOVIE");
        	Integer name=show.getShowId();
            movieService.deleteShow(show);
            JSONObject obj=new JSONObject();
            obj.put("Show "+name, "successfully deleted");
            return obj;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
        }
        
    }
    
    
    
    @GetMapping(value="/getShow")
    public ResponseEntity <List<Show>> getShow() throws Exception{
        try {
            List<Show> shows=new ArrayList<Show>();
            shows=movieService.getShowList();
            ResponseEntity<List<Show>> showList=new ResponseEntity<List<Show>>(shows,HttpStatus.OK);
            return showList;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
        }
    }
    
    
    

 

}
 