package com.mfu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.appengine.api.datastore.KeyFactory;
import com.mfu.entity.User_Information;
import com.mfu.entity.Room_Information;

public class User_DAO {

	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");
	private EntityManager emuser = null;
	public User_DAO() {
		emuser = emfInstance.createEntityManager();
	}
	
	public List<User_Information> getAllUsers() {
		List<User_Information> res = null;
		try {
			Query user = emuser.createQuery("select user from User_Information user");
			res = user.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public User_Information findUserByKey(String key) {
		User_Information res = null;
		try {
			Query user = emuser.createQuery("select user from User_Information user where user.key = :key");
			user.setParameter("key", KeyFactory.stringToKey(key));
			 res = (User_Information)user.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void updateUser(User_Information user) {
		try {
			emuser.merge(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertUser(User_Information user) {
		try {
			emuser.persist(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(String key) {
		User_Information user = this.findUserByKey(key);
		if (user != null)
			emuser.remove(user);
	}
	
	public void closeEntityManager() {
		if (emuser != null)
			emuser.close();
	}
}
