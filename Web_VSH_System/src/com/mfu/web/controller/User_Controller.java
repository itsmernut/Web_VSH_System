package com.mfu.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mfu.dao.User_DAO;
import com.mfu.entity.User_Information;

@Controller
public class User_Controller {

	@RequestMapping("/listUser")
	public ModelAndView listUser(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listUser.jsp");
		List<User_Information> userList;
		User_DAO userServ = new User_DAO();
		try {
			userList = userServ.getAllUsers();
			mv.addObject("userList", userList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		userServ.closeEntityManager();
		return mv;
	}
	
	@RequestMapping("/newUser")
	public ModelAndView newUser() {
		ModelAndView mv = new ModelAndView("UserForm.jsp");
		User_Information user = new User_Information();
		mv.addObject("user", user);
		return mv;
	}
	
	@RequestMapping("/saveUser")
	public String saveUser(@ModelAttribute("user") User_Information user, BindingResult result,
			HttpServletRequest request) {
		User_DAO userServ = new User_DAO();
		String keyString = request.getParameter("keyString");
		try {
			if (user.getKey() == null) {
				userServ.insertUser(user);
			} else {
				userServ.updateUser(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userServ.closeEntityManager();
		return "redirect:listUser.do";
	}
	
	@RequestMapping("/editUser")
	public ModelAndView editUser(HttpServletRequest request) {
		User_DAO userServ = new User_DAO();
		String key = request.getParameter("id");
		User_Information foundUser;
		ModelAndView mv = new ModelAndView("userForm.jsp");
		try {
			foundUser = userServ.findUserByKey(key);		
			mv.addObject("user", foundUser);
			mv.addObject("keyString",foundUser.getKeyString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		userServ.closeEntityManager();			
		return mv;
	}
	
	@RequestMapping("/deleteUser")
	public String deleteUser(HttpServletRequest request) {
		User_DAO userServ = new User_DAO();
		userServ.deleteUser(request.getParameter("id"));
		userServ.closeEntityManager();
		return "redirect:listUser.do";
	}
}
