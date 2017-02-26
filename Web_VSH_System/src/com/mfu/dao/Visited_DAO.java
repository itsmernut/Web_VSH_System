package com.mfu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.appengine.api.datastore.KeyFactory;
import com.mfu.entity.Visited_Information;

public class Visited_DAO {

	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");
	private EntityManager emvisited = null;
	public Visited_DAO() {
		emvisited = emfInstance.createEntityManager();
	}
	
	public List<Visited_Information> getAllVisiteds() {
		List<Visited_Information> res = null;
		try {
			Query visited = emvisited.createQuery("select visited from Visited_Information visited");
			res = visited.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Visited_Information findVisitedByKey(String key) {
		Visited_Information res = null;
		try {
			Query visited = emvisited
					.createQuery("select visited from Visited_Information visited where visited.key = :key");
			visited.setParameter("key", KeyFactory.stringToKey(key));
			res = (Visited_Information) visited.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void updateVisited(Visited_Information visited) {
		try {
			emvisited.merge(visited);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertVisited(Visited_Information visited) {
		try {
			emvisited.persist(visited);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteVisited(String key) {
		Visited_Information visited = this.findVisitedByKey(key);
		if (visited != null)
			emvisited.remove(visited);
	}

	public void closeEntityManager() {
		if (emvisited != null)
			emvisited.close();
	}

	public Visited_Information getVisitedByStudent(String key) {
		Visited_Information visited = null;
		try {
			Query q = emvisited.createQuery("select visited from Visited_Information visited where visited.studentId = :key")
			.setParameter("key", key);
			List<Visited_Information> res = q.getResultList();
			visited = res.get(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return visited;
	}
	
//	public List<Visited_Information> getVisitedByKey(String key) {
//		List<Visited_Information> res = null;
//		try {
//			Query visited = emvisited.createQuery("select visited from Visited_Information visited where visited.key = :key")
//			.setParameter("key", key);
//			 res = visited.getResultList();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return res;
//	}
}
