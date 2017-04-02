package com.mfu.web.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mfu.dao.Student_DAO;
import com.mfu.dao.Visited_DAO;
import com.mfu.entity.Student_Information;
import com.mfu.entity.Visited_Information;
import com.mfu.model.CheckedStudent;

@Controller
public class Visited_Controller {

	@RequestMapping("/listVisited")
	public ModelAndView listVisited(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listVisited.jsp");
		List<Visited_Information> visitedList;
		Visited_DAO visitedServ = new Visited_DAO();
		try {
			visitedList = visitedServ.getAllVisiteds();
			mv.addObject("visitedList", visitedList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		visitedServ.closeEntityManager();
		return mv;
	}

	@RequestMapping("/newVisited")
	public ModelAndView newVisited() {
		ModelAndView mv = new ModelAndView("visitedForm.jsp");
		Visited_Information visited = new Visited_Information();
		mv.addObject("visited", visited);
		return mv;
	}

	@RequestMapping("/saveVisited")
	public String saveVisited(@ModelAttribute("visited") Visited_Information visited, BindingResult result,
			HttpServletRequest request) {
		Visited_DAO visitedServ = new Visited_DAO();
		String studentKey = (String) request.getSession().getAttribute("roomKey");
		visited.setStudentId(studentKey);
		try {
			if (visited.getKey() == null) {
				visitedServ.insertVisited(visited);
			} else {
				visitedServ.updateVisited(visited);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		visitedServ.closeEntityManager();
		return "redirect:viewVisited.do?id=" + studentKey;
	}

	@RequestMapping("/deleteVisited")
	public String deleteVisited(HttpServletRequest request) {
		String studentKey = (String) request.getSession().getAttribute("studentKey");
		Visited_DAO visitedServ = new Visited_DAO();
		visitedServ.deleteVisited(request.getParameter("id"));
		visitedServ.closeEntityManager();
		return "redirect:listVisiteds.do";
	}

	// Record date tima when chick check
	@RequestMapping("/checkVisited")
	public String checkVisited(HttpServletRequest request) {
		Visited_DAO visitedServ = new Visited_DAO();
		String key = request.getParameter("id");
		request.getSession().setAttribute("studentKey", key);
		// request.getSession().setAttribute("teacherKey", key);
		ModelAndView mv = new ModelAndView("checkVisitByStudent.jsp");
		Visited_Information visited = visitedServ.getVisitedByStudent(key);
		if (visited != null) {
			if (visited.isVisited()) {
				visited.setVisited(false);
			} else {
				visited.setVisited(true);
			}
			visitedServ.updateVisited(visited);
		} else {
			Date currentTime = new Date();
			visited = new Visited_Information();
			visited.setDate(currentTime);
			visited.setStudentId(key);
			visited.setStudentId(key);
			visited.setVisited(true);
			visited.setTeacherId("teacher key");
			SimpleDateFormat format = new SimpleDateFormat("hh:mm");
			visited.setTime(format.format(currentTime));
			visitedServ.insertVisited(visited);
		}
		visitedServ.closeEntityManager();
		return "redirect:studentProfile.do?id=" + key;
	}

	@RequestMapping("/listVisiteds")
	public ModelAndView listVisiteds(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listVisiteds.jsp");
		List<Visited_Information> visitedList;
		List<Student_Information> studentList;
		Visited_DAO visitedServ = new Visited_DAO();
		Student_DAO studentServ = new Student_DAO();
		try {
			studentList = studentServ.getAllStudents();
			List<Student_Information> listVisitedStu = getAllVisitedStudent();
			List<CheckedStudent> listCheckedStudent = new ArrayList<CheckedStudent>();
			for (Student_Information student : studentList) {
				Visited_Information newVisited = new Visited_Information();
				CheckedStudent checkedStudent = new CheckedStudent();
				newVisited.setVisited(false);
				checkedStudent.setVisited(newVisited);
				for (Student_Information stu : listVisitedStu) {
					if (student.getKeyString().equals(stu.getKeyString())) {
						checkedStudent.setVisited(visitedServ.getVisitedByStudent(stu.getKeyString()));
						break;
					}
				}
				checkedStudent.setStudent(student);
				listCheckedStudent.add(checkedStudent);
			}
			// mv.addObject("visitedList", visitedList);
			// mv.addObject("studentList", studentList);
			mv.addObject("AllStudentWithVisited", listCheckedStudent);
		} catch (Exception e) {
			e.printStackTrace();
		}
		visitedServ.closeEntityManager();
		studentServ.closeEntityManager();
		return mv;
	}

	public List<Student_Information> getAllVisitedStudent() {
		Visited_DAO visitedServ = new Visited_DAO();
		List<Student_Information> listVisitedStu = new ArrayList<Student_Information>();
		List<Visited_Information> visitedList = visitedServ.getAllVisiteds();
		Student_DAO studentServ = new Student_DAO();
		for (Visited_Information visit : visitedList) {
			listVisitedStu.add(studentServ.findStudentByKey(visit.getStudentId()));
		}
		visitedServ.closeEntityManager();
		studentServ.closeEntityManager();
		return listVisitedStu;
	}

}
