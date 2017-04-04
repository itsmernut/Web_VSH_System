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
import com.mfu.entity.Teacher_Information;

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
	@RequestMapping("/newLevel")
	public ModelAndView newLevel() {
		ModelAndView mv = new ModelAndView("levelForm.jsp");
		Level_Information level = new Level_Information();
		mv.addObject("level", level);
		return mv;
	}

	// when you save new or update level student
	@RequestMapping("/saveLevel")
	public String saveLevel(@ModelAttribute("level") Level_Information level, BindingResult result,
			HttpServletRequest request) {
		Level_DAO levelServ = new Level_DAO();
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
		return "redirect:listLevel.do";
	}

	// when you update level
	@RequestMapping("/editLevel")
	public ModelAndView editLevel(HttpServletRequest request) {
		String key = request.getParameter("id");
		Level_Information foundLevel;
		ModelAndView mv = new ModelAndView("levelForm.jsp");
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
	@RequestMapping("/deleteLevel")
	public String deleteLevel(HttpServletRequest request) {
		Level_DAO levelServ = new Level_DAO();
		levelServ.deleteLevel(request.getParameter("id"));
		levelServ.closeEntityManager();
		return "redirect:listLevel.do";
	}
	
	@RequestMapping("/listLevelStu")
	public ModelAndView listLevelStu(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listLevelStu.jsp");
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
}
