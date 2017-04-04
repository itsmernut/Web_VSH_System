package com.mfu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.appengine.api.datastore.KeyFactory;
import com.mfu.entity.Location_Information;

public class Location_DAO {

	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");
	private EntityManager emlocation = null;
	public Location_DAO() {
		emlocation = emfInstance.createEntityManager();
	}
	
	public List<Location_Information> getAllLocations() {
		List<Location_Information> res = null;
		try {
			Query location = emlocation.createQuery("select location from Location_Information location");
			res = location.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Location_Information findLocationByKey(String key) {
		Location_Information res = null;
		try {
			Query location = emlocation.createQuery("select location from Location_Information location where location.key = :key");
			location.setParameter("key", KeyFactory.stringToKey(key));
			 res = (Location_Information)location.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void updateLocation(Location_Information location) {
		try {
			emlocation.merge(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertLocation(Location_Information location) {
		try {
			emlocation.persist(location);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteLocation(String key) {
		Location_Information location = this.findLocationByKey(key);
		if (location != null)
			emlocation.remove(location);
	}
	
	public void closeEntityManager() {
		if (emlocation != null)
			emlocation.close();
	}
	
	public List<Location_Information> getLocationByStudent(String key) {
		List<Location_Information> res = null;
		try {
			Query location = emlocation.createQuery("select location from Location_Information location where location.studentId = :key")
			.setParameter("key", key);
			 res = location.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
