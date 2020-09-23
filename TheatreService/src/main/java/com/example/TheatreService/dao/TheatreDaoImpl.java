package com.example.TheatreService.dao;

import java.util.ArrayList;



import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.TheatreService.Entity.ShowEntity;
import com.example.TheatreService.Entity.TheatreEntity;
import com.example.TheatreService.model.Theatre;




@Repository("theatreDao")
public class TheatreDaoImpl implements TheatreDao {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addTheatre(Theatre theatre) throws Exception{
		TheatreEntity theatreEntity=new TheatreEntity();
		theatreEntity.setTheatreName(theatre.getTheatreName());
		theatreEntity.setLocation(theatre.getLocation());
		theatreEntity.setSeatingCapacity(theatre.getSeatingCapacity());
		theatreEntity.setRate(theatre.getRate());
		em.persist(theatreEntity);
	}
	
	
//	@Override
//	public String deleteTheatre(Theatre theatre) throws Exception{
//		TheatreEntity theatreEntity=em.find(TheatreEntity.class, theatre.getTheatreName());
//		String name=theatre.getTheatreName();
//		em.remove(theatreEntity);
//		return name;
//	}
	
	 @Override
	    public String deleteTheatre(Theatre theatre) throws Exception {
	       
	            TheatreEntity theatreEntity= em.find(TheatreEntity.class, theatre.getTheatreName());
	            String q="select d from ShowEntity d where d.theatreName=?1";
	            Query query1=em.createQuery(q);
	            query1.setParameter(1,theatre.getTheatreName());
	       
	            List<ShowEntity> showlist=query1.getResultList();
	           
	            System.out.println(showlist.size());	           
	           
	            if(    theatreEntity!=null&& showlist.size()==0)  {
	            	System.out.println("IFCONDITIONNN");
	                Query query = em.createQuery("select a from TheatreEntity a where a.theatreName=:theatreName");
	                query.setParameter("theatreName",theatreEntity.getTheatreName());
	                List<TheatreEntity > theatrelist=query.getResultList();
	                for(TheatreEntity  a: theatrelist) {
	                    a.setTheatreName(null);
	                    a.setLocation(null);
	                    a.setRate(null);
	                    a.setSeatingCapacity(null);
	                }
	                   
	                em.remove(theatreEntity);
	                return theatre.getTheatreName();
	                }
	                return null;
	       
	        }
	
	
	@Override
	public Theatre getTheatre(String theatreName) throws Exception {
		TheatreEntity theatreEntity=em.find(TheatreEntity.class, theatreName);
		if(theatreEntity==null) return null;
		else {
			Theatre theatrevar=new Theatre();
			theatrevar.setTheatreName(theatreEntity.getTheatreName());
			theatrevar.setLocation(theatreEntity.getLocation());
			theatrevar.setSeatingCapacity(theatreEntity.getSeatingCapacity());
			theatrevar.setRate(theatreEntity.getRate());
			return theatrevar;
		}
		
	}
	
	
	@Override
	public List<Theatre> getTheatreList() throws Exception{
		List<Theatre> theatres=new ArrayList<Theatre>();
		Query query=em.createQuery("select u from TheatreEntity u");
		List<TheatreEntity> theatreList=query.getResultList();
		if(theatreList!=null) {
			for(TheatreEntity theatreEntity: theatreList) {
				Theatre theatre=new Theatre();
				theatre.setTheatreName(theatreEntity.getTheatreName());
				theatre.setLocation(theatreEntity.getLocation());
				theatre.setSeatingCapacity(theatreEntity.getSeatingCapacity());
				theatre.setRate(theatreEntity.getRate());
				theatres.add(theatre);
			}
		}return theatres;
	}
	
	
	
	@Override
	public String updateTheatre(Theatre theatre) throws Exception{
		TheatreEntity theatreEntity=em.find(TheatreEntity.class,theatre.getTheatreName());
		if(theatreEntity==null) {
			return null;
		}
		
		theatreEntity.setLocation(theatre.getLocation());
		theatreEntity.setSeatingCapacity(theatre.getSeatingCapacity());
		theatreEntity.setRate(theatre.getRate());
		
		Query query=em.createQuery("select u from TheatreEntity u where u.theatreName=:theatreName");
		query.setParameter("theatreName", theatreEntity.getTheatreName());
		List<TheatreEntity> movies=query.getResultList();
		for(TheatreEntity t:movies) {
			t.setLocation(theatreEntity.getLocation());
			t.setSeatingCapacity(theatreEntity.getSeatingCapacity());
			t.setRate(theatreEntity.getRate());
			return theatre.getTheatreName();
		}
		return null;
		
	}
	

	

}
