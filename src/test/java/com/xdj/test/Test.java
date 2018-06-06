package com.xdj.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.xdj.dao.OrdersDao;
import com.xdj.dao.PersonDao;
import com.xdj.model.Kperson;
import com.xdj.model.Orders;
import com.xdj.utils.DbUtils;

public class Test {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public Test(){
		this.sqlSessionFactory = DbUtils.getSession();
	}
	
	@org.junit.Test
	public void test() {
		
		SqlSession session = sqlSessionFactory.openSession();
		PersonDao pd = session.getMapper(PersonDao.class);
		Kperson p = pd.findPersonById(1);
		System.out.println(p.getName());
		
	}
	
	@org.junit.Test
	public void test2() {
		
		SqlSession session = sqlSessionFactory.openSession();
		OrdersDao ordersdao = session.getMapper(OrdersDao.class);
		List<Orders> l = ordersdao.findOrdersUser("fdsa");
		for(Orders o : l){
			System.out.println(o.getOname());
		}
		
	}
	
}
