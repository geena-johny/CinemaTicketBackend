package com.example.movieService.model;

 

public class Movie {
    private String movieName;
    private String director;
    private String genre;
    private String language;
    
    
    public String getMovieName() {
        return movieName;
    }
    public void setMovieName(String movieName) {
        this.movieName=movieName;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director=director;
    }
    public String getGenre() {
        return genre;
    }
    public void setGenre(String genre) {
        this.genre=genre;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language=language;
    }

 

}