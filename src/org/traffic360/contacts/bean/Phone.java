package org.traffic360.contacts.bean;

public class Phone {
    private Integer idPhone;
    private Integer number;
    private Integer idContact;

    public Phone() {
    }

    public Phone(Integer idPhone, Integer number, Integer idContact) {
        this.idPhone = idPhone;
        this.number = number;
        this.idContact = idContact;
    }

    public Integer getIdPhone() {
        return this.idPhone;
    }

    public void setIdPhone(Integer idPhone) {
        this.idPhone = idPhone;
    }

    public Integer getNumber() {
        return this.number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getIdContact() {
        return this.idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }
}