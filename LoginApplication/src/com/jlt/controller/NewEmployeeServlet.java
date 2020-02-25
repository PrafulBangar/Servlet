package com.jlt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlt.pojo.EmployeeDetaills;

/**
 * Servlet implementation class NewEmployeeServlet
 */
@WebServlet("/NewEmployeeServlet")
public class NewEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NewEmployeeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("txtname");
		int userId = Integer.valueOf(request.getParameter("txtuserId"));
		double salary = Integer.valueOf(request.getParameter("txtsalary"));
		int password = Integer.valueOf(request.getParameter("password"));

		EmployeeDetaills emp = new EmployeeDetaills(userId, name, salary, password);

		HttpSession session = request.getSession();
		session.setAttribute("Employee", emp);

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.println("Registration Success for " + emp.getName());
		out.print("<a href='EmployeeLogin.html'>Login</a>");
		out.print("</body>");
		out.print("</html>");

	}

}
