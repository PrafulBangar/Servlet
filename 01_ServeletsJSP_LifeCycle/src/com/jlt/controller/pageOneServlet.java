package com.jlt.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class pageOneServlet
 */
public class pageOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public pageOneServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// RequestDispatcher rd=request.getRequestDispatcher("DisplayServlet");
		
		String name=request.getParameter("txtName");
		HttpSession session=request.getSession();
		session.setAttribute("UserName", name);
		
		RequestDispatcher rd = request.getRequestDispatcher("pageTwo.html");

		rd.forward(request, response);
	}

}
