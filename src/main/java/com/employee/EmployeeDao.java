package com.employee;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class EmployeeDao {
	
	
	
	private JdbcTemplate jdbcTemplate;  
	  
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {  
	    this.jdbcTemplate = jdbcTemplate;  
	}  
	
	public int insertData(String employeeName, String employeeCity, Integer employeeSalary)
	{
				//1.Insert Query
				String query="insert into employee (employee_name,employee_city,employee_salary) values (?,?,?)";
				
				//2. Execute the insert query 
				int result=jdbcTemplate.update(query,employeeName,employeeCity,employeeSalary); // takes varargs
				
				//3.Display the result of the insert query
				System.out.println("Rows affected after insertion: "+result);
				return result;
	}
	
	public int updateEmployee(Integer employeeId, String employeeName, String employeeCity, Integer employeeSalary)
	{
		//1.Update Query
		String query="update employee set employee_name=?, employee_city=?, employee_salary=? where employee_id=?";
		//2.Execute the update query
		int result=jdbcTemplate.update(query,employeeName,employeeCity,employeeSalary,employeeId);
		//3.Display the result of the update query
		System.out.println("Rows affected after executing update "+result);
		return result;
		
	}
	
	public int deleteEmployee(Integer employeeId)
	{
		//1.Delete Query
		String query="delete from employee where employee_id=?";
		//2.Execute the delete query
		int result=jdbcTemplate.update(query,employeeId);
		//3.Display the result of the delete query
		System.out.println("Rows affected after deletion: "+result);
		return result;
	}
	
	public Employee getEmployeeByEmployeeId(Integer employeeId)
	{
		String query="select * from employee where employee_id=?";
		RowMapper<Employee> rowMapperImpl=new RowMapperEmployeeImpl();
		
		Employee employee=jdbcTemplate.queryForObject(query, rowMapperImpl,employeeId);
		return employee;
	}
	
	public List<Employee> findEmployees()
	{
		String query="select * from employee";
		List<Employee> employees=jdbcTemplate.query(query, new RowMapperEmployeeImpl());
		return employees;
		
	}

}
