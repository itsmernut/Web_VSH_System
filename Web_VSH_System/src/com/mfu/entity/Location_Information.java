package com.mfu.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@Entity
public class Location_Information {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Key key;
	private String studentId;
	private String xpoint;
	private String ypoint;
	
	public Key getKey() {
		return key;
	}
	public void setKey(Key key) {
		this.key = key;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getXpoint() {
		return xpoint;
	}
	public void setXpoint(String xpoint) {
		this.xpoint = xpoint;
	}
	public String getYpoint() {
		return ypoint;
	}
	public void setYpoint(String ypoint) {
		this.ypoint = ypoint;
	}
	public String getKeyString() {
		return KeyFactory.keyToString(key);
	}
	public void setKeyString(String keyString) {
		key = KeyFactory.stringToKey(keyString);
	}
}
