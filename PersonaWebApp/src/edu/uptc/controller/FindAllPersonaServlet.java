package edu.uptc.controller;

import java.io.IOException;
import java.util.List;

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
@WebServlet("/FindAllPersonaServlet")
public class FindAllPersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PersonaManager pm = new PersonaManager();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FindAllPersonaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Persona> allPersonas = pm.findAllPersona();
		System.out.println("FindAllPersonas size: "+allPersonas.size());
		request.getSession().setAttribute("listPersona", allPersonas);
		System.out.println("FindAllPersonas antes dispatcher");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/findAllPersons.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Persona> allPersonas = pm.findAllPersona();
		request.getSession().setAttribute("listPersona", allPersonas);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/findAllPersons.jsp");
        dispatcher.forward(request, response);
	}
	
}
