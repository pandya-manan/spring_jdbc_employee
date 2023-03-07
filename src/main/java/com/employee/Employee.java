package com.employee;

public class Employee {
	
	private Integer employee_id;
	private String employee_name;
	private String employee_city;
	private Integer employee_salary;
	public Integer getEmployee_id() {
		return employee_id;
	}
	public void setEmployee_id(Integer employee_id) {
		this.employee_id = employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public String getEmployee_city() {
		return employee_city;
	}
	public void setEmployee_city(String employee_city) {
		this.employee_city = employee_city;
	}
	public Integer getEmployee_salary() {
		return employee_salary;
	}
	public void setEmployee_salary(Integer employee_salary) {
		this.employee_salary = employee_salary;
	}
	public Employee(Integer employee_id, String employee_name, String employee_city, Integer employee_salary) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.employee_city = employee_city;
		this.employee_salary = employee_salary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Employee [employee_id=" + employee_id + ", employee_name=" + employee_name + ", employee_city="
				+ employee_city + ", employee_salary=" + employee_salary + "]";
	}
	
	
	

}
