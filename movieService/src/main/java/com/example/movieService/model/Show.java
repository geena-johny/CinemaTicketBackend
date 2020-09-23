package com.example.movieService.model;

 

public class Show {
    private Integer showId;
    private String movieName;
    private String theatreName;
    private String time;
    private Integer seatsAvailable;
    
    public Integer getShowId(){
        return showId;    
    }
    public void setShowId(Integer showId) {
        this.showId=showId;
    }
    public String getMovieName(){
        return movieName;    
    }
    public void setMovieName(String movieName) {
        this.movieName=movieName;
    }
    public String getTheatreName(){
        return theatreName;    
    }
    public void setTheatreName(String theatreName) {
        this.theatreName=theatreName;
    }
    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time=time;
    }
    public Integer getSeatsAvailable() {
        return seatsAvailable;
    }
    public void setSeatsAvailable(Integer seatsAvailable) {
        this.seatsAvailable=seatsAvailable;
    }
    

 

}