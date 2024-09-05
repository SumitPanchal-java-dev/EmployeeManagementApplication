package com.example.employee.entity;

import java.util.List;

import jakarta.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empid;
    private String empname;
    private String empcity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "spouse_id")
    private Spouse spouse;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> addresses;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
        name = "employee_project",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id")
    )
    private List<Project> projects;

    public Employee() {}

    public Employee(int empid, String empname, String empcity, Spouse spouse, List<Address> addresses) {
        this.empid = empid;
        this.empname = empname;
        this.empcity = empcity;
        this.spouse = spouse;
        this.addresses = addresses;
    }

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public String getEmpcity() {
		return empcity;
	}

	public void setEmpcity(String empcity) {
		this.empcity = empcity;
	}

	public Spouse getSpouse() {
		return spouse;
	}

	public void setSpouse(Spouse spouse) {
		this.spouse = spouse;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

    // Getters and Setters
    
    
}
