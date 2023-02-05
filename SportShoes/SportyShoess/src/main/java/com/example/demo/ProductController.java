package com.example.demo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@ResponseBody
@Controller
public class ProductController {
	
	@Autowired
	ProductDao dao;
	
	

	@RequestMapping("/addin")
	public String insert(HttpServletRequest request,HttpServletResponse response) {
	

		ModelAndView mv=new ModelAndView();
		Product p=new Product();
		
		p.setId(Integer.parseInt(request.getParameter("id")));
		p.setProductname(request.getParameter("productname"));
		p.setDescription(request.getParameter("description"));
		p.setCategory(request.getParameter("category"));
		p.setPrice(Integer.parseInt(request.getParameter("price")));
		p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		p.setSize(Integer.parseInt(request.getParameter("size")));
		
		
		Product pp=dao.insert(p);
		if(pp!=null)
		{
			mv.setViewName("add.jsp");
			
		}
		return "data inserted successfully";
	}
	
	@RequestMapping("/getall")
	public ModelAndView getall(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Product> list=dao.getall();
		mv.setViewName("displayproduct.jsp");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/uppro")
	public String update(HttpServletRequest request,HttpServletResponse response)
	{
		ModelAndView mv=new ModelAndView();
		Product p=new Product();
		
		p.setId(Integer.parseInt(request.getParameter("id")));
		p.setProductname(request.getParameter("productname"));
		p.setDescription(request.getParameter("description"));
		p.setCategory(request.getParameter("category"));
		p.setPrice(Integer.parseInt(request.getParameter("price")));
		p.setQuantity(Integer.parseInt(request.getParameter("quantity")));
		p.setSize(Integer.parseInt(request.getParameter("size")));
		
		
		Product pp=dao.insert(p);
		if(pp!=null) {
			mv.setViewName("success.jsp");
		}
		return "Product Updated Successfully";
	}
	
	@RequestMapping("/seeall")
	public ModelAndView displayall(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		List<Product> list=dao.getall();
		mv.setViewName("view.jsp");
		mv.addObject("list", list);
		return mv;
	}
	
	@RequestMapping("/dele")
    public String delete(HttpServletRequest request,HttpServletResponse response) {
		
		 int id= Integer.parseInt(request.getParameter("id"));
		  
		  dao.deleteByid(id);
		 
		 
		
		return "deleted successfully....check in the all the products";	
	}
	
}
