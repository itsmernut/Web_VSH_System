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
		ModelAndView mv = new ModelAndView("teacherForm.jsp");
		Teacher_Information teacher = new Teacher_Information();
		mv.addObject("teacher", teacher);
		return mv;
	}
	@RequestMapping("/saveTeacher")
	public String saveTeacher(@ModelAttribute("teacher") Teacher_Information teacher, BindingResult result,
			HttpServletRequest request) {
		Teacher_DAO teacherServ = new Teacher_DAO();
		String roomKey = (String) request.getSession().getAttribute("roomKey");
		teacher.setRoomId(roomKey);
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
		return "redirect:getTeacherByRoom.do?id="+roomKey;
	}
	@RequestMapping("/editTeacher")
	public ModelAndView editTeacher(HttpServletRequest request) {
		String key = request.getParameter("id");
		Teacher_Information foundTeacher;
		ModelAndView mv = new ModelAndView("teacherForm.jsp");
		Teacher_DAO teacherServ = new Teacher_DAO();
		try {
			foundTeacher = teacherServ.findTeacherByKey(key);
			mv.addObject("teacher", foundTeacher);
			mv.addObject("keyString", foundTeacher.getKeyString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		teacherServ.closeEntityManager();
		return mv;
	}
	@RequestMapping("/deleteTeacher")
	public String deleteTeacher(HttpServletRequest request) {
		String roomKey = (String) request.getSession().getAttribute("roomKey");
		Teacher_DAO teacherServ = new Teacher_DAO();
		teacherServ.deleteTeacher(request.getParameter("id"));
		teacherServ.closeEntityManager();
		return "redirect:getTeacherByRoom.do?id="+roomKey;
	}
	
	@RequestMapping("/getTeacherByRoom")
	public ModelAndView getTeacherByRoom(HttpServletRequest request) {
		Teacher_DAO teacherServ = new Teacher_DAO();
		String key = request.getParameter("id");
		request.getSession().setAttribute("roomKey", key);
		ModelAndView mv = new ModelAndView("getTeacherByRoom.jsp");
		List<Teacher_Information> teacherList;
		try {
			teacherList = teacherServ.getTeacherByRoom(key);
			mv.addObject("teacherList", teacherList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		teacherServ.closeEntityManager();
		return mv;
	}
	
	//when you view profile teacher   (getkey teacher)
		@RequestMapping("/getTeacherProfile")
		public ModelAndView getTeacherProfile(HttpServletRequest request) {
			Teacher_DAO teacherServ = new Teacher_DAO();
			String key = request.getParameter("id");
			ModelAndView mv = new ModelAndView("getTeacherProfile.jsp");
			List<Teacher_Information> teacherList;
			try {
				teacherList = teacherServ.getTeacherByKey(key);
				mv.addObject("teacherList", teacherList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			teacherServ.closeEntityManager();
			return mv;
		}
}
