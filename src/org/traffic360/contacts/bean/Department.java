package org.traffic360.contacts.bean;

public class Department {

	private Integer idDepartment;
	private String name;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Department(Integer idDepartment, String name) {
		super();
		this.idDepartment = idDepartment;
		this.name = name;
	}
	
	public Integer getIdDepartment() {
		return idDepartment;
	}
	public void setIdDepartment(Integer idDepartment) {
		this.idDepartment = idDepartment;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
