package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
	private int empId;
	private String empName;
	private int leavesAvailable;
	private int leavesTaken;
	private int leavesRemaining;
	private String empType;
	private boolean loggedIn;
	
	public String getEmpType() {
		return empType;
	}
	public void setEmpType(String empType) {
		this.empType = empType;
	}
	public boolean isLoggedIn() {
		return loggedIn;
	}
	public void setLoggedIn(boolean loggedIn) {
		this.loggedIn = loggedIn;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getLeavesAvailable() {
		return leavesAvailable;
	}
	public void setLeavesAvailable(int leavesAvailable) {
		this.leavesAvailable = leavesAvailable;
	}
	public int getLeavesTaken() {
		return leavesTaken;
	}
	public void setLeavesTaken(int leavesTaken) {
		this.leavesTaken = leavesTaken;
	}
	public int getLeavesRemaining() {
		return leavesRemaining;
	}
	public void setLeavesRemaining(int leavesRemaining) {
		this.leavesRemaining = leavesRemaining;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", leavesAvailable=" + leavesAvailable
				+ ", leavesTaken=" + leavesTaken + ", leavesRemaining=" + leavesRemaining + "]";
	}
	
}
