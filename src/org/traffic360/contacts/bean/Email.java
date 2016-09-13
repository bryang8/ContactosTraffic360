package org.traffic360.contacts.bean;

public class Email {
	private Integer idEmail;
	private String email;
	private Integer idContact;
	
	public Email(Integer idEmail, String email, Integer idContact) {
		super();
		this.idEmail = idEmail;
		this.email = email;
		this.idContact = idContact;
	}
	

	public Email() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getIdEmail() {
		return idEmail;
	}

	public void setIdEmail(Integer idEmail) {
		this.idEmail = idEmail;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getIdContact() {
		return idContact;
	}

	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}
	
	
	
	
}
