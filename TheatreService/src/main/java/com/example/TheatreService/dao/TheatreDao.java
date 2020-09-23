package com.example.TheatreService.dao;

import java.util.List;

import com.example.TheatreService.model.Theatre;

public interface TheatreDao {
	public void addTheatre(Theatre theatre) throws Exception;
	public String updateTheatre(Theatre theatre) throws Exception;
	public String deleteTheatre(Theatre theater) throws Exception;
	public List<Theatre> getTheatreList() throws Exception;
	public Theatre getTheatre(String string) throws Exception;
	
	

}
