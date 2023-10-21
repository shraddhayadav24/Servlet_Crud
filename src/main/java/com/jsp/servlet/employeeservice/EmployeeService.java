package com.jsp.servlet.employeeservice;

import java.util.List;

import com.jsp.servlet.employeedao.EmployeeDao;
import com.jsp.servlet.employeedto.Employee;

public class EmployeeService {
	EmployeeDao employeeDao=new EmployeeDao();
	
	
	public Employee saveEmployee(Employee employee) {
		if(employee.getName()!=null && employee.getEmail()!=null && employee.getDesignation()!=null && employee.getSalary()>0) {
			return employeeDao.saveEmployee(employee);
		}
		return null;
	}
	
	public boolean deleteEmployeeById(int id) {
		return employeeDao.deleteEmployeeById(id);
	}
	
	public boolean updateEmployeeEmailById( int id, String email) {
		return employeeDao.updateEmployeeEmailById(id,email);
	}
	
	public List<Employee> getall(){
		return employeeDao.getall();
	}
}
