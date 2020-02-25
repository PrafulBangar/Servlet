package com.jlt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlt.pojo.EmployeeDetaills;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int userId = Integer.valueOf(request.getParameter("txtuserId"));
		int password = Integer.valueOf(request.getParameter("password"));
		
		HttpSession session = request.getSession();
		EmployeeDetaills employee = (EmployeeDetaills) session.getAttribute("Employee");

		if (userId == employee.getEmployeeId() && password ==employee.getPassword()) {
			RequestDispatcher rd = request.getRequestDispatcher("HomeServlet");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("EmployeeLogin.html");
			rd.forward(request, response);

		}
	}

}
