package com.mfu.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mfu.dao.Student_DAO;
import com.mfu.entity.Student_Information;

@Controller
public class Student_Controller {

	// @RequestMapping("/listStudent")
	// public ModelAndView listStudent(HttpServletRequest request) {
	// ModelAndView mv = new ModelAndView("listStudent.jsp");
	// List<Student_Information> studentList;
	// Student_DAO studentServ = new Student_DAO();
	// try {
	// studentList = studentServ.getAllStudents();
	// mv.addObject("studentList", studentList);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// studentServ.closeEntityManager();
	// return mv;
	// }

	// when you add new Student
	@RequestMapping("/newStudent")
	public ModelAndView newStudent() {
		ModelAndView mv = new ModelAndView("studentForm.jsp");
		Student_Information student = new Student_Information();
		mv.addObject("student", student);
		return mv;
	}

	@RequestMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student_Information student, BindingResult result,
			HttpServletRequest request) {
		Student_DAO studentServ = new Student_DAO();
		String roomKey = (String) request.getSession().getAttribute("roomKey");
		student.setRoomId(roomKey);
		try {
			if (student.getKey() == null) {
				studentServ.insertStudent(student);
			} else {
				studentServ.updateStudent(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		studentServ.closeEntityManager();
		return "redirect:listStudent.do?id=" + roomKey;
	}

	@RequestMapping("/editStudent")
	public ModelAndView editStudent(HttpServletRequest request) {
		String key = request.getParameter("id");
		Student_Information foundStudent;
		ModelAndView mv = new ModelAndView("studentForm.jsp");
		Student_DAO studentServ = new Student_DAO();
		try {
			foundStudent = studentServ.findStudentByKey(key);
			mv.addObject("student", foundStudent);
			mv.addObject("keyString", foundStudent.getKeyString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		studentServ.closeEntityManager();
		return mv;
	}

	@RequestMapping("/deleteStudent")
	public String deleteStudent(HttpServletRequest request) {
		String roomKey = (String) request.getSession().getAttribute("roomKey");
		Student_DAO studentServ = new Student_DAO();
		studentServ.deleteStudent(request.getParameter("id"));
		studentServ.closeEntityManager();
		return "redirect:listStudent.do?id=" + roomKey;
	}

	// when you view student in student (getkeyroom to see student)
	@RequestMapping("/listStudent")
	public ModelAndView listStudent(HttpServletRequest request) {
		Student_DAO studentServ = new Student_DAO();
		String key = request.getParameter("id");
		request.getSession().setAttribute("roomKey", key);
		ModelAndView mv = new ModelAndView("listStudent.jsp");
		List<Student_Information> studentList;
		try {
			studentList = studentServ.getStudentByRoom(key);
			mv.addObject("studentList", studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		studentServ.closeEntityManager();
		return mv;
	}

	@RequestMapping("/listStudentStu")
	public ModelAndView listStudentStu(HttpServletRequest request) {
		Student_DAO studentServ = new Student_DAO();
		String key = request.getParameter("id");
		ModelAndView mv = new ModelAndView("listStudentStu.jsp");
		List<Student_Information> studentList;
		try {
			studentList = studentServ.getStudentByRoom(key);
			mv.addObject("studentList", studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		studentServ.closeEntityManager();
		return mv;
	}

	// when you view profile student (getkey student)
	@RequestMapping("/studentProfile")
	public ModelAndView studentProfile(HttpServletRequest request) {
		Student_DAO studentServ = new Student_DAO();
		String key = request.getParameter("id");
		ModelAndView mv = new ModelAndView("studentProfile.jsp");
		List<Student_Information> studentList;
		try {
			studentList = studentServ.getStudentByKey(key);
			mv.addObject("studentList", studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		studentServ.closeEntityManager();
		return mv;
	}

	// when you view profile student (getkey student)
	@RequestMapping("/studentProfileStu")
	public ModelAndView studentProfileStu(HttpServletRequest request) {
		Student_DAO studentServ = new Student_DAO();
		String key = request.getParameter("id");
		ModelAndView mv = new ModelAndView("studentProfileStu.jsp");
		List<Student_Information> studentList;
		try {
			studentList = studentServ.getStudentByKey(key);
			mv.addObject("studentList", studentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		studentServ.closeEntityManager();
		return mv;
	}

//	@RequestMapping("/checkStudent")
//	public String checkStudent(HttpServletRequest request) {
//		String studentKey = (String) request.getSession().getAttribute("studentKey");
//		Student_DAO studentServ = new Student_DAO();
//		Student_Information student = studentServ.findStudentByKey(request.getParameter("id"));
//		if (student.isVisited()) {
//			student.setVisited(false);
//		} else {
//			student.setVisited(true);
//		}
//		studentServ.updateStudent(student);
//		studentServ.closeEntityManager();
//		return "redirect:studentProfile.do?id=" + studentKey;
//	}
}
