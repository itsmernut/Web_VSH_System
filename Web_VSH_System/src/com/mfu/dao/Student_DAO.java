package com.mfu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.google.appengine.api.datastore.KeyFactory;
import com.mfu.entity.Student_Information;
import com.mfu.entity.Visited_Information;

public class Student_DAO {

	private static final EntityManagerFactory emfInstance = Persistence
			.createEntityManagerFactory("transactions-optional");
	private EntityManager emstudent = null;
	public Student_DAO() {
		emstudent = emfInstance.createEntityManager();
	}

	public List<Student_Information> getAllStudents() {
		List<Student_Information> res = null;
		try {
			Query student = emstudent.createQuery("select student from Student_Information student");
			res = student.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public Student_Information findStudentByKey(String key) {
		Student_Information res = null;
		try {
			Query student = emstudent
					.createQuery("select student from Student_Information student where student.key = :key");
			student.setParameter("key", KeyFactory.stringToKey(key));
			//res = (Student_Information) student.getSingleResult();
			res = (Student_Information) student.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void updateStudent(Student_Information student) {
		try {
			emstudent.merge(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insertStudent(Student_Information student) {
		try {
			emstudent.persist(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deleteStudent(String key) {
		Student_Information student = this.findStudentByKey(key);
		if (student != null)
			emstudent.remove(student);
	}

	public void closeEntityManager() {
		if (emstudent != null)
			emstudent.close();
	}

	public List<Student_Information> getStudentByRoom(String key) {
		List<Student_Information> res = null;
		try {
			Query student = emstudent.createQuery("select student from Student_Information student where student.roomId = :key")
			.setParameter("key", key);
			 res = student.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Student_Information> getStudentByKey(String key) {
		List<Student_Information> res = null;
		try {
			Query student = emstudent.createQuery("select student from Student_Information student where student.key = :key")
			.setParameter("key", key);
			 res = student.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Student_Information> getProfileStudent() {
		List<Student_Information> res = null;
		try {
			Query student = emstudent.createQuery("select student from Student_Information student where student.key = :key");
			res = student.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}
}
