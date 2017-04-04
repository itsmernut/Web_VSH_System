package com.mfu.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mfu.dao.Location_DAO;
import com.mfu.dao.Parent_DAO;
import com.mfu.entity.Location_Information;
import com.mfu.entity.Parent_Information;

@Controller
public class Parent_Controller {

	@RequestMapping("/newParent")
	public ModelAndView newParent() {
		ModelAndView mv = new ModelAndView("parentForm.jsp");
		Parent_Information parent = new Parent_Information();
		mv.addObject("parent", parent);
		return mv;
	}
	
	@RequestMapping("/saveParent")
	public String saveParent(@ModelAttribute("parent") Parent_Information parent, BindingResult result,
			HttpServletRequest request) {
		Parent_DAO parentServ = new Parent_DAO();
		String studentKey = (String) request.getSession().getAttribute("studentKey");
		parent.setStudentId(studentKey);
		try {
			if (parent.getKey() == null) {
				parentServ.insertParent(parent);
			} else {
				parentServ.updateParent(parent);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		parentServ.closeEntityManager();
		return "redirect:listParent.do?id=" + studentKey;
	}
	
	@RequestMapping("/editParent")
	public ModelAndView editParent(HttpServletRequest request) {
		String key = request.getParameter("id");
		Parent_Information foundParent;
		ModelAndView mv = new ModelAndView("parentForm.jsp");
		Parent_DAO parentServ = new Parent_DAO();
		try {
			foundParent = parentServ.findParentByKey(key);
			mv.addObject("parent", foundParent);
			mv.addObject("keyString", foundParent.getKeyString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		parentServ.closeEntityManager();
		return mv;
	}
	
	@RequestMapping("/listParent")
	public ModelAndView listParent(HttpServletRequest request) {
		Parent_DAO parentServ = new Parent_DAO();
		String key = request.getParameter("id");
		request.getSession().setAttribute("parentKey", key);
		ModelAndView mv = new ModelAndView("listParent.jsp");
		List<Parent_Information> parentList;
		try {
			parentList = parentServ.getParentByStudent(key);
			mv.addObject("parentList", parentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		parentServ.closeEntityManager();
		return mv;
	}
	
	@RequestMapping("/listParentStu")
	public ModelAndView listParentStu(HttpServletRequest request) {
		Parent_DAO parentServ = new Parent_DAO();
		String key = request.getParameter("id");
		ModelAndView mv = new ModelAndView("listParentStu.jsp");
		List<Parent_Information> parentList;
		try {
			parentList = parentServ.getParentByStudent(key);
			mv.addObject("parentList", parentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		parentServ.closeEntityManager();
		return mv;
	}
	
	@RequestMapping("/viewParent")
	public ModelAndView viewParent(HttpServletRequest request) {
		Parent_DAO parentServ = new Parent_DAO();
		String key = request.getParameter("id");
		ModelAndView mv = new ModelAndView("viewParent.jsp");
		List<Parent_Information> parentList;
		try {
			parentList = parentServ.getParentByStudent(key);
			mv.addObject("parentList", parentList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		parentServ.closeEntityManager();
		return mv;
	}
}
