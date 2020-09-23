package com.example.TheatreService.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.TheatreService.dao.TheatreDao;
import com.example.TheatreService.model.Theatre;



@Service(value="theatreService")
@Transactional
public class TheatreServiceImpl implements TheatreService{
	
	@Autowired
	TheatreDao theatreDao;
	
	@Override
	public void addTheatre(Theatre theatre) throws Exception{
		Theatre thtr=new Theatre();
		thtr=theatreDao.getTheatre(theatre.getTheatreName());
		if(thtr==null) {
			theatreDao.addTheatre(theatre);
		}
		if(thtr!=null) {
			throw new Exception("Service.THEATRE_ALREADY_EXISTS");
		}
	}
	
	
	@Override
	public String updateTheatre(Theatre theatre) throws Exception{
		String var=theatreDao.updateTheatre(theatre);
		if(var!=null) {
			String tname=theatre.getTheatreName();
			return tname;
		}
		else {
			throw new Exception("Service.THEATRE_CANT_BE_UPDATED");
		}
	}
	
	

	
	@Override
	public void deleteTheatre(Theatre theatre) throws Exception{
		Theatre theatres=new Theatre();
		theatres=theatreDao.getTheatre(theatre.getTheatreName());
		if(theatres!=null) {
			String str=theatreDao.deleteTheatre(theatre);
			if(str==null) {
				throw new Exception("Service.SHOW_ASSIGNED");
			}
		}
		if(theatres==null) {
			throw new Exception("Service.THEATRE_NOT_EXISTS");
		}
	}
	
	@Override
	public List<Theatre> getTheatreList() throws Exception{
		List<Theatre> theatreList =null;
		try {
			theatreList = theatreDao.getTheatreList();

			if (theatreList.isEmpty())
				throw new Exception("Service.THEATRES_NOT_FOUND");

		} catch (Exception e) {
			throw e;
		}
		return theatreList;
		
	}
	

}
