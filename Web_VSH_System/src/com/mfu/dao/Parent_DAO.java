package com.mfu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.appengine.api.datastore.KeyFactory;
import com.mfu.entity.Location_Information;
import com.mfu.entity.Parent_Information;

public class Parent_DAO {

	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");
	private EntityManager emparent = null;
	public Parent_DAO() {
		emparent = emfInstance.createEntityManager();
	}
	
	public List<Parent_Information> getAllParents() {
		List<Parent_Information> res = null;
		try {
			Query parent = emparent.createQuery("select parent from Parent_Information parent");
			res = parent.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Parent_Information findParentByKey(String key) {
		Parent_Information res = null;
		try {
			Query parent = emparent.createQuery("select parent from Parent_Information parent where parent.key = :key");
			parent.setParameter("key", KeyFactory.stringToKey(key));
			 res = (Parent_Information)parent.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void updateParent(Parent_Information parent) {
		try {
			emparent.merge(parent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertParent(Parent_Information parent) {
		try {
			emparent.persist(parent);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteParent(String key) {
		Parent_Information parent = this.findParentByKey(key);
		if (parent != null)
			emparent.remove(parent);
	}
	
	public void closeEntityManager() {
		if (emparent != null)
			emparent.close();
	}
	
	public List<Parent_Information> getParentByStudent(String key) {
		List<Parent_Information> res = null;
		try {
			Query parent = emparent.createQuery("select parent from Parent_Information parent where parent.studentId = :key")
			.setParameter("key", key);
			 res = parent.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
