package org.traffic360.contacts.bean;

public class Email {
    private Integer idEmail;
    private String email;
    private Integer idContact;

    public Email(Integer idEmail, String email, Integer idContact) {
        this.idEmail = idEmail;
        this.email = email;
        this.idContact = idContact;
    }

    public Email() {
    }

    public Integer getIdEmail() {
        return this.idEmail;
    }

    public void setIdEmail(Integer idEmail) {
        this.idEmail = idEmail;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdContact() {
        return this.idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }
}