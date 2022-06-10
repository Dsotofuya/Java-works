package edu.uptc.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.dao.Dao;
import edu.uptc.model.Cliente;
import edu.uptc.model.Reserva;

/**
 * Servlet implementation class reservacionServlet
 */
@WebServlet("/reservacionServlet")
public class reservacionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Dao dao;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public reservacionServlet() {
		super();
		dao = new Dao();
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
		if (!request.getParameter("sucursal").isEmpty() && !request.getParameter("id_reserva").isEmpty()
				&& !request.getParameter("fecha_reserva").isEmpty() && !request.getParameter("hora_reserva").isEmpty()
				&& !request.getParameter("cant_personas").isEmpty()) {

			String sucursal = request.getParameter("sucursal");
			int id = Integer.parseInt(request.getParameter("id_reserva"));
			String fecha = request.getParameter("fecha_reserva");
			String hora = request.getParameter("hora_reserva");
			int cantidad_personas = Integer.parseInt(request.getParameter("cant_personas"));
			int mesa = Integer.parseInt(request.getParameter("id_mesa"));
			
			System.out.println(sucursal + ";id:" + id + ";f:" + fecha + ";h:" + hora + ";cp:" + cantidad_personas+ ";m:" + mesa);
			
			Reserva reserva = new Reserva();
			reserva.setId(id);
			
			Cliente cliente = (Cliente)request.getSession().getAttribute("cliente");
			
			reserva.setCliente(cliente.getCedula());
			reserva.setMesa(mesa);
			reserva.setNumero_personas(cantidad_personas);
			
			System.out.println(reserva.toString());
			try {
				dao.registrarReserva(reserva);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.getRequestDispatcher("Controlador?accion=respuestaReserva").forward(request, response);
		} else {
			System.out.println("llene todos los campos");
			request.getRequestDispatcher("reservarMesa.jsp").forward(request, response);
		}

	}

}
