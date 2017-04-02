package com.mfu.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mfu.dao.Teacher_DAO;
import com.mfu.entity.Teacher_Information;

@Controller
public class Teacher_Contorller {

	@RequestMapping("/listTeacher")
	public ModelAndView listTeacher(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listTeacher.jsp");
		List<Teacher_Information> teacherList;
		Teacher_DAO teacherServ = new Teacher_DAO();
		try {
			teacherList = teacherServ.getAllTeachers();
			mv.addObject("teacherList", teacherList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		teacherServ.closeEntityManager();
		return mv;
	}
	
	@RequestMapping("/newTeacher")
	public ModelAndView newTeacher() {
		ModelAndView mv = new ModelAndView("TeacherForm.jsp");
		Teacher_Information teacher = new Teacher_Information();
		mv.addObject("teacher", teacher);
		return mv;
	}
	
	@RequestMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher_Information teacher, BindingResult result,
			HttpServletRequest request) {
		Teacher_DAO teacherServ = new Teacher_DAO();
		try {
			if (teacher.getKey() == null) {
				teacherServ.insertTeacher(teacher);
			} else {
				teacherServ.updateTeacher(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		teacherServ.closeEntityManager();
		return "redirect:listTeacher.do";
	}
	
	@RequestMapping("/editTeacher")
	public ModelAndView editTeacher(HttpServletRequest request) {
		Teacher_DAO teacherServ = new Teacher_DAO();
		String key = request.getParameter("id");
		Teacher_Information foundTeacher;
		ModelAndView mv = new ModelAndView("teacherForm.jsp");
		try {
			foundTeacher = teacherServ.findTeacherByKey(key);		
			mv.addObject("teacher", foundTeacher);
			mv.addObject("keyString",foundTeacher.getKeyString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		teacherServ.closeEntityManager();			
		return mv;
	}
	
	@RequestMapping("/deleteTeacher")
	public String deleteTeacher(HttpServletRequest request) {
		Teacher_DAO teacherServ = new Teacher_DAO();
		teacherServ.deleteTeacher(request.getParameter("id"));
		teacherServ.closeEntityManager();
		return "redirect:listTeacher.do";
	}
}
