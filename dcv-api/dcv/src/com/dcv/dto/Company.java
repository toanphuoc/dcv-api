package com.dcv.dto;

public class Company {

	private int id;
	private String name;
	private String address;
	private String telephone;
	private String fax;
	private String email;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getFax() {
		return fax;
	}
	public void setFax(String fax) {
		this.fax = fax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Company(String name, String address, String tel, String fax, String email){
		this.name = name;
		this.address = address;
		this.telephone = tel;
		this.fax = fax;
		this.email = email;
	}
	public Company() {
	}
		
}
