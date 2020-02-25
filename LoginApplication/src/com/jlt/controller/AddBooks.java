package com.jlt.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AddBooks
 */
@WebServlet("/AddBooks")
public class AddBooks extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddBooks() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<String> bookList;
		String bookName = request.getParameter("txtbookname");
		System.out.println(bookName);
		HttpSession session = request.getSession();

		if (session.getAttribute("bookList") == null) {
			bookList = new ArrayList<String>();
			if (!bookList.contains(bookName))
				bookList.add(bookName);
			System.out.println(bookList);
			session.setAttribute("bookList", bookList);
		} else {

			bookList = (ArrayList<String>) session.getAttribute("bookList");
			if (!bookList.contains(bookName))
				bookList.add(bookName);
			session.setAttribute("bookList", bookList);
		}
		System.out.println(session);

		response.sendRedirect("BookListServlet");

	}

}
