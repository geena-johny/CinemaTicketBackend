package com.example.TheatreService.API;

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

import com.example.TheatreService.model.Theatre;
import com.example.TheatreService.service.TheatreService;



@RestController
@CrossOrigin
@RequestMapping(value="/theatreservice")
public class TheatreAPI {
	
	@Autowired
	private TheatreService theatreService;
	@Autowired
	Environment env;
	
	@PostMapping(value="/addTheatre")
	public JSONObject addTheatre(@RequestBody Theatre theatreDetails) throws Exception{
		try {
			theatreService.addTheatre(theatreDetails);
			String name=theatreDetails.getTheatreName();
			JSONObject obj=new JSONObject();
			obj.put("Theatre "+name, "successfully added");
			return obj;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
		}
	}
	
	@PostMapping(value="/deleteTheatre")
	public JSONObject deleteTheatre(@RequestBody Theatre theatre) throws Exception{
		try {
			theatreService.deleteTheatre(theatre);
			String name=theatre.getTheatreName();
			JSONObject obj=new JSONObject();
			obj.put("Theatre "+name, "successfully deleted");
			return obj;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
		}
		
	}
	
	
	@GetMapping(value="/getTheatre")
	public ResponseEntity <List<Theatre>> getTheatre() throws Exception{
		try {
			List<Theatre> theatres=new ArrayList<Theatre>();
			theatres=theatreService.getTheatreList();
			ResponseEntity<List<Theatre>> theatreList=new ResponseEntity<List<Theatre>>(theatres,HttpStatus.OK);
			return theatreList;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
		}
	}
	
	
	@PostMapping(value="/updateTheatre")
	public JSONObject updateMovie(@RequestBody Theatre theatreDetails) throws Exception{
		try {
			theatreService.updateTheatre(theatreDetails);
			String name=theatreDetails.getTheatreName(); 
			JSONObject obj=new JSONObject();
			obj.put("Theatre "+name, "successfully updated");
			return obj;
		}
		catch(Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,env.getProperty(e.getMessage()));
		}
	}
	

}
