package com.app.pojos;

import java.util.List;
import javax.persistence.*;

@Entity
@Table(name = "sunbeam_complaints")
public class Complaint {
	private Integer id;
	private String email, pass, os, browser, complaintDesc;
	private List<String> technologies;
	private String status;

	public Complaint() {
		System.out.println("in complaint constr");
	}

	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(length = 10, unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 10)
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Column(length = 10)
	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	@Column(length = 10)
	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	@Column(length = 300, name = "comp_desc")
	public String getComplaintDesc() {
		return complaintDesc;
	}

	public void setComplaintDesc(String complaintDesc) {
		this.complaintDesc = complaintDesc;
	}

	@Column(length = 10, name = "technos")
	// JPA annotation
	// To tell hib --whatever follws is a collectio of non-entities
	// i.e coll of value types & needs to be stored
	// in separate table

	@ElementCollection // mandatory
	
	@CollectionTable(name = "sunbeam_technos", 
	joinColumns = @JoinColumn(name = "complaint_id"))
	public List<String> getTechnologies() {
		return technologies;
	}

	public void setTechnologies(List<String> technologies) {
		this.technologies = technologies;
	}
	
	@Column(length=10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Complaint [id=" + id + ", email=" + email + ", pass=" + pass + ", os=" + os + ", browser=" + browser
				+ ", complaintDesc=" + complaintDesc + ", technologies=" + technologies + "]";
	}

}
