package edu.uptc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.uptc.entity.Persona;
import edu.uptc.model.PersonaManager;

/**
 * Servlet implementation class UpdatePersonaServlet
 */
@WebServlet("/UpdatePersonaServlet")
public class UpdatePersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonaManager pm = new PersonaManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = (String)request.getParameter("person_id");
		Persona persona = pm.findPersonaPK(id);
		request.setAttribute("documento", persona.getDocumento());
		request.setAttribute("tipo", persona.getTipo_documento());
		request.setAttribute("nombres", persona.getNombres());
		request.setAttribute("apellidos", persona.getApellidos());
		RequestDispatcher dispatcher = request.getRequestDispatcher("/updatePerson.jsp");
        dispatcher.forward(request, response);
		//response.sendRedirect(request.getContextPath() + "/updatePerson.jsp");
	}
	
}
