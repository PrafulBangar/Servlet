package com.jlt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/BookListServlet")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<String> bookList = new ArrayList<String>();
		/*
		 * String bookName = request.getParameter("txtbookname"); PrintWriter out =
		 * response.getWriter(); HttpSession session = request.getSession();
		 */
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		out.print("<html>");
		out.print("<body>");
		out.println("</table>");

		out.println("<table border=1>");

		if (session.getAttribute("bookList") != null) {
			out.println("<tr><td>number<td>BookName");
			bookList = (ArrayList<String>) session.getAttribute("bookList");
			System.out.println(bookList);
			for (int i = 0; i <= bookList.size(); i++) {
				out.println("<tr><td>" + i + "<td>" + bookList.get(i));

			}
			out.print("<a href='Books.html'>Add More</a>");
			out.print("</body>");
			out.print("</html>");

		}
	}

}
