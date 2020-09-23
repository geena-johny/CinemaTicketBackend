package com.example.movieService.entity;

 

import javax.persistence.Column;

 

 


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

 

@Entity
@Table(name="movie")
public class MovieEntity {
    @Id
    @Column(name="movie_name")
    private String movieName;
    @Column(name="director")
    private String director;
    @Column(name="genre")
    private String genre;
    @Column(name="language")
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