package com.xdj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdj.dao.TicketDaoImpl;
import com.xdj.model.Ticket;

@Service
public class TicketServiceImpl {

	@Autowired
	private TicketDaoImpl ticketDaoImpl;
	
	public List<Ticket> findAll(){
		return ticketDaoImpl.findAll();
	}
	
	public List<Ticket> getAll(){
		return ticketDaoImpl.getAll();
	}
	
	public Ticket getOne(int tid){
		return ticketDaoImpl.getOne(tid);
	}
	
	public List<Ticket> findTicketByUnameCode(String uname_code){
		return ticketDaoImpl.findTicketByUnameCode(uname_code);
	}
	
	public int insert(Ticket ticket){
		return ticketDaoImpl.insert(ticket);
	}
	
}
