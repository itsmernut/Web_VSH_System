package com.mfu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.appengine.api.datastore.KeyFactory;
import com.mfu.entity.Level_Information;

public class Level_DAO {

	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");
	private EntityManager emlevel = null;
	public Level_DAO() {
		emlevel = emfInstance.createEntityManager();
	}
	
	public List<Level_Information> getAllLevels() {
		List<Level_Information> res = null;
		try {
			Query level = emlevel.createQuery("select level from Level_Information level");
			res = level.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Level_Information findLevelByKey(String key) {
		Level_Information res = null;
		try {
			Query level = emlevel.createQuery("select level from Level_Information level where level.key = :key");
			level.setParameter("key", KeyFactory.stringToKey(key));
			 res = (Level_Information)level.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void updateLevel(Level_Information level) {
		try {
			emlevel.merge(level);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertLevel(Level_Information level) {
		try {
			emlevel.persist(level);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteLevel(String key) {
		Level_Information level = this.findLevelByKey(key);
		if (level != null)
			emlevel.remove(level);
	}
	
	public void closeEntityManager() {
		if (emlevel != null)
			emlevel.close();
	}
	
	public List<Level_Information> getLevelByUser(String key) {
		List<Level_Information> res = null;
		try {
			Query level = emlevel.createQuery("select level from Level_Information level where level.userId = :key")
			.setParameter("key", key);
			 res = level.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
