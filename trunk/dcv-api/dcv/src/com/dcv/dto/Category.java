package com.dcv.dto;

public class Category {

	private int id;
	private String name;
	private Trademark trademark;
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
	public Trademark getTrademark() {
		return trademark;
	}
	public void setTrademark(Trademark trademark) {
		this.trademark = trademark;
	}
}
