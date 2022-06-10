package edu.uptc.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.entity.Persona;
import edu.uptc.model.PersonaManager;

/**
 * Servlet implementation class SaveUpdPersonaServlet
 */
@WebServlet("/SaveUpdPersonaServlet")
public class SaveUpdPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonaManager pm = new PersonaManager();
	private Persona persona = new Persona();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveUpdPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String documento = request.getParameter("documento");
		String tipo = request.getParameter("tipo");
		String nombres = request.getParameter("nombres");
		String apellidos = request.getParameter("apellidos");
		System.out.println("Update persona doc: "+documento+" tipo: "+tipo+" nombre: "+nombres);
		persona.setDocumento(documento);
		persona.setTipo_documento(tipo);
		persona.setNombres(nombres);
		persona.setApellidos(apellidos);
		pm.updatePersona(persona);
		PrintWriter out;
	    out = response.getWriter();
        response.setContentType("text/html");
		out.println("<html>");
		out.println("<head><title>Formulario Empleado</title></head>");
		out.println("<body>");
		out.println("<h1> PERSON APP</h1>");
		out.println("<h2> Persona actualizada exitosamente! </h2>");
		out.println("<a href=\"index.jsp\"> Volver a la página inicial!</h2>");
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
