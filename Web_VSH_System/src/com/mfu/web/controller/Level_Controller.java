package com.mfu.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mfu.dao.Level_DAO;
import com.mfu.entity.Level_Information;

@Controller
public class Level_Controller {

	// when you view level
	@RequestMapping("/listLevel")
	public ModelAndView listLevel(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listLevel.jsp");
		List<Level_Information> levelList;
		Level_DAO levelServ = new Level_DAO();
		try {
			levelList = levelServ.getAllLevels();
			mv.addObject("levelList", levelList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		levelServ.closeEntityManager();
		return mv;
	}

	// when you add new level student
	@RequestMapping("/newLevelStudent")
	public ModelAndView newLevelStudent() {
		ModelAndView mv = new ModelAndView("levelFormStudent.jsp");
		Level_Information level = new Level_Information();
		mv.addObject("level", level);
		return mv;
	}

	// when you add new level teacher
	@RequestMapping("/newLevelTeacher")
	public ModelAndView newLevelTeacher() {
		ModelAndView mv = new ModelAndView("levelFormTeacher.jsp");
		Level_Information level = new Level_Information();
		mv.addObject("level", level);
		return mv;
	}

	// when you save new or update level student
	@RequestMapping("/saveLevelStudent")
	public String saveLevelStudent(@ModelAttribute("level") Level_Information level, BindingResult result,
			HttpServletRequest request) {
		Level_DAO levelServ = new Level_DAO();
		String userKey = (String) request.getSession().getAttribute("userKey");
		level.setUserId(userKey);
		try {
			if (level.getKey() == null) {
				levelServ.insertLevel(level);
			} else {
				levelServ.updateLevel(level);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		levelServ.closeEntityManager();
		return "redirect:getLevelByStudent.do?id=" + userKey;
	}

	// when you save new or update level teacher
	@RequestMapping("/saveLevelTeacher")
	public String saveLevelTeacher(@ModelAttribute("level") Level_Information level, BindingResult result,
			HttpServletRequest request) {
		Level_DAO levelServ = new Level_DAO();
		String userKey = (String) request.getSession().getAttribute("userKey");
		level.setUserId(userKey);
		try {
			if (level.getKey() == null) {
				levelServ.insertLevel(level);
			} else {
				levelServ.updateLevel(level);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		levelServ.closeEntityManager();
		return "redirect:getLevelByTeacher.do?id=" + userKey;
	}

	// when you update level
	@RequestMapping("/editLevelStudent")
	public ModelAndView editLevelStudent(HttpServletRequest request) {
		String key = request.getParameter("id");
		Level_Information foundLevel;
		ModelAndView mv = new ModelAndView("levelFormStudent.jsp");
		Level_DAO levelServ = new Level_DAO();
		try {
			foundLevel = levelServ.findLevelByKey(key);
			mv.addObject("level", foundLevel);
			mv.addObject("keyString", foundLevel.getKeyString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		levelServ.closeEntityManager();
		return mv;
	}

	// when you update level
	@RequestMapping("/editLevelTeacher")
	public ModelAndView editLevelTeacher(HttpServletRequest request) {
		String key = request.getParameter("id");
		Level_Information foundLevel;
		ModelAndView mv = new ModelAndView("levelFormTeacher.jsp");
		Level_DAO levelServ = new Level_DAO();
		try {
			foundLevel = levelServ.findLevelByKey(key);
			mv.addObject("level", foundLevel);
			mv.addObject("keyString", foundLevel.getKeyString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		levelServ.closeEntityManager();
		return mv;
	}

	// delelt level
	@RequestMapping("/deleteLevelStudent")
	public String deleteLevelStudent(HttpServletRequest request) {
		String userKey = (String) request.getSession().getAttribute("userKey");
		Level_DAO levelServ = new Level_DAO();
		levelServ.deleteLevel(request.getParameter("id"));
		levelServ.closeEntityManager();
		return "redirect:getLevelByStudent.do?id=" + userKey;
	}
	
	@RequestMapping("/deleteLevelTeacher")
	public String deleteLevelTeacher(HttpServletRequest request) {
		String userKey = (String) request.getSession().getAttribute("userKey");
		Level_DAO levelServ = new Level_DAO();
		levelServ.deleteLevel(request.getParameter("id"));
		levelServ.closeEntityManager();
		return "redirect:getLevelByTeacher.do?id=" + userKey;
	}

	@RequestMapping("/getLevelByTeacher")
	public ModelAndView getLevelByTeacher(HttpServletRequest request) {
		Level_DAO levelServ = new Level_DAO();
		String key = request.getParameter("id");
		request.getSession().setAttribute("userKey", key);
		ModelAndView mv = new ModelAndView("getLevelByTeacher.jsp");
		List<Level_Information> levelList;
		try {
			levelList = levelServ.getLevelByUser(key);
			mv.addObject("levelList", levelList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		levelServ.closeEntityManager();
		return mv;
	}

	@RequestMapping("/getLevelByStudent")
	public ModelAndView getLevelByStudent(HttpServletRequest request) {
		Level_DAO levelServ = new Level_DAO();
		String key = request.getParameter("id");
		request.getSession().setAttribute("userKey", key);
		ModelAndView mv = new ModelAndView("getLevelByStudent.jsp");
		List<Level_Information> levelList;
		try {
			levelList = levelServ.getLevelByUser(key);
			mv.addObject("levelList", levelList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		levelServ.closeEntityManager();
		return mv;
	}
}
