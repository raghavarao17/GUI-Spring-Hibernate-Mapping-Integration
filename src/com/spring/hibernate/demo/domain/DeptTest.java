package com.spring.hibernate.demo.domain;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "T_DEPT")
public class DeptTest {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "dept_id", unique = true, nullable = false)
	private int deptId;

	@Column(name = "deptname")
	private String deptName;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "deptTest")
	private Set<UserTest> userTestset;

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Set<UserTest> getUserTestset() {
		return userTestset;
	}

	public void setUserTestset(Set<UserTest> userTestset) {
		this.userTestset = userTestset;
	}
}
