package org.traffic360.contacts.bean;

public class Department {
    private Integer idDepartment;
    private String name;

    public Department() {
    }

    public Department(Integer idDepartment, String name) {
        this.idDepartment = idDepartment;
        this.name = name;
    }

    public Integer getIdDepartment() {
        return this.idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}