package com.jlt.pojo;

public class EmployeeDetaills {
	private int employeeId;
	private String name;
	private double salary;
	private int password;
	public EmployeeDetaills(int employeeId, String name, double salary, int password) {
		super();
		this.employeeId = employeeId;
		this.name = name;
		this.salary = salary;
		this.password = password;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getPassword() {
		return password;
	}
	public void setPassword(int password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "EmployeeDetaills [employeeId=" + employeeId + ", name=" + name + ", salary=" + salary + ", password="
				+ password + ", toString()=" + super.toString() + "]";
	}
	   

}
