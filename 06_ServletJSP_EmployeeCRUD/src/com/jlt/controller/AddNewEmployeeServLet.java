package com.jlt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlt.dao.EmployeeDao;

@WebServlet("/AddNewEmployeeServLet")
public class AddNewEmployeeServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String firstName = request.getParameter("txtFirstName");
		String lastName = request.getParameter("txtLastName");
		double salary = Double.valueOf(request.getParameter("txtSalary"));
		String email = request.getParameter("txtEmail");

		Employee employee = new Employee(0, firstName, lastName, salary, email);

		EmployeeDao employeeDao = new EmployeeDao();
		if (employeeDao.addNewEmployee(employee)) {
			response.sendRedirect("Index.jsp");
		} else {
			response.sendRedirect("error.jsp");
		}
		System.out.println(employee);
		System.out.println(firstName);
		System.out.println(lastName);
		System.out.println(salary);
		System.out.println(email);

	}

}
