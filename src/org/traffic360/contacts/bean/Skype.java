package org.traffic360.contacts.bean;

public class Skype {
	private Integer idSkype;
	private String skype;
	private Integer idContact;
	
	public Skype() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Skype(Integer idSkype, String skype, Integer idContact) {
		super();
		this.idSkype = idSkype;
		this.skype = skype;
		this.idContact = idContact;
	}

	public Integer getIdSkype() {
		return idSkype;
	}

	public void setIdSkype(Integer idSkype) {
		this.idSkype = idSkype;
	}

	public String getSkype() {
		return skype;
	}

	public void setSkype(String skype) {
		this.skype = skype;
	}

	public Integer getIdContact() {
		return idContact;
	}

	public void setIdContact(Integer idContact) {
		this.idContact = idContact;
	}
	
	
}
