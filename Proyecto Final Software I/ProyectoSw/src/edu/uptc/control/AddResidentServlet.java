package edu.uptc.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.entity.RealStateID;
import edu.uptc.entity.Resident;
import edu.uptc.model.manager;

public class AddResidentServlet extends HttpServlet {
	private static final long serialVersionUID = -8154094589090347665L;

	public AddResidentServlet() {
		 super();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String resident_id = request.getParameter("resident_id");
		String resident_name = request.getParameter("resident_name");
		String resident_last_name = request.getParameter("resident_last_name");
		String resident_phone_number = request.getParameter("resident_phone_number");
		
		String address = request.getParameter("address");
		String block  = request.getParameter("block");
		int internal_id = Integer.parseInt(request.getParameter("internal_id"));

		RealStateID realStateID = new RealStateID(address, block, internal_id);
		Resident resident = new Resident(resident_id, resident_name, resident_last_name, resident_phone_number, realStateID);
		System.out.println("xdddddddddddddddddddddddddd");
		manager m = new manager();
		boolean res=false;
		res = m.addResident(resident);
		if (res) {
			PrintWriter out;
			 out = response.getWriter();
			 response.setContentType("text/html");
			 out.println("<html>");
			 out.println("<head><title>Add Persona</title>");
			 out.println("<title>Add Persona</title>");
			 out.println("<style><%@include file=\"/css/vehStyle.css\"%></style></head>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("<h1>La persona ha sido adicionada exitosamente!</h1>");
			 out.println("<h2><a href=\"index.jsp\"> Volver a la p�gina inicial!</h2>");
			 out.println("</body></html>");
		}else {
			PrintWriter out;
			 out = response.getWriter();
			 response.setContentType("text/html");
			 out.println("<html>");
			 out.println("<head><title>Add Persona</title>");
			 out.println("<title>Add Persona</title>");
			 out.println("<style><%@include file=\"/css/vehStyle.css\"%></style></head>");
			 out.println("</head>");
			 out.println("<body>");
			 out.println("<h1>Error en la adici�n de la persona!</h1>");
			 out.println("<h2><a href=\"index.jsp\"> Volver a la p�gina inicial!</h2>");
			 out.println("</body></html>");
		}
	}
}
