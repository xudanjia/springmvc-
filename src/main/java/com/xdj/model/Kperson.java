package com.xdj.model;

public class Kperson {

	private int id;
	
	private String name;
	
	private Kcard kcard;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Kcard getKcard() {
		return kcard;
	}

	public void setKcard(Kcard kcard) {
		this.kcard = kcard;
	}
	
}
