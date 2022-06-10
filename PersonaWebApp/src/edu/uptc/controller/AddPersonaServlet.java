package edu.uptc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.entity.Historiaclinica;
import edu.uptc.entity.Persona;
import edu.uptc.model.PersonaManager;

/**
 * Servlet implementation class AddPersonaServlet
 */
@WebServlet("/AddPersonaServlet")
public class AddPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String documento = request.getParameter("documento");
		String tipo = request.getParameter("tipo");
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		Persona persona = new Persona();
		persona.setDocumento(documento);
		persona.setTipo_documento(tipo);
		persona.setNombres(nombres);
		persona.setApellidos(apellidos);
		Historiaclinica hc = new Historiaclinica();
		int id = Integer.valueOf(documento);
		hc.setId(id);
		hc.setPersona(persona);
		persona.setHistoriaclinica(hc);
		PersonaManager pm = new PersonaManager();
		boolean res=false;
		res = pm.addPersona(persona);
		if (res) {
			request.setAttribute("a", "easldaslda");
			request.getRequestDispatcher("GenericResponseTrue.jsp").forward(request, response);
//			PrintWriter out;
//			 out = response.getWriter();
//			 response.setContentType("text/html");
//			 out.println("<html>");
//			 out.println("<head><title>Add Persona</title>");
//			 out.println("<title>Add Persona</title>");
//			 out.println("<style><%@include file=\"/css/vehStyle.css\"%></style></head>");
//			 out.println("</head>");
//			 out.println("<body>");
//			 out.println("<h1>La persona ha sido adicionada exitosamente!</h1>");
//			 out.println("<h2><a href=\"index.jsp\"> Volver a la p�gina inicial!</h2>");
//			 out.println("</body></html>");
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
