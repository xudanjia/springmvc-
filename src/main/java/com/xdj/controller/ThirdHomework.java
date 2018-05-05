package com.xdj.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.xdj.model.User;

@Controller
public class ThirdHomework {

	@RequestMapping("/this")
	public String mymain(HttpSession session){
		return "firstpage";
	}
	
	@RequestMapping("/this2")
	public String mydemo(@SessionAttribute("uname") String uname){
		System.out.println(uname);
		return "firstpage";
	}
	
	@RequestMapping("/ajaxdemo")
	public @ResponseBody User ajaxdemo(@RequestBody User u){
		System.out.println("id"+u.getUname()+"ppp");
		System.out.println("id"+u.getPassword()+"aaa");
		return u;
	}
	
	@RequestMapping("/ajaxdemo2")
	public @ResponseBody String ajaxdemo2(String myname){
		System.out.println(myname);
		return "验证用户~";
	}
	
}
