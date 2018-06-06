package com.xdj.dao;

import java.util.List;

import com.xdj.model.Orders;

public interface OrdersDao {

	public List<Orders> findOrdersUser(String uname);
	
}
