package com.xdj.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xdj.model.Ticket;

@Controller
public class Four {

	@RequestMapping("/this4")
	public String mymain2(HttpSession session){
		return "showList";
	}
	
	@RequestMapping("/ajaxdemo4")
	public @ResponseBody List<Ticket> ajaxdemo4(){
		List<Ticket> list = new ArrayList<Ticket>();
			Ticket ticket = new Ticket();
			ticket.setDeparture_add("SUN");
			ticket.setDestination_add("LOA");
			ticket.setDeparture_time("1305");
			ticket.setArrival_time("1825");
			ticket.setPrice(67.8);
			ticket.setUname_code("C93832");
		list.add(ticket);
		Ticket ticket1 = new Ticket();
		ticket1.setDeparture_add("HDN");
		ticket1.setDestination_add("ALA");
		ticket1.setDeparture_time("0640");
		ticket1.setArrival_time("1135");
		ticket1.setPrice(127);
		ticket1.setUname_code("D85414");
		list.add(ticket1);
		Ticket ticket2 = new Ticket();
		ticket2.setDeparture_add("JFK");
		ticket2.setDestination_add("DAM");
		ticket2.setDeparture_time("0755");
		ticket2.setArrival_time("2235");
		ticket2.setPrice(458);
		ticket2.setUname_code("A58451");
		list.add(ticket2);
		return list;
	}
	
}
