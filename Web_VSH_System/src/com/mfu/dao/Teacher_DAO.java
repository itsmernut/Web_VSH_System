package com.mfu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.appengine.api.datastore.KeyFactory;
import com.mfu.entity.Student_Information;
import com.mfu.entity.Teacher_Information;

public class Teacher_DAO {

	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");
	private EntityManager emteacher = null;
	public Teacher_DAO() {
		emteacher = emfInstance.createEntityManager();
	}
	
	public List<Teacher_Information> getAllTeachers() {
		List<Teacher_Information> res = null;
		try {
			Query teacher = emteacher.createQuery("select teacher from Teacher_Information teacher");
			res = teacher.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public Teacher_Information findTeacherByKey(String key) {
		Teacher_Information res = null;
		try {
			Query teacher = emteacher.createQuery("select teacher from Teacher_Information teacher where teacher.key = :key");
			teacher.setParameter("key", KeyFactory.stringToKey(key));
			 res = (Teacher_Information)teacher.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public void updateTeacher(Teacher_Information teacher) {
		try {
			emteacher.merge(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void insertTeacher(Teacher_Information teacher) {
		try {
			emteacher.persist(teacher);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTeacher(String key) {
		Teacher_Information teacher = this.findTeacherByKey(key);
		if (teacher != null)
			emteacher.remove(teacher);
	}
	
	public void closeEntityManager() {
		if (emteacher != null)
			emteacher.close();
	}
	
	public List<Teacher_Information> getTeacherByRoom(String key) {
		List<Teacher_Information> res = null;
		try {
			Query teacher = emteacher.createQuery("select teacher from Teacher_Information teacher where teacher.roomId = :key")
			.setParameter("key", key);
			 res = teacher.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Teacher_Information> getTeacherByKey(String key) {
		List<Teacher_Information> res = null;
		try {
			Query teacher = emteacher.createQuery("select teacher from Teacehr_Information teacher where teacher.key = :key")
			.setParameter("key", key);
			 res = teacher.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
