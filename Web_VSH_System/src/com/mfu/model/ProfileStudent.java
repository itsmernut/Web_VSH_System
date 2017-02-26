package com.mfu.model;

import com.mfu.entity.Student_Information;
import com.mfu.entity.Visited_Information;

public class ProfileStudent {

	private Student_Information student ;
	private Visited_Information visited ;
	
	public Student_Information getStudent() {
		return student;
	}
	public void setStudent(Student_Information student) {
		this.student = student;
	}
	public Visited_Information getVisited() {
		return visited;
	}
	public void setVisited(Visited_Information visited) {
		this.visited = visited;
	}
	
}
