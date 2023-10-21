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

@WebServlet("/delete")
public class DeleteController extends HttpServlet{
	
	EmployeeService employeeService=new EmployeeService();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id=req.getParameter("id");
		
		int idNo=Integer.parseInt(id);
		
		boolean e2=employeeService.deleteEmployeeById(1);
		if(e2 == true) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("deleted.jsp");
					requestDispatcher.forward(req, resp);
		}else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("delete.jsp");
			requestDispatcher.include(req, resp);
		}
	}
	
}
