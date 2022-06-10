package edu.uptc.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import edu.uptc.dao.Dao;
import edu.uptc.model.Cliente;
import edu.uptc.model.Domiciliario;
import edu.uptc.model.Empleado;

/**
 * Servlet implementation class ServletCliente
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
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
		// TODO Auto-generated method stub
		doGet(request, response);

		Dao dao = new Dao();

		if (!request.getParameter("mail_login").isEmpty() && !request.getParameter("password_login").isEmpty()) {
			String correo = request.getParameter("mail_login");
			String contraseña = request.getParameter("password_login");

			if (dao.isEmpleado(correo, contraseña)) {
				try {
					Empleado e = dao.obtenerEmpleado(correo, contraseña);
					System.out.println(e.toString());
					System.out.println("es empleado");

					HttpSession session = request.getSession();
					session.setAttribute("emp_nombre", e.getNombres());
					session.setAttribute("empleado", e);
					request.getRequestDispatcher("Controlador?accion=indexEmpleado").forward(request, response);
				} catch (ClassNotFoundException | SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (dao.isCliente(correo, contraseña)) {
				try {
					Cliente c = dao.obtenerCliente(correo, contraseña);

					System.out.println(c.toString());
					System.out.println("es un cliente");

					HttpSession session = request.getSession();
					session.setAttribute("cli_nombre", c.getNombres());
					session.setAttribute("cliente", c);

					request.getRequestDispatcher("Controlador?accion=indexCliente").forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else if (dao.isDomiciliario(correo, contraseña)) {
				try {
					Domiciliario domiciliario = dao.obtenerDomiciliario(correo, contraseña);

					System.out.println(domiciliario.toString());
					System.out.println("es domiciliario");

					HttpSession session = request.getSession();
					session.setAttribute("dom_nombre", domiciliario.getNombres());
					session.setAttribute("domiciliario", domiciliario);

					request.getRequestDispatcher("Controlador?accion=indexDomiciliario").forward(request, response);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			} else {
				System.out.println(
						"no hay ningun usuario registardo con estos datos, verifique errores y vuelva a intentarlo");
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		} else {
			System.out.println("llene los campos");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
//		if (!request.getParameter("mail_login").isEmpty() && !request.getParameter("password_login").isEmpty()) {
//			String correo = request.getParameter("mail_login");
//			String contraseña = request.getParameter("password_login");
//
//			try {
//				Empleado e = dao.obtenerEmpleado(correo, contraseña);
//				if (e != null) {
//					System.out.println(e.toString());
//					request.getRequestDispatcher("Controlador?accion=indexCliente").forward(request, response);
//				} else {
//					request.getRequestDispatcher("login.jsp").forward(request, response);
//				}
//
//			} catch (ClassNotFoundException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			} catch (SQLException e1) {
//				// TODO Auto-generated catch block
//				e1.printStackTrace();
//			}
//
//		} else {
//			request.getRequestDispatcher("login.jsp").forward(request, response);
//			System.out.println("llene los campos");
//		}
	}

}
