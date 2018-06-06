package com.xdj.model;

import java.io.Serializable;

public class Users implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String uid;
	
	private String uname;
	
	private String upassword;
	
	private String uaddr;
	
	private Integer urank;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpassword() {
		return upassword;
	}

	public void setUpassword(String upassword) {
		this.upassword = upassword;
	}

	public String getUaddr() {
		return uaddr;
	}

	public void setUaddr(String uaddr) {
		this.uaddr = uaddr;
	}

	public Integer getUrank() {
		return urank;
	}

	public void setUrank(Integer urank) {
		this.urank = urank;
	}

	public Users(String uname, String upassword) {
		super();
		this.uname = uname;
		this.upassword = upassword;
	}
	
}
