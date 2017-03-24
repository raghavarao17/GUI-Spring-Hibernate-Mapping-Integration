package com.spring.hibernate.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "T_EMPLOYEE")
public class UserTest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "t_employee_seq")
	@SequenceGenerator(name = "t_employee_seq", sequenceName = "t_employee_seq")
	@Column(name = "employee_id")
	private int employeeId;

	@Column(name = "firstname")
	private String firstName;

	@Column(name = "lastname")
	private String lastName;
     
	@Transient
	private String address;

	@Column(name = "city")
	private String City;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "dept_id", nullable = false)
	private DeptTest deptTest;


	public int getEmployeeId() {
		return employeeId;
	}

	public DeptTest getDeptTest() {
		return deptTest;
	}

	public void setDeptTest(DeptTest deptTest) {
		this.deptTest = deptTest;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

}
