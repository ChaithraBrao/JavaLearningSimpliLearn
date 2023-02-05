package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ResponseBody
@Controller
public class UserController {
	
	
	@Autowired
	UserRepo repo;
	@Autowired
	UserDao dao;
	
	
	
	
	//this is for userlogin
		@RequestMapping("/userlogin")
		public ModelAndView User(HttpServletRequest req,HttpServletResponse res) {
			ModelAndView mv=new ModelAndView();
			String username=req.getParameter("username");
			String password=req.getParameter("password");
//			if(repo.findbyusername(username).equals(repo.findbypassword(password))) {			
//				HttpSession session=req.getSession();
//	     		session.setAttribute("username", username);
				mv.setViewName("home.jsp");
//			}else
//			{
//				mv.setViewName("failure.jsp");
//			}
			return mv;
			
		 
	}
	
		
		//this is for register
		@RequestMapping("/addregister")
		public String insert(HttpServletRequest request,HttpServletResponse response) {
			ModelAndView mv=new ModelAndView();
			User u=new User();
		u.setEmailid(request.getParameter("emailid"));
		u.setPassword(request.getParameter("password"));
		u.setUsername(request.getParameter("username"));
		u.setPlace(request.getParameter("place"));
		u.setUgender(request.getParameter("ugender"));
		u.setAge(Integer.parseInt(request.getParameter("age")));
		u.setMobno(Long.parseLong(request.getParameter("mobno")));
		u.setAddress(request.getParameter("address"));
		
		User uu=dao.insert(u);
		if(uu!=null) {
			mv.setViewName("register.jsp");
		}
		return "Data Registered Successfully";
		
		}
		
		@RequestMapping("/all")
		public ModelAndView getall(HttpServletRequest request,HttpServletResponse response) {
			ModelAndView mv=new ModelAndView();
			List<User> list=dao.getall();
			mv.setViewName("userinfo.jsp");
			mv.addObject("list",list);
			return mv;	
		 }

		@RequestMapping("/update")
		public String update(HttpServletRequest request,HttpServletResponse response) {
			ModelAndView mv=new ModelAndView();
			User u=new User();
	    u.setId(Integer.parseInt(request.getParameter("id")));
		u.setEmailid(request.getParameter("emailid"));
		u.setPassword(request.getParameter("password"));
		u.setUsername(request.getParameter("username"));
		u.setPlace(request.getParameter("place"));
		u.setUgender(request.getParameter("ugender"));
		u.setAge(Integer.parseInt(request.getParameter("age")));
		u.setMobno(Long.parseLong(request.getParameter("mobno")));
		u.setAddress(request.getParameter("address"));
		
		User uu=dao.insert(u);
		if(uu!=null) {
			mv.setViewName("complete.jsp");
		}
		return "updated successfully...";
		
		}
		
		@RequestMapping("/delete")
		  public String delete(HttpServletRequest request,HttpServletResponse response) {
			 int id= Integer.parseInt(request.getParameter("id"));
			  
			  dao.deleteByid(id);
			 
			 
			
			return "deleted successfully....check in the all the products";	  
		 }
			
			

}

