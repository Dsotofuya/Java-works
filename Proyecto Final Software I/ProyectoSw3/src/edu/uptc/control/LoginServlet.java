package edu.uptc.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.model.Manager;

/**
 * Servlet implementation class LogiServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Manager manager = new Manager();
		if (manager.validUser(request.getParameter("user_id"), request.getParameter("user_password"))) {
			request.getRequestDispatcher("/addState.jsp").forward(request, response);;
			request.getSession().setAttribute("validCredentialsSwitch", 0);
		} else {
			request.getSession().setAttribute("validCredentialsSwitch", 1);
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

}
