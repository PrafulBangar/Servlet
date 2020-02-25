package com.jlt.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jlt.dao.EmployeeDao;

/**
 * Servlet implementation class EmployeeCRUDServLet
 */
@WebServlet("/EmployeeCRUDServLet")
public class EmployeeCRUDServLet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String option = request.getParameter("option");

		switch (option) {
		case "Add Employee":
			response.sendRedirect("addEmployee.html");
			break;
		case "Delete":
			int employeeId = Integer.valueOf(request.getParameter("dbAction"));
			if (new EmployeeDao().deleteEmployee(employeeId))
				response.sendRedirect("Index.jsp");
			break;
		}
	}

}
