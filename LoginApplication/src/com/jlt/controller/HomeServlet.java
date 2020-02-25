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
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HomeServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		EmployeeDetaills employee = (EmployeeDetaills) session.getAttribute("Employee");

		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<body>");
		out.println("\nId " + employee.getEmployeeId());
		out.println("\nName " + employee.getName());
		out.println("\nSalary " + employee.getSalary());
		out.println("\n<a href=LogoutServlet>Logout</a>");
		out.print("</body>");
		out.print("</html>");

	}

}
