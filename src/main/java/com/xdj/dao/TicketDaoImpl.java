package com.xdj.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.xdj.model.Kuser;
import com.xdj.model.Ticket;
import com.xdj.utils.DbUtils;

@Service
public class TicketDaoImpl {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public TicketDaoImpl(){
		this.sqlSessionFactory = DbUtils.getSession();
	}
	
	public List<Ticket> getAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<Ticket> lk = session.selectList("selectAllTicket");
		session.commit();
		session.close();
		return lk;
	}
	
	public Ticket getOne(int tid){
		SqlSession session = sqlSessionFactory.openSession();
		Ticket lk = session.selectOne("selectTicket",tid);
		session.commit();
		session.close();
		return lk;
	}
	
	public List<Ticket> findTicketByUnameCode(String uname_code){
		SqlSession session = sqlSessionFactory.openSession();
		List<Ticket> ticket = session.selectList("selectTicketByUnameCode",uname_code);
		session.commit();
		session.close();
		return ticket;
	}
	
	public int insert(Ticket ticket){
		SqlSession session = sqlSessionFactory.openSession();
		int res = session.insert("insertTicket",ticket);
		session.commit();
		session.close();
		return res;
	}

	public List<Ticket> findAll(){
		List<Ticket> list = new ArrayList<Ticket>();
		Ticket ticket = new Ticket();
		ticket.setTid(121);
		ticket.setDeparture_add("SUN");
		ticket.setDestination_add("LOA");
		ticket.setDeparture_time("1305");
		ticket.setArrival_time("1825");
		ticket.setPrice(67.8);
		ticket.setUname_code("C93832");
		list.add(ticket);
		Ticket ticket1 = new Ticket();
		ticket1.setTid(122);
		ticket1.setDeparture_add("HDN");
		ticket1.setDestination_add("ALA");
		ticket1.setDeparture_time("0640");
		ticket1.setArrival_time("1135");
		ticket1.setPrice(127);
		ticket1.setUname_code("D85414");
		list.add(ticket1);
		Ticket ticket2 = new Ticket();
		ticket2.setTid(123);
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
