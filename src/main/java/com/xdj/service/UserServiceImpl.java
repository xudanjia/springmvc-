package com.xdj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xdj.dao.UserDaoImpl;

@Service
public class UserServiceImpl {

	@Autowired
	private UserDaoImpl udi;
	
}
