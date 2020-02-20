package com.cg.ems.pl;

import java.util.List;
import java.util.Scanner;

import com.cg.ems.bean.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;

public class Client {

	public static void main(String[] args) {
		
		Scanner  scanner  = new Scanner(System.in);
		EmployeeService  employeeService = new EmployeeServiceImpl();
        int choice = 0;
        Employee  employee= null;
        List<Employee>  list =null;
        while(choice!=5)
        {
        	System.out.println("1.Add Employee ");
        	System.out.println("2.Search Employee ");
        	
        	System.out.println("3.Delete Employee ");
        	System.out.println("4.List all Employees ");
        	System.out.println("5.Exit ");
        	
        	System.out.println(" Enter your Choice ");
        	choice = scanner.nextInt(); 
        	
        	switch(choice)
        	{
        	case   1 :  System.out.println(" Enter Name "); 
        				scanner.nextLine();
        				String name = scanner.nextLine();
        				System.out.println(" Enter date of birth ");
        				String str = scanner.nextLine();
        				
        				System.out.println(" Enter Salary ");
        				double salary = scanner.nextDouble();
        				employee = new Employee();
        				employee.setEmployeeName(name);
        				employee.setSalary(salary);
        				try
        				{
        				int id = employeeService.addEmployee(employee);
        				System.out.println(" Employee Id = "+id);
        				}catch(EmployeeException e)
        				{
        					System.err.println(e.getMessage());
        				}
        				break;
        	case   2 :  System.out.println("Enter Employee Id ");
        				int id = scanner.nextInt();
        				
        				try
        				{
        				employee = employeeService.findEmployeeById(id);
        				System.out.println(" Name  = "+employee.getEmployeeName());
        				System.out.println(" Salary =" +employee.getSalary());
        				}catch(EmployeeException e)
        				{
        					System.err.println(e.getMessage());
        				}
        			    break;
        	
        	case   3 :  
        				
        				break;
        	case   4 :  
        		 		try {
        		       list = employeeService.findAllEmployee();
        		       for(Employee  emp : list)
        		       {
        		    	id = emp.getEmployeeId();
        		    	name = emp.getEmployeeName();
        		    	salary = emp.getSalary();
        		    	System.out.println(id+"  "+name+"  "+salary);
        		       }
        		 		}catch(EmployeeException e)
        		 		{
        		 			System.out.println(e.getMessage());
        		 		}
        		       break;
        	case   5 :  
        				System.out.println(" Thank you take break ");
        				return;
        	
        	
        	}
        	
        }
        
        
        
		
		
		
	}

}
