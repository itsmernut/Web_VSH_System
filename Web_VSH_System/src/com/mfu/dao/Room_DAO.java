package com.mfu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.appengine.api.datastore.KeyFactory;
import com.mfu.entity.Room_Information;

public class Room_DAO {

	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");
	private EntityManager emroom = null;
	public Room_DAO() {
		emroom = emfInstance.createEntityManager();
	}
	
	public List<Room_Information> getAllRooms() {
		List<Room_Information> res = null;
		try {
			Query room = emroom.createQuery("select room from Room_Information room");
			res = room.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Room_Information findRoomByKey(String key) {
		Room_Information res = null;
		try {
			Query room = emroom.createQuery("select room from Room_Information room where room.key = :key");
			room.setParameter("key", KeyFactory.stringToKey(key));
			 res = (Room_Information)room.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void updateRoom(Room_Information room) {
		try {
			emroom.merge(room);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertRoom(Room_Information room) {
		try {
			emroom.persist(room);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteRoom(String key) {
		Room_Information room = this.findRoomByKey(key);
		if (room != null)
			emroom.remove(room);
	}
	
	public void closeEntityManager() {
		if (emroom != null)
			emroom.close();
	}
	
	public List<Room_Information> getRoomByLevel(String key) {
		List<Room_Information> res = null;
		try {
			Query room = emroom.createQuery("select room from Room_Information room where room.levelId = :key")
			.setParameter("key", key);
			 res = room.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
