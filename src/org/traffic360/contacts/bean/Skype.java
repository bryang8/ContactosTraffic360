package org.traffic360.contacts.bean;

public class Skype {
    private Integer idSkype;
    private String skype;
    private Integer idContact;

    public Skype() {
    }

    public Skype(Integer idSkype, String skype, Integer idContact) {
        this.idSkype = idSkype;
        this.skype = skype;
        this.idContact = idContact;
    }

    public Integer getIdSkype() {
        return this.idSkype;
    }

    public void setIdSkype(Integer idSkype) {
        this.idSkype = idSkype;
    }

    public String getSkype() {
        return this.skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Integer getIdContact() {
        return this.idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }
}