package com.xdj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.xdj.model.Users;

@Controller
public class RedisHomeWork {
	
//	@Resource
//    private RedisTemplate<String, List<Users>> redisTemplate;

	@RequestMapping("/testRedis")
	public String mytest(HttpServletRequest req) {
		ApplicationContext context=new ClassPathXmlApplicationContext("../springmvc.xml");
		@SuppressWarnings("unchecked")
		RedisTemplate<String,List<Users>> redisTemplate= context.getBean(RedisTemplate.class);
		Users u1 = new Users("222","3333");
		Users u2 = new Users("111","11111");
		List<Users> list = new ArrayList<Users>();
		list.add(u1);
		list.add(u2);
		redisTemplate.opsForValue().set("u", list);
		
		List<Users> al = (List<Users>)redisTemplate.opsForValue().get("u");
		System.out.println(al);
		return "new";
	}
	
}
