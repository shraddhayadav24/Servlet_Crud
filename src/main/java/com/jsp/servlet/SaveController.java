package com.jsp.servlet;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jsp.servlet.employeedto.Employee;
import com.jsp.servlet.employeeservice.EmployeeService;

@WebServlet("/save")
public class SaveController extends HttpServlet{

	EmployeeService employeeService=new EmployeeService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String salary=req.getParameter("salary");
		String designation=req.getParameter("designation");
		
		double sal=Double.parseDouble(salary);
		Employee employee=new Employee();
		
		employee.setName(name);
		employee.setEmail(email);
		employee.setSalary(sal);
		employee.setDesignation(designation);
		
		
		Employee e1= employeeService.saveEmployee(employee);
		if(e1!=null) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("saved.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("save.jsp");
			requestDispatcher.include(req, resp);
			
		}
	
	}
}
