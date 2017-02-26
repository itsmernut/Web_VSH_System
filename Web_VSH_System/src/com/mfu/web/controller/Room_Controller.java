package com.mfu.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mfu.dao.Room_DAO;
import com.mfu.entity.Room_Information;

@Controller
public class Room_Controller {

	@RequestMapping("/listRoom")
	public ModelAndView listRoom(HttpServletRequest request) {
		ModelAndView mv = new ModelAndView("listRoom.jsp");
		List<Room_Information> roomList;
		Room_DAO roomServ = new Room_DAO();
		try {
			roomList = roomServ.getAllRooms();
			mv.addObject("roomList", roomList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomServ.closeEntityManager();
		return mv;
	}
	//when you add new room student
	@RequestMapping("/newRoomStudent")
	public ModelAndView newRoomStudent() {
		ModelAndView mv = new ModelAndView("roomFormStudent.jsp");
		Room_Information room = new Room_Information();
		mv.addObject("room", room);
		return mv;
	}
	
	//when you add new room teacher
		@RequestMapping("/newRoomTeacher")
		public ModelAndView newRoom() {
			ModelAndView mv = new ModelAndView("roomFormTeacher.jsp");
			Room_Information room = new Room_Information();
			mv.addObject("room", room);
			return mv;
		}
		
	//when you save new or update room student
	@RequestMapping("/saveRoomStudent")
	public String saveRoomStudent(@ModelAttribute("room") Room_Information room, BindingResult result,
			HttpServletRequest request) {
		Room_DAO roomServ = new Room_DAO();
		String levelKey = (String) request.getSession().getAttribute("levelKey");
		room.setLevelId(levelKey);
		try {
			if (room.getKey() == null) {
				roomServ.insertRoom(room);
			} else {
				roomServ.updateRoom(room);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomServ.closeEntityManager();
		return "redirect:getRoombyLevelStudent.do?id="+levelKey;
	}
	
	//when you save new or update room Teacher
		@RequestMapping("/saveRoomTeacher")
		public String saveRoomTeacher(@ModelAttribute("room") Room_Information room, BindingResult result,
				HttpServletRequest request) {
			Room_DAO roomServ = new Room_DAO();
			String levelKey = (String) request.getSession().getAttribute("levelKey");
			room.setLevelId(levelKey);
			try {
				if (room.getKey() == null) {
					roomServ.insertRoom(room);
				} else {
					roomServ.updateRoom(room);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			roomServ.closeEntityManager();
			return "redirect:getRoombyLevelTeacher.do?id="+levelKey;
		}
	
	//when you update room student
	@RequestMapping("/editRoomStudent")
	public ModelAndView editRoomStudent(HttpServletRequest request) {
		String key = request.getParameter("id");
		Room_Information foundRoom;
		ModelAndView mv = new ModelAndView("roomFormStudent.jsp");
		Room_DAO roomServ = new Room_DAO();
		try {
			foundRoom = roomServ.findRoomByKey(key);
			mv.addObject("room", foundRoom);
			mv.addObject("keyString", foundRoom.getKeyString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomServ.closeEntityManager();
		return mv;
	}
	
	//when you update room Teacher
		@RequestMapping("/editRoomTeacher")
		public ModelAndView editRoomTeacher(HttpServletRequest request) {
			String key = request.getParameter("id");
			Room_Information foundRoom;
			ModelAndView mv = new ModelAndView("roomFormTeacher.jsp");
			Room_DAO roomServ = new Room_DAO();
			try {
				foundRoom = roomServ.findRoomByKey(key);
				mv.addObject("room", foundRoom);
				mv.addObject("keyString", foundRoom.getKeyString());
			} catch (Exception e) {
				e.printStackTrace();
			}
			roomServ.closeEntityManager();
			return mv;
		}
	
	//delete Room by student
	@RequestMapping("/deleteRoomStudent")
	public String deleteRoomStudent(HttpServletRequest request) {
		String levelKey = (String) request.getSession().getAttribute("levelKey");
		Room_DAO roomServ = new Room_DAO();
		roomServ.deleteRoom(request.getParameter("id"));
		roomServ.closeEntityManager();
		return "redirect:getRoombyLevelStudent.do?id="+levelKey;
	}
	
	//delete Room by teacher
	@RequestMapping("/deleteRoomTeacher")
	public String deleteRoomTeacher(HttpServletRequest request) {
		String levelKey = (String) request.getSession().getAttribute("levelKey");
		Room_DAO roomServ = new Room_DAO();
		roomServ.deleteRoom(request.getParameter("id"));
		roomServ.closeEntityManager();
		return "redirect:getRoombyLevelTeacher.do?id="+levelKey;
	}
	
	//when you view room in level student  (getkey level to see room)
	@RequestMapping("/getRoombyLevelStudent")
	public ModelAndView getRoombyLevelStudent(HttpServletRequest request) {
		Room_DAO roomServ = new Room_DAO();
		String key = request.getParameter("id");
		request.getSession().setAttribute("levelKey", key);
		ModelAndView mv = new ModelAndView("getRoombyLevelStudent.jsp");
		List<Room_Information> roomList;
		try {
			roomList = roomServ.getRoomByLevel(key);
			mv.addObject("roomList", roomList);
		} catch (Exception e) {
			e.printStackTrace();
		}
		roomServ.closeEntityManager();
		return mv;
	}
	
	//when you view room in level teacher  (getkey level to see room)
		@RequestMapping("/getRoombyLevelTeacher")
		public ModelAndView getRoombyLevelTeacher(HttpServletRequest request) {
			Room_DAO roomServ = new Room_DAO();
			String key = request.getParameter("id");
			request.getSession().setAttribute("levelKey", key);
			ModelAndView mv = new ModelAndView("getRoombyLevelTeacher.jsp");
			List<Room_Information> roomList;
			try {
				roomList = roomServ.getRoomByLevel(key);
				mv.addObject("roomList", roomList);
			} catch (Exception e) {
				e.printStackTrace();
			}
			roomServ.closeEntityManager();
			return mv;
		}
}
