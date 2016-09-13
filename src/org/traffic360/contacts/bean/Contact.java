package org.traffic360.contacts.bean;

public class Contact {
	private Integer idContact;
	private Integer idDepartment; 
	private String rol;
	private String name;
	private String lastName;
	private String company;
	private Integer extension;
	private Integer zoiper;
	private String enrrollingDate;
	private Integer status;
	
	public Contact(Integer idContact, Integer idDepartment, String rol, String name, String lastName, String company,
			Integer extension, Integer zoiper, String enrrollingDate, Integer status) {
		super();
		this.idContact = idContact;
		this.idDepartment = idDepartment;
		this.rol = rol;
		this.name = name;
		this.lastName = lastName;
		this.company = company;
		this.extension = extension;
		this.zoiper = zoiper;
		this.enrrollingDate = enrrollingDate;
		this.status = status;
	}
	
	
	public Contact() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Integer getIdContact() {
		return idContact;
	}



	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}
	
	public Integer getStatus() {
		return status;
	}


	public void setStatus(Integer status) {
		this.status = status;
	}


	public Integer getIdDepartment() {
		return idDepartment;
	}



	public void setIdDepartment(Integer idDepartment) {
		this.idDepartment = idDepartment;
	}



	public String getRol() {
		return rol;
	}



	public void setRol(String rol) {
		this.rol = rol;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getCompany() {
		return company;
	}



	public void setCompany(String company) {
		this.company = company;
	}



	public Integer getExtension() {
		return extension;
	}



	public void setExtension(Integer extension) {
		this.extension = extension;
	}



	public Integer getZoiper() {
		return zoiper;
	}



	public void setZoiper(Integer zoiper) {
		this.zoiper = zoiper;
	}



	public String getEnrrollingDate() {
		return enrrollingDate;
	}



	public void setEnrrollingDate(String enrrollingDate) {
		this.enrrollingDate = enrrollingDate;
	}
}
