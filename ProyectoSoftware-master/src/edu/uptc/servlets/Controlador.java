package edu.uptc.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("accion");
		switch (action) {
		case "indexEmpleado":
			request.getRequestDispatcher("indexEmpleado.jsp").forward(request, response);
			break;
		case "indexCliente":
			request.getRequestDispatcher("indexCliente.jsp").forward(request, response);
			break;

		case "indexDomiciliario":
			request.getRequestDispatcher("indexDomiciliario.jsp").forward(request, response);
			break;

		case "respuestaReserva":
			request.getRequestDispatcher("respuestaReserva.jsp").forward(request, response);
			break;
		default:
			break;
		}
	}

}
