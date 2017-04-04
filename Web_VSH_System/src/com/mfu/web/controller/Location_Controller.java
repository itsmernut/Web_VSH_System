package com.mfu.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mfu.dao.Location_DAO;
import com.mfu.entity.Location_Information;

@Controller
public class Location_Controller {

	@RequestMapping("/newLocation")
	public ModelAndView newLocation() {
		ModelAndView mv = new ModelAndView("locationForm.jsp");
		Location_Information location = new Location_Information();
		mv.addObject("location", location);
		return mv;
	}
	
	@RequestMapping("/saveLocation")
	public String saveLocation(@ModelAttribute("location") Location_Information location, BindingResult result,
			HttpServletRequest request) {
		Location_DAO locationServ = new Location_DAO();
		String studentKey = (String) request.getSession().getAttribute("studentKey");
		location.setStudentId(studentKey);
		try {
			if (location.getKey() == null) {
				locationServ.insertLocation(location);
			} else {
				locationServ.updateLocation(location);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		locationServ.closeEntityManager();
		return "redirect:listLocation.do?id=" + studentKey;
	}
	
	@RequestMapping("/editLocation")
	public ModelAndView editLocation(HttpServletRequest request) {
		String key = request.getParameter("id");
		Location_Information foundLocation;
		ModelAndView mv = new ModelAndView("locationForm.jsp");
		Location_DAO locationServ = new Location_DAO();
		try {
			foundLocation = locationServ.findLocationByKey(key);
			mv.addObject("location", foundLocation);
			mv.addObject("keyString", foundLocation.getKeyString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		locationServ.closeEntityManager();
		return mv;
	}
	
	@RequestMapping("/listLocation")
	public ModelAndView listLocation(HttpServletRequest request) {
		Location_DAO locationServ = new Location_DAO();
		String key = request.getParameter("id");
		request.getSession().setAttribute("studentKey", key);
		ModelAndView mv = new ModelAndView("listLocation.jsp");
		List<Location_Information> locationList;
		try {
			locationList = locationServ.getLocationByStudent(key);
			mv.addObject("locationList", locationList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		locationServ.closeEntityManager();
		return mv;
	}
	@RequestMapping("/listLocationStu")
	public ModelAndView listLocationStu(HttpServletRequest request) {
		Location_DAO locationServ = new Location_DAO();
		String key = request.getParameter("id");
		request.getSession().setAttribute("studentKey", key);
		ModelAndView mv = new ModelAndView("listLocationStu.jsp");
		List<Location_Information> locationList;
		try {
			locationList = locationServ.getLocationByStudent(key);
			mv.addObject("locationList", locationList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		locationServ.closeEntityManager();
		return mv;
	}
	
	@RequestMapping("/viewLocation")
	public ModelAndView viewLocation(HttpServletRequest request) {
		Location_DAO locationServ = new Location_DAO();
		String key = request.getParameter("id");
		request.getSession().setAttribute("studentKey", key);
		ModelAndView mv = new ModelAndView("viewLocation.jsp");
		List<Location_Information> locationList;
		try {
			locationList = locationServ.getLocationByStudent(key);
			mv.addObject("locationList", locationList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		locationServ.closeEntityManager();
		return mv;
	}
}
