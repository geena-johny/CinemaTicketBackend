package com.example.UserService.user;

import java.util.List;

import javax.persistence.EntityManager;


import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.UserService.entity.UserEntity;
import com.example.UserService.model.Login;
import com.example.UserService.model.User;




@Repository("userDao")
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addUser(User user) throws Exception{
		UserEntity userEntity=new UserEntity();
		userEntity.setUsername(user.getUserName());
		userEntity.setPassword(user.getPassword());
		userEntity.setEmailId(user.getEmailId());
		userEntity.setPhoneNumber(user.getPhoneNumber());
//		userEntity.setRole(user.getRole());
		em.persist(userEntity);
	}
	
	@Override
	public User getUser(String userName) throws Exception {
		UserEntity userEntity=em.find(UserEntity.class, userName);
		if(userEntity==null) return null;
		else {
			User uservar=new User();
			uservar.setUserName(userEntity.getUsername());
			uservar.setPassword(userEntity.getPassword());
			uservar.setEmailId(userEntity.getEmailId());
			uservar.setPhoneNumber(userEntity.getPhoneNumber());
//			uservar.setRole(userEntity.getRole());
			return uservar;
		}
		
	}
	
	
	@Override
	public Login authenticateUser(String userName, String password)throws Exception{
		Query q=em.createQuery("select c from UserEntity c where c.userName=?1 and c.password=?2");
		q.setParameter(1,userName);
		q.setParameter(2, password);
		List<UserEntity>entityList=q.getResultList();
		
		if(entityList.isEmpty()) {
			return null;
		}
		UserEntity userEntity=entityList.get(0);
		if(userEntity!=null) {
			Login user=new Login();
			user.setPassword(userEntity.getPassword());
			user.setUserName(userEntity.getUsername());
			
			return user;
		}return null;
	}
	
	@Override
	public String getPasswordOfUser(String userName) {
		
		String password = null;
		userName = userName.toLowerCase();
		UserEntity userEntity = em.find(UserEntity.class, userName);
		if (userEntity!=null){
			password = userEntity.getPassword();
		}
		
		return password;
	}

	@Override
	public User getUserByPhoneNumber(String phoneNumber) {
		
		UserEntity userEntity = null;
		User user=null;

		Query query = em.createQuery("select u from UserEntity u where u.phoneNumber = :phoneNumber");
		query.setParameter("phoneNumber", phoneNumber);
		List<UserEntity> userEntities = query.getResultList();
		
		if(!userEntities.isEmpty()){
			userEntity = userEntities.get(0);
			user = new User();
			
			user.setEmailId(userEntity.getEmailId());
			user.setUserName(userEntity.getUsername());
			user.setPhoneNumber(userEntity.getPhoneNumber());
		}
		return user;
	}
	
	
	
	
	@Override
	public void updateProfile(User user) {

		UserEntity userEntity = em.find(UserEntity.class, user.getUserName().toLowerCase());
		
		userEntity.setEmailId(user.getEmailId());
		userEntity.setPassword(user.getPassword());

		
	}
	
	@Override
	public void changePassword(String userName, String newHashedPassword) {

		UserEntity userEntity = em.find(UserEntity.class, userName);
		
		userEntity.setPassword(newHashedPassword);

	}
	
	
}
