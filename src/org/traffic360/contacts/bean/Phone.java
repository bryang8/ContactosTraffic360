package org.traffic360.contacts.bean;

public class Phone {
	private Integer idPhone;
	private Integer number;
	private Integer idContact;
	
	public Phone() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Phone(Integer idPhone, Integer number, Integer idContact) {
		super();
		this.idPhone = idPhone;
		this.number = number;
		this.idContact = idContact;
	}
	
	public Integer getIdPhone() {
		return idPhone;
	}
	public void setIdPhone(Integer idPhone) {
		this.idPhone = idPhone;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public Integer getIdContact() {
		return idContact;
	}
	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}
	
	
	

	
	
	
}
