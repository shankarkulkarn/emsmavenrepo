package com.cg.ems.service;

import java.util.List;
import java.util.Random;

import com.cg.ems.bean.Employee;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dao.EmployeeDaoJdbcImpl;
import com.cg.ems.dao.EmployeeDaoMapImpl;
import com.cg.ems.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeDao  employeeDao;
	
	public EmployeeServiceImpl()
	{
		employeeDao = new EmployeeDaoJdbcImpl();
	}
	
	@Override
	public boolean validateName(String employeeName) {
		boolean flag = false;
		
		flag = employeeName.matches("[a-zA-z]+");
		return flag ;
	}

	@Override
	public int addEmployee(Employee employee) throws EmployeeException {
		
		String name = employee.getEmployeeName();
		boolean flag = validateName(name);
		if( ! flag )
		{
			throw new EmployeeException("Name should contain only characters ");
		}
		Random  random = new Random();
		
		int  id = random.nextInt(100)+1000;
		employee.setEmployeeId(id);
		
		id= employeeDao.addEmployee(employee);
		
		return id ;
	}

	@Override
	public Employee findEmployeeById(int employeeId) throws EmployeeException {
		
		String  empid = String.valueOf(employeeId);
		
		boolean  flag = empid.matches("[0-9]{4}");
		if( ! flag )
		{
			throw new EmployeeException("ID shoud be 4 digits ");
		}
		Employee  employee =employeeDao.findEmployeeById(employeeId);
		return employee;
		
	}

	@Override
	public Employee deleteEmployeeById(int employeeId) throws EmployeeException {
		
		return null;
	}

	@Override
	public List<Employee> findAllEmployee() throws EmployeeException {
		
		return employeeDao.findAllEmployee();
	}

	
	
}
