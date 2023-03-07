package com.employee;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeDriver {

	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("beans.xml");  
		
		EmployeeDao dao=(EmployeeDao)ctx.getBean("edao");
					
		while(true)
		{
			Scanner sc=new Scanner(System.in);
			System.out.println("WELCOME TO EMPLOYEE MANAGEMENT SYSTEM");
			System.out.println("1.Insert new employee");
			System.out.println("2.Update the employee data");
			System.out.println("3.Delete the employee based on employeeId");
			
			System.out.println("4.Get the employee by employeeId");
			System.out.println("5.Get all the employees");
			System.out.println("6.Exit the program");
			Integer choice=sc.nextInt();
			switch(choice)
			{
			case (1):System.out.println("Please enter the employee name separted by underscore for multiple words: ");
					 String employeeNameInut=sc.next();
					 String[] splitWords=employeeNameInut.split("_");
					 String employeeName="";
					 for(String s:splitWords)
					 {
						 employeeName=employeeName+s+" ";
					 }
					 System.out.println("Please enter the city: ");
					 String employeeCity=sc.next();
					 System.out.println("Enter the employee Salary: ");
					 Integer salary=sc.nextInt();
					 int status=dao.insertData(employeeName, employeeCity, salary);
					 System.out.println("Result after calling the insertion query: "+status);
					 break;
			case(2):System.out.println("Please give the employeeId whose data needs to be updated:");
					Integer employeeIdToUpdate=sc.nextInt();
					System.out.println("Please enter the employee name separted by underscore for multiple words: ");
					String employeeNameToUpdate=sc.next();
					String[] splitWordsUpdate=employeeNameToUpdate.split("_");
					 String employeeNameFinalToUpdate="";
					 for(String s:splitWordsUpdate)
					 {
						 employeeNameFinalToUpdate=employeeNameFinalToUpdate+s+" ";
					 }
					 System.out.println("Please enter the city: ");
					 String employeeCityUpdate=sc.next();
					 System.out.println("Enter the employee Salary: ");
					 Integer salaryUpdate=sc.nextInt();
					 int resultUpdate=dao.updateEmployee(employeeIdToUpdate, employeeNameFinalToUpdate, employeeCityUpdate, salaryUpdate);
					 System.out.println("The result after executing the update: "+resultUpdate);
					 break;
			case(3):System.out.println("Please enter the employeeId which needs to be deleted");
					Integer employeeIdDelete=sc.nextInt();
					Integer deleteEmployee=dao.deleteEmployee(employeeIdDelete);
					System.out.println("Result after deletion is: "+deleteEmployee);
					break;
			case(4):System.out.println("Enter the employeeId");
					Integer employeeIdFetch=sc.nextInt();
					Employee response=dao.getEmployeeByEmployeeId(employeeIdFetch);
					System.out.println(response.toString());
					break;
			case(5):System.out.println("The employees in the database are: ");
					List<Employee> employees=dao.findEmployees();
					for(Employee e:employees)
					{
						System.out.println(e.toString());
					}
					break;
					
			case(6):System.exit(0);
			default:System.out.println("Enter the correct choice from the above options");
			}
		}
		
		
		
		
	}

}
