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

    public Contact(Integer idContact, Integer idDepartment, String rol, String name, String lastName, String company, Integer extension, Integer zoiper, String enrrollingDate, Integer status) {
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
    }

    public Integer getIdContact() {
        return this.idContact;
    }

    public void setIdContact(Integer idContact) {
        this.idContact = idContact;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIdDepartment() {
        return this.idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getRol() {
        return this.rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCompany() {
        return this.company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getExtension() {
        return this.extension;
    }

    public void setExtension(Integer extension) {
        this.extension = extension;
    }

    public Integer getZoiper() {
        return this.zoiper;
    }

    public void setZoiper(Integer zoiper) {
        this.zoiper = zoiper;
    }

    public String getEnrrollingDate() {
        return this.enrrollingDate;
    }

    public void setEnrrollingDate(String enrrollingDate) {
        this.enrrollingDate = enrrollingDate;
    }
}