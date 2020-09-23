package com.example.TheatreService.service;

import java.util.List;

import com.example.TheatreService.model.Theatre;


public interface TheatreService {
	public void addTheatre(Theatre theatre) throws Exception;
	public String updateTheatre(Theatre theatre) throws Exception;
	public void deleteTheatre(Theatre theatre) throws Exception;
	public List<Theatre> getTheatreList() throws Exception;
	

}
