package com.xdj.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import com.xdj.model.Kuser;
import com.xdj.utils.DbUtils;
@Service
public class UserDaoImpl {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoImpl(){
		this.sqlSessionFactory = DbUtils.getSession();
	}
	
	public List<Kuser> getAll(){
		SqlSession session = sqlSessionFactory.openSession();
		List<Kuser> lk = session.selectList("selectAllUser");
		// 该 “selectAllUser”与配置文件中的一个id相匹配。
		session.commit();
		session.close();
		return lk;
	}

} 