package com.capg.ewallet.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.capg.ewallet.entities.WalletUser;



@Repository
@Transactional
public class UserRepositoryImpl  implements IUserRepository{

	
	@PersistenceContext
	EntityManager entityManager;
	
	
	@Override
	public WalletUser addUser(WalletUser user) {
		// TODO Auto-generated method stub
		entityManager.persist(user);
		return user;
	}

	@Override
	public WalletUser showUserById(int userId) {
		// TODO Auto-generated method stub
	    WalletUser user = entityManager.find(WalletUser.class, userId);
		return user;
	}

	@Override
	public WalletUser logInUser(String userName, String password) {
		// TODO Auto-generated method stub
		
		String qry = "select w from WalletUser w where w.userNamee=:userName and w.userPassword=:password";
		TypedQuery<WalletUser> query = entityManager.createQuery(qry,WalletUser.class);
		query.setParameter("userName", userName);
		query.setParameter("password", password);
		List<WalletUser> list = query.getResultList();
		   WalletUser user = null ;
		   
		   if(! list.isEmpty())
		     user = list.get(0);
		  
			 return user;
	}

	@Override
	public WalletUser updatePassword(int userId, String password) {
		// TODO Auto-generated method stub
		 WalletUser user = entityManager.find(WalletUser.class, userId);
		 
		 user.setPassword(password);
		 entityManager.merge(user);
		 
		 return user;
	}

	@Override
	public String logOutUser(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
}