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
@WebServlet("/update")
public class UpdateController extends HttpServlet{
	
	EmployeeService employeeService=new EmployeeService();
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String email=req.getParameter("email");
//		String name=req.getParameter("name");
		String id=req.getParameter("id");
		int idNo=Integer.parseInt(id);
		
		boolean e3=employeeService.updateEmployeeEmailById(idNo,email);
		if(e3 == true) {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("home.jsp");
			requestDispatcher.forward(req, resp);
		}
		else {
			RequestDispatcher requestDispatcher=req.getRequestDispatcher("update.jsp");
			requestDispatcher.include(req, resp);
		}
		
}

}
