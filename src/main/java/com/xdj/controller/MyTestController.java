package com.xdj.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xdj.model.Order;
import com.xdj.model.User;

@Controller
public class MyTestController {

	@RequestMapping("/demo")
	public String mytest(HttpServletRequest req) {
		String id = req.getParameter("myname");
		System.out.println(id);
		return "new";
	}
	
	@RequestMapping("/demo2")
	public String mytest(int id) {
		System.out.println("id:"+id);
		return "new";
	}

	@RequestMapping("/demo3")
	public String mytest(@RequestParam(value="myname") String name) {
		System.out.println("id:"+name);
		return "new";
	}
	
	@RequestMapping("/demo4/{id}")
	public String mytest1(@PathVariable int id) {
		System.out.println("id:"+id);
		return "new";
	}
	
	@RequestMapping("/pojo")
	public String mypojo(Order order) {
		System.out.println("oaddress:"+order.getOaddress());
		System.out.println("odate:"+order.getOdate());
		return "new";
	}
	
	@RequestMapping("/pojo2")
	public String mypojo2(Order order) {
		User u = order.getUser();
		System.out.println("oaddress:"+order.getOaddress());
		System.out.println("uname:"+u.getUname());
		return "new";
	}
	
}
