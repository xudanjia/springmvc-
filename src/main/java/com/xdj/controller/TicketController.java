package com.xdj.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xdj.model.Ticket;
import com.xdj.model.Users;
import com.xdj.service.TicketServiceImpl;

@Controller
public class TicketController {

	@Autowired
	private TicketServiceImpl ticketServiceImpl;
	
	@RequestMapping("/findAll")
	public ModelAndView findAll(){
		
		ApplicationContext context=new ClassPathXmlApplicationContext("../springmvc.xml");
		@SuppressWarnings("unchecked")
		RedisTemplate<String,List<Ticket>> redisTemplate= context.getBean(RedisTemplate.class);
		
		List<Ticket> list = ticketServiceImpl.findAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/NewFile");
		mv.addObject("tickets",list);

		redisTemplate.opsForValue().set("u", list);
		List<Ticket> al = (List<Ticket>)redisTemplate.opsForValue().get("u");
		System.out.println(al);
		
		return mv;
	}
	
	@RequestMapping("/getAll")
	public ModelAndView getAll(){
		
		ApplicationContext context=new ClassPathXmlApplicationContext("../springmvc.xml");
		@SuppressWarnings("unchecked")
		RedisTemplate<String,List<Ticket>> redisTemplate= context.getBean(RedisTemplate.class);
		
		List<Ticket> list = ticketServiceImpl.getAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/NewFile");
		mv.addObject("tickets",list);

		redisTemplate.opsForValue().set("u", list);
		List<Ticket> al = (List<Ticket>)redisTemplate.opsForValue().get("u");
		System.out.println(al);
		
		return mv;
	}
	
	@RequestMapping("/find")
	public ModelAndView find(){
		List<Ticket> list = ticketServiceImpl.getAll();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/NewFile");
		mv.addObject("tickets",list);
		return mv;
	}
	
	@RequestMapping("/findTicketByUnameCode")
	public ModelAndView findTicketByUnameCode(
			@RequestParam(value="uname_code") String uname_code
			){
		List<Ticket> list = ticketServiceImpl.getAll();
		List<Ticket> ticket = ticketServiceImpl.findTicketByUnameCode(uname_code);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/NewFile");
		mv.addObject("ticketCondition",ticket);
		mv.addObject("tickets",list);
		return mv;
	}
	
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insert(
			@RequestParam(value="tid") String tids,
			@RequestParam(value="departure_add") String departure_add,
			@RequestParam(value="destination_add") String destination_add,
			@RequestParam(value="departure_time") String departure_time,
			@RequestParam(value="arrival_time") String arrival_time,
			@RequestParam(value="price") String prices,
			@RequestParam(value="uname_code") String uname_code
			){
		int tid;
		try {
			tid = Integer.parseInt(tids);
			Ticket one = ticketServiceImpl.getOne(tid);
			if(one != null){
				List<Ticket> list = ticketServiceImpl.getAll();
				ModelAndView mv = new ModelAndView();
				mv.setViewName("/NewFile");
				mv.addObject("msg","亲，该id已经存在！");
				mv.addObject("tickets",list);
				return mv;
			}
		} catch (Exception e) {
			List<Ticket> list = ticketServiceImpl.getAll();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/NewFile");
			mv.addObject("msg","tid必须填数字哦！");
			mv.addObject("tickets",list);
			return mv;
		}
		double price;
		try {
			price = Double.parseDouble(prices);
		} catch (Exception e) {
			List<Ticket> list = ticketServiceImpl.getAll();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/NewFile");
			mv.addObject("msg","price必须填数字哦！");
			mv.addObject("tickets",list);
			return mv;
		}
		if(departure_add.equals("") || destination_add.equals("") || departure_time.equals("") || arrival_time.equals("") || uname_code.equals("")){
			List<Ticket> list = ticketServiceImpl.getAll();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/NewFile");
			mv.addObject("msg","亲，没填完呢！");
			mv.addObject("tickets",list);
			return mv;
		}
		Ticket ticket = new Ticket();
		ticket.setTid((int)tid);
		ticket.setDeparture_add(departure_add);
		ticket.setDestination_add(destination_add);
		ticket.setDeparture_time(departure_time);
		ticket.setArrival_time(arrival_time);
		ticket.setPrice((double)price);
		ticket.setUname_code(uname_code);
		int res = ticketServiceImpl.insert(ticket);
		if(res>0){
			List<Ticket> list = ticketServiceImpl.getAll();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/NewFile");
			mv.addObject("tickets",list);
			return mv;
		}else{
			List<Ticket> list = ticketServiceImpl.getAll();
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/NewFile");
			mv.addObject("msg","插入错误！");
			mv.addObject("tickets",list);
			return mv;
		}
		
	}
	
}
