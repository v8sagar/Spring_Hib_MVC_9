package com.app.pojos;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="sunbeam_custs")
public class Customer {
	private Integer id;
	private String name, email="some email", pass, role;
	private double regAmount;
	private Date regDate;

	public Customer() {
		System.out.println("in cust constr");
	}

	
	public Customer(String name, String email, String pass, String role, double regAmount, Date regDate) {
		super();
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}


	public Customer(Integer id, String name, String email, String pass, String role, double regAmount, Date regDate) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.role = role;
		this.regAmount = regAmount;
		this.regDate = regDate;
	}
	@Id
	@GeneratedValue
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@Column(length=10)
	public String getName() {
		return name;
	}

	public void setName(String name) {
	
		this.name = name;
	}
	@Column(length=10,unique=true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		System.out.println("in set email");
		this.email = email;
	}
	@Column(length=10)
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}
	@Column(length=10)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	@Column(name="reg_amt",columnDefinition="double(7,1)")
	public double getRegAmount() {
		return regAmount;
	}

	public void setRegAmount(double regAmount) {
		this.regAmount = regAmount;
	}
	@Column(name="reg_dt")
	@Temporal(TemporalType.DATE)
	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", role=" + role
				+ ", regAmount=" + regAmount + ", regDate=" + regDate + "]";
	}

}
